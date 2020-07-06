package easybus;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
        deleteButton.addActionListener(new ViewMenu.ButtonClickListener());
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            int column = 0;
            int row = table.getSelectedRow();
            String value = table.getModel().getValueAt(row, column).toString();

            switch(Globals.getCurrentData()) {
                case VEHICLE:
                    Globals.cars.remove(Globals.cars.getCarById(Integer.parseInt(value)));
                    break;

                case STATION:
                    Globals.stations.remove(Globals.stations.getStationById(Integer.parseInt(value)));
                    Globals.stations.print();
                    break;

                case ROUTE:
                    Globals.routes.remove(Globals.routes.getRouteById(Integer.parseInt(value)));
                    break;

                case PASSENGER:
                    Globals.customers.remove(Globals.customers.getPassengerById(Integer.parseInt(value)));
                    break;

                case WORKER:
                    Globals.workers.remove(Globals.workers.getWorkerById(Integer.parseInt(value)));
                    break;

            }

            System.out.println("value: " + value + " deleted!");
            //DefaultTableModel model = (DefaultTableModel) table.getModel();
            //model.removeRow(row);
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
                    data[i][j++] = Integer.toString(Globals.routes.getElement(i).startStation.getStationId());
                    data[i][j++] = Integer.toString(Globals.routes.getElement(i).endStation.getStationId());
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
