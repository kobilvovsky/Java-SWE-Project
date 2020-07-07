package easybus.View;

import easybus.Model.Globals;
import easybus.Model.Lineroute;
import easybus.Model.Station;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ViewMenu
{
    private JFrame mainFrame;
    private JPanel controlPanel;

    private JButton deleteButton;
    private JTable table;
    private JScrollPane scrollPane;

    String[][] data;
    String[] header;

    public ViewMenu()
    {
        // WINDOW DEFINITIONS
        mainFrame = new JFrame("[easyBus] View");
        controlPanel = new JPanel();

        mainFrame.getContentPane();
        mainFrame.setSize(Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);

        // COMPONENETS INIT
        deleteButton = new JButton("Delete");
        prepareViewTable();

        // COMPONENETS LOCATION
        controlPanel.setLayout(new BorderLayout());
        deleteButton.setBounds(Globals.WINDOW_WIDTH-Globals.WINDOW_WIDTH/16, 500, 70, 35);

        // COMPONENTS TO PANEL
        mainFrame.add(controlPanel);
        controlPanel.add(scrollPane, BorderLayout.CENTER);
        controlPanel.add(deleteButton, BorderLayout.SOUTH);

        // EVENTS
        deleteButton.addActionListener(new ButtonClickListener());
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            boolean success = false;
            int column = 0;
            int row = table.getSelectedRow();
            String value = table.getModel().getValueAt(row, column).toString();

            switch(Globals.getCurrentData()) {
                case VEHICLE:
                    try {
                        Globals.cars.remove(Globals.cars.getCarById(Integer.parseInt(value)));
                        Globals.save(Globals.Data.VEHICLE);
                        success = true;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;

                case STATION:
                    try {
                        Globals.stations.remove(Globals.stations.getStationById(Integer.parseInt(value)));
                        Station.counter = Globals.stations.getElement(Globals.stations.getSize()-1).getStationId() + 1;
                        Globals.save(Globals.Data.STATION);
                        success = true;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;

                case ROUTE:
                    try {
                        Globals.routes.remove(Globals.routes.getRouteById(Integer.parseInt(value)));
                        Lineroute.counter = Globals.routes.getElement(Globals.routes.getSize()-1).getRouteIndex() + 1;
                        Globals.save(Globals.Data.ROUTE);
                        success = true;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;

                case PASSENGER:
                    try {
                        Globals.customers.remove(Globals.customers.getPassengerById(Integer.parseInt(value)));
                        Globals.save(Globals.Data.PASSENGER);
                        success = true;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;

                case WORKER:
                    try {
                        Globals.workers.remove(Globals.workers.getWorkerById(Integer.parseInt(value)));
                        Globals.save(Globals.Data.WORKER);
                        success = true;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    break;

            }

            if(success)
                JOptionPane.showMessageDialog(null, "You have deleted a " + Globals.getCurrentData().toString() + " of id " + value + "!",
                    "Success Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void prepareViewTable() {
        int j = 0;
        switch(Globals.getCurrentData()) {
            case VEHICLE:
                header = new String[]{"licenseNum", "Model", "Year", "Fuel", "yearlyCost"};//, "Seats"};
                data = new String[Globals.cars.getSize()][24];
                for(int i = 0; i < Globals.cars.getSize(); i++) {
                    data[i][j++] = Integer.toString(Globals.cars.getElement(i).getLicenseNum());
                    data[i][j++] = Globals.cars.getElement(i).getModel();
                    data[i][j++] = Integer.toString(Globals.cars.getElement(i).getYear());
                    data[i][j++] = Integer.toString(Globals.cars.getElement(i).getFuelConsumption());
                    data[i][j++] = Integer.toString(Globals.cars.getElement(i).getYearlyCost());
                    //data[i][j++] = Integer.toString(((Bus)cars[i]).getNumOfSeat());
                    j = 0;
                }
                break;
            case STATION:
                header = new String[]{"stationId", "posX", "posY"};
                data = new String[Globals.stations.getSize()][24];
                for(int i = 0; i < Globals.stations.getSize(); i++) {
                    data[i][j++] = Integer.toString(Globals.stations.getElement(i).getStationId());
                    data[i][j++] = Integer.toString(Globals.stations.getElement(i).getPosX());
                    data[i][j++] = Integer.toString(Globals.stations.getElement(i).getPosY());
                    j = 0;
                }
                break;
            case ROUTE:
                header = new String[]{"RouteId", "startStation ID", "endStation ID", "Distance"};
                data = new String[Globals.routes.getSize()][24];
                for(int i = 0; i < Globals.routes.getSize(); i++) {
                    data[i][j++] = Integer.toString(Globals.routes.getElement(i).getRouteIndex());
                    data[i][j++] = Integer.toString(Globals.routes.getElement(i).getStartStation().getStationId());
                    data[i][j++] = Integer.toString(Globals.routes.getElement(i).getEndStation().getStationId());
                    data[i][j++] = Float.toString(Globals.routes.getElement(i).getRouteDistance());
                    j = 0;
                }
                break;
            case PASSENGER:
                header = new String[]{"Id", "Name", "Sex", "Age", "dateOfSub", "Credit"};
                data = new String[Globals.customers.getSize()][24];
                for(int i = 0; i < Globals.customers.getSize(); i++) {
                    data[i][j++] = Integer.toString(Globals.customers.getElement(i).getId());
                    data[i][j++] = Globals.customers.getElement(i).getName();
                    data[i][j++] = Globals.customers.getElement(i).getSex();
                    data[i][j++] = Integer.toString(Globals.customers.getElement(i).getAge());
                    data[i][j++] = Globals.customers.getElement(i).getDateOfSub();
                    data[i][j++] = Float.toString(Globals.customers.getElement(i).getCredit());
                    j = 0;
                }
                break;
            case WORKER:
                header = new String[]{"Id", "Name", "Sex", "Age", "Experience (year)", "Salary", "Warnings"};
                data = new String[Globals.workers.getSize()][24];
                for(int i = 0; i < Globals.workers.getSize(); i++) {
                    data[i][j++] = Integer.toString(Globals.workers.getElement(i).getId());
                    data[i][j++] = Globals.workers.getElement(i).getName();
                    data[i][j++] = Globals.workers.getElement(i).getSex();
                    data[i][j++] = Integer.toString(Globals.workers.getElement(i).getAge());
                    data[i][j++] = Integer.toString(Globals.workers.getElement(i).getYearExp());
                    data[i][j++] = Integer.toString(Globals.workers.getElement(i).getSalary());
                    data[i][j++] = Integer.toString(Globals.workers.getElement(i).getWarnings());
                    j = 0;
                }
                break;
        }

        table = new JTable(data, header);
        scrollPane = new JScrollPane(table);
    }
}
