package easybus.Controller;

import easybus.Model.*;
import easybus.View.InsertMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InsertController
{
    enum ERROR_VALIDATION {
        EXISTS,
        WRONG_LICENSE,
        NOT_EXISTS,
        SAME_STATIONS,
        ROUTE_COMBO_EXITS,
        WRONG_INPUT_TYPE
    };

    private ERROR_VALIDATION error;
    private DataController model;
    private InsertMenu view;

    public InsertController(DataController model, InsertMenu view){
        this.model = model;
        this.view = view;
        this.error = ERROR_VALIDATION.EXISTS;

        initViewActionListeners();
        view.setSet(model.getSelected().toString());
        prepareInsertMenu();
    }

    private void initViewActionListeners() {
        view.initButtons(new InsertController.CloseListener());
    }
    public void setError(ERROR_VALIDATION e) { error = e; }
    public ERROR_VALIDATION getError() { return error; }

    public class CloseListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            boolean canContinue = true;

            String values[] = new String[view.getFieldsLength()];
            for(int i = 0; i < view.getFieldsLength(); i++)
                values[i] = view.getField(i).getText();

            try {
                for (String v: values) {
                    if(v.isEmpty())
                        canContinue = false;
                }
                if(canContinue)
                    ValidateData(values);
                else
                    JOptionPane.showMessageDialog(null, "You can't have blank fields!",
                            "Error Message", JOptionPane.ERROR_MESSAGE);

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private void ValidateData(String[] values) throws IOException
    {
        boolean isValid = false;
        switch(model.getSelected()) {
            case CAR:
                //labelTexts = new String[]{"licenseNum", "Model", "Year", "Fuel", "yearlyCost", "Seats"};
                //                              0           1       2       3           4           5
                if(Globals.isInt(new String[]{ values[0], values[2], values[3], values[4], values[5] })) {
                    if(model.getCarModel().findCar(Integer.parseInt(values[0])) != null) {
                        setError(ERROR_VALIDATION.EXISTS);
                        break;
                    }

                    if(!model.getCarModel().isValidLicense(values[0])) {
                        setError(ERROR_VALIDATION.WRONG_LICENSE);
                        break;
                    }

                    if(Integer.parseInt(values[5]) >= Bus.getMinPassengers()) { // is bus
                        Bus newBus = new Bus(Integer.parseInt(values[4]), Integer.parseInt(values[3]), Integer.parseInt(values[0]),
                                values[1], Integer.parseInt(values[2]), Integer.parseInt(values[5]));

                        model.getCarModel().addCar(newBus);
                        isValid = true;
                    } else { // is minibus
                        Minibus newMiniBus = new Minibus(Integer.parseInt(values[4]), Integer.parseInt(values[3]), Integer.parseInt(values[0]),
                                values[1], Integer.parseInt(values[2]), Integer.parseInt(values[5]));

                        model.getCarModel().addCar(newMiniBus);
                        isValid = true;
                    }
                } else
                    setError(ERROR_VALIDATION.WRONG_INPUT_TYPE);

                break;

            case STATION:
                //labelTexts = new String[]{"stationId", "posX", "posY"};
                if(Globals.isInt(new String[]{ values[0], values[1] })) {
                    Station newStation = new Station(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
                    model.getStationModel().addStation(newStation);
                    isValid = true;
                } else
                    setError(ERROR_VALIDATION.WRONG_INPUT_TYPE);

                break;

            case ROUTE:
                //labelTexts = new String[]{"startStation ID", "endStation ID"};
                if(model.getStationModel().findStation(Integer.parseInt(values[0])) == null) {
                    setError(ERROR_VALIDATION.NOT_EXISTS);
                    break;
                }

                if(model.getStationModel().findStation(Integer.parseInt(values[1])) == null) {
                    setError(ERROR_VALIDATION.NOT_EXISTS);
                    break;
                }

                if(Integer.parseInt(values[0]) == Integer.parseInt(values[1])) {
                    setError(ERROR_VALIDATION.SAME_STATIONS);
                    break;
                }

                if(Globals.isInt(new String[]{ values[0], values[1] }))  {
                    Lineroute newRoute = new Lineroute(model.getStationModel().findStation(Integer.parseInt(values[0])),
                            model.getStationModel().findStation(Integer.parseInt(values[1])));

                    model.getRouteModel().addRoute(newRoute);
                    isValid = true;

                } else
                    setError(ERROR_VALIDATION.WRONG_INPUT_TYPE);

                break;

            case PASSENGER:
                //labelTexts = new String[]{"Id", "Name", "Sex", "Age", "dateOfSub", "Credit"};
                if(Globals.isInt(new String[]{ values[5], values[0], values[3] })) {
                    if(model.getPassengerModel().findPassenger(Integer.parseInt(values[0])) != null) {
                        setError(ERROR_VALIDATION.EXISTS);
                        break;
                    }

                    Passenger newPassenger = new Passenger(Integer.parseInt(values[5]), Integer.parseInt(values[0]), values[4],
                            values[1], values[2], Integer.parseInt(values[3]));

                    model.getPassengerModel().addPassenger(newPassenger);
                    isValid = true;

                } else
                    setError(ERROR_VALIDATION.WRONG_INPUT_TYPE);

                break;

            case WORKER:
                //labelTexts = new String[]{"Id", "Name", "Sex", "Age", "Experience (year)", "Salary"};
                if(Globals.isInt(new String[]{ values[0], values[3], values[4], values[5] })) {
                    if(model.getWorkerModel().findWorker(Integer.parseInt(values[0])) != null) {
                        setError(ERROR_VALIDATION.EXISTS);
                        break;
                    }

                    Busdriver newWorker = new Busdriver(values[1], Integer.parseInt(values[0]), values[2],
                            Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]));

                    model.getWorkerModel().addWorker(newWorker);
                    isValid = true;

                } else
                    setError(ERROR_VALIDATION.WRONG_INPUT_TYPE);

                break;
        }

        if(!isValid) {
            String e_msg = "ERROR?!";
            switch (getError()) {
                case EXISTS:
                    e_msg = "This id already exists!\nPlease choose a different one";
                    break;

                case WRONG_LICENSE:
                    e_msg = "You have entered an invalid license!\n License number is within 6 or 7 digits";
                    break;

                case NOT_EXISTS:
                    e_msg = "This station ID does not exists!\nYou must enter a valid Station ID";
                    break;

                case SAME_STATIONS:
                    e_msg = "You have entered the same station!\nYou must use 2 different stations";
                    break;

                case WRONG_INPUT_TYPE:
                    e_msg = "You have entered an invalid input type!\n Please correct your data";
                    break;
            }

            JOptionPane.showMessageDialog(null, e_msg,
                    "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "You have entered a new " + model.getSelected().toString() + "!",
                    "Success Message", JOptionPane.INFORMATION_MESSAGE);
    }

    private void prepareInsertMenu() {
        int x_label = (Globals.WINDOW_WIDTH/3)-40;
        int x_input = (Globals.WINDOW_WIDTH/3)+140;
        int y = 50;
        String labelTexts[] = new String[0];

        switch(model.getSelected()) {
            case CAR:
                labelTexts = model.getCarModel().getColumns();
                break;

            case STATION:
                labelTexts = model.getStationModel().getColumns();
                break;

            case ROUTE:
                labelTexts = model.getRouteModel().getColumns();
                break;

            case PASSENGER:
                labelTexts = model.getPassengerModel().getColumns();
                break;

            case WORKER:
                labelTexts = model.getWorkerModel().getColumns();
                break;
        }

        view.setField(labelTexts);
        y = createDynamicElements(labelTexts, 0, x_label, x_input, y);
        view.setSaveButtonLoc(x_input, y+40, 200, 35);
    }

    private int createDynamicElements(String labelNames[], int j, int x_label, int x_input, int y) {
        view.setLabels(view.getFieldsLength());

        for(int i = 0; i < view.getLabelsLength(); i++) {
            j = view.setLabel(i, labelNames, j);
            y += 40;
            view.getLabel(i).setBounds(x_label, y, 90, 35);
            view.addLabelToPane(i);
        }

        y = 50;
        for(int i = 0; i < view.getFieldsLength(); i++) {
            view.initField(i);
            y += 40;
            view.getField(i).setBounds(x_input, y, 200, 35);
            view.addFieldToPane(i);
        }

        return y;
    }
}
