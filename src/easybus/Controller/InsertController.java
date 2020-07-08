package easybus.Controller;

import easybus.Model.*;
import easybus.View.InsertMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InsertController
{
    private DataController model;
    private InsertMenu view;

    public InsertController(DataController model, InsertMenu view){
        this.model = model;
        this.view = view;

        initViewActionListeners();
        view.setSet(model.getSelected().toString());
        prepareInsertMenu();
    }

    private void initViewActionListeners() {
        view.initButtons(new InsertController.CloseListener());
    }

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
                    JOptionPane.showMessageDialog(null, "You have a blank field!",
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
                if(Globals.isInt(new String[]{ values[4], values[3], values[0], values[2], values[5] })) {
                    Bus newBus = new Bus(Integer.parseInt(values[4]), Integer.parseInt(values[3]), Integer.parseInt(values[0]),
                            values[1], Integer.parseInt(values[2]), Integer.parseInt(values[5]));

                    model.getCarModel().addCar(newBus);
                    isValid = true;
                }
                break;

            case STATION:
                //labelTexts = new String[]{"stationId", "posX", "posY"};
                if(Globals.isInt(new String[]{ values[0], values[1] })) {
                    Station newStation = new Station(Integer.parseInt(values[0]), Integer.parseInt(values[1]));

                    model.getStationModel().addStation(newStation);
                    isValid = true;
                }
                break;

            case ROUTE:
                //labelTexts = new String[]{"startStation ID", "endStation ID"};
                if(model.getStationModel().findStation(Integer.parseInt(values[0])) != null && model.getStationModel().findStation(Integer.parseInt(values[1])) != null) {
                    if(Globals.isInt(new String[]{ values[0], values[1] })) {
                        Lineroute newRoute = new Lineroute(model.getStationModel().findStation(Integer.parseInt(values[0])),
                                model.getStationModel().findStation(Integer.parseInt(values[1])));

                        model.getRouteModel().addRoute(newRoute);
                        isValid = true;
                    }
                }
                break;

            case PASSENGER:
                //labelTexts = new String[]{"Id", "Name", "Sex", "Age", "dateOfSub", "Credit"};
                if(Globals.isInt(new String[]{ values[5], values[0], values[3] })) {
                    Passenger newPassenger = new Passenger(Integer.parseInt(values[5]), Integer.parseInt(values[0]), values[4],
                            values[1], values[2], Integer.parseInt(values[3]));

                    model.getPassengerModel().addPassenger(newPassenger);
                    isValid = true;
                }
                break;

            case WORKER:
                //labelTexts = new String[]{"Id", "Name", "Sex", "Age", "Experience (year)", "Salary"};
                if(Globals.isInt(new String[]{ values[0], values[3], values[4], values[5] })) {
                    Busdriver newWorker = new Busdriver(values[1], Integer.parseInt(values[0]), values[2],
                            Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]));

                    model.getWorkerModel().addWorker(newWorker);
                    isValid = true;
                }
                break;
        }


        if(!isValid)
            JOptionPane.showMessageDialog(null, "You have entered an invalid value! (String)\nPlease fix your errors!",
                    "Error Message", JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "You have entered a new " + model.getSelected().toString() + "!",
                    "Success Message", JOptionPane.INFORMATION_MESSAGE);
    }

    private void prepareInsertMenu() {
        int x_label = (Globals.WINDOW_WIDTH/3)-50+90; // 140
        int x_input = (Globals.WINDOW_WIDTH/3)+50+90; // 240
        int y = 50;
        String labelTexts[] = new String[0];

        switch(model.getSelected()) {
            case CAR:
                labelTexts = new String[]{"licenseNum", "Model", "Year", "Fuel", "yearlyCost", "Seats"};
                break;

            case STATION:
                labelTexts = new String[]{"posX", "posY"};
                break;

            case ROUTE:
                labelTexts = new String[]{"startStation ID", "endStation ID"};
                break;

            case PASSENGER:
                labelTexts = new String[]{"Id", "Name", "Sex", "Age", "dateOfSub", "Credit"};
                break;

            case WORKER:
                labelTexts = new String[]{"Id", "Name", "Sex", "Age", "Experience (year)", "Salary"};
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
