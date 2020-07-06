package easybus;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InsertMenu
{
    private JFrame mainFrame;
    private JPanel controlPanel;

    private JLabel headerLabel;
    private JButton saveButton;

    private JLabel labels[];
    private JTextField inputField[];
    //private JTextField textField[];

    public InsertMenu()
    {
        // WINDOW DEFINITIONS
        mainFrame = new JFrame("[easyBus] Insert");
        controlPanel = new JPanel();

        mainFrame.getContentPane();
        mainFrame.setSize(Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        controlPanel.setLayout(null);

        // COMPONENETS INIT
        headerLabel = new JLabel("Entering new " + Globals.getCurrentData());
        saveButton = new JButton("Save");
        prepareInsertMenu();

        // COMPONENTS TO PANEL
        headerLabel.setBounds((Globals.WINDOW_WIDTH/3)+50+120, 50, 150, 35);

        mainFrame.add(controlPanel);
        controlPanel.add(saveButton);
        controlPanel.add(headerLabel);

        // EVENTS
        saveButton.addActionListener(new InsertMenu.ButtonClickListener());

        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String values[] = new String[inputField.length];
            for(int i = 0; i < inputField.length; i++) values[i] = inputField[i].getText();

            try {
                ValidateData(values);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    private boolean ValidateData(String[] values) throws IOException
    {
        //boolean isValid = true;

        switch(Globals.getCurrentData()) {
            case VEHICLE:
                //labelTexts = new String[]{"licenseNum", "Model", "Year", "Fuel", "yearlyCost", "Seats"};
                Bus newBus = new Bus(Integer.parseInt(values[4]), Integer.parseInt(values[3]), Integer.parseInt(values[0]),
                        values[1], Integer.parseInt(values[2]), Integer.parseInt(values[5]));

                Globals.cars.insert(newBus);
                Globals.save(Globals.Data.VEHICLE);
                break;

            case STATION:
                //labelTexts = new String[]{"stationId", "posX", "posY"};
                Station newStation = new Station(Integer.parseInt(values[0]), Integer.parseInt(values[1]));

                Globals.stations.insert(newStation);
                Globals.save(Globals.Data.STATION);
                break;

            case ROUTE:
                //labelTexts = new String[]{"startStation ID", "endStation ID"};
                Lineroute newRoute = new Lineroute(Globals.stations.getStation(Integer.parseInt(values[0])), Globals.stations.getStation(Integer.parseInt(values[1])));

                Globals.routes.insert(newRoute);
                Globals.save(Globals.Data.ROUTE);
                break;

            case PASSENGER:
                //labelTexts = new String[]{"Id", "Name", "Sex", "Age", "dateOfSub", "Credit"};
                Passenger newCustomer = new Passenger(Integer.parseInt(values[5]), Integer.parseInt(values[0]), values[4],
                        values[1], values[2], Integer.parseInt(values[3]));

                Globals.customers.insert(newCustomer);
                Globals.save(Globals.Data.PASSENGER);
                break;

            case WORKER:
                //labelTexts = new String[]{"Id", "Name", "Sex", "Age", "Experience (year)", "Salary"};
                // public Busdriver(String name, int id, String sex, int age, int yearExp, int salary)
                Busdriver newWorker = new Busdriver(values[1], Integer.parseInt(values[0]), values[2],
                        Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5]));

                Globals.workers.insert(newWorker);
                Globals.save(Globals.Data.WORKER);
                break;
        }


        //if(isValid)
        //    Save();

        return true;
    }

    private void Save() {
        //..
    }

    private void prepareInsertMenu() {
        int j = 0;
        int x_label = (Globals.WINDOW_WIDTH/3)-50+90; // 140
        int x_input = (Globals.WINDOW_WIDTH/3)+50+90; // 240
        int y = 50;
        String labelTexts[];
        switch(Globals.getCurrentData()) {
            case VEHICLE:
                labelTexts = new String[]{"licenseNum", "Model", "Year", "Fuel", "yearlyCost", "Seats"};
                inputField = new JTextField[labelTexts.length];
                y = createDynamicElements(labelTexts, j, x_label, x_input, y);

                break;
            case STATION:
                labelTexts = new String[]{"posX", "posY"};
                inputField = new JTextField[labelTexts.length];
                y = createDynamicElements(labelTexts, j, x_label, x_input, y);

                break;
            case ROUTE:
                labelTexts = new String[]{"startStation ID", "endStation ID"};
                inputField = new JTextField[labelTexts.length];
                y = createDynamicElements(labelTexts, j, x_label, x_input, y);

                break;
            case PASSENGER:
                labelTexts = new String[]{"Id", "Name", "Sex", "Age", "dateOfSub", "Credit"};
                inputField = new JTextField[labelTexts.length];
                y = createDynamicElements(labelTexts, j, x_label, x_input, y);

                break;
            case WORKER:
                labelTexts = new String[]{"Id", "Name", "Sex", "Age", "Experience (year)", "Salary"};
                inputField = new JTextField[labelTexts.length];
                y = createDynamicElements(labelTexts, j, x_label, x_input, y);

                break;
        }

        saveButton.setBounds(x_input, y+40, 200, 35);
    }
    private int createDynamicElements(String labelNames[], int j, int x_label, int x_input, int y) {
        labels = new JLabel[inputField.length];

        for(int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(labelNames[j++] + ":");
            y += 40;
            labels[i].setBounds(x_label, y, 90, 35);
            controlPanel.add(labels[i]);
        }

        y = 50;
        for(int i = 0; i < inputField.length; i++) {
            inputField[i] = new JTextField();
            y += 40;
            inputField[i].setBounds(x_input, y, 200, 35);
            controlPanel.add(inputField[i]);
        }

        return y;
    }
}
