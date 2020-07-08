package easybus.Controller;

import easybus.Model.Lineroute;
import easybus.Model.Station;
import easybus.View.ViewMenu;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ViewController
{
    private DataController model;
    private ViewMenu view;

    String[][] data;
    String[] header;

    public ViewController(DataController model, ViewMenu view){
        this.model = model;
        this.view = view;

        initViewActionListeners();
        prepareViewTable();
    }

    private void initViewActionListeners() {
        view.initButtons(new ViewController.CloseListener());
    }

    public class CloseListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            boolean success = false;
            int column = 0;
            int row = view.getTable().getSelectedRow();
            String value = "??";

            if(row != -1) {
                value = view.getTable().getModel().getValueAt(row, column).toString();
                switch (model.getSelected()) {
                    case CAR:
                        try {
                            if (model.getCarModel().removeCar(model.getCarModel().findCar(Integer.parseInt(value))))
                                success = true;
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;

                    case STATION:
                        try {
                            if (model.getStationModel().removeStation(model.getStationModel().findStation(Integer.parseInt(value))))
                                success = true;
                            Station.setCounter(model.getStationModel().lastStationId());
                            System.out.println("Station(ViewController) " + Station.counter);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;

                    case ROUTE:
                        try {
                            if (model.getRouteModel().removeRoute(model.getRouteModel().findRoute(Integer.parseInt(value))))
                                success = true;
                            Lineroute.setCounter(model.getRouteModel().lastRouteId());
                            System.out.println("Route(ViewController) " + Lineroute.counter);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;

                    case PASSENGER:
                        try {
                            if (model.getPassengerModel().removePassenger(model.getPassengerModel().findPassenger(Integer.parseInt(value))))
                                success = true;
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;

                    case WORKER:
                        try {
                            if (model.getWorkerModel().removeWorker(model.getWorkerModel().findWorker(Integer.parseInt(value))))
                                success = true;
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        break;

                }
            } else {
                JOptionPane.showMessageDialog(null, "There was an error selecting a row!",
                        "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(success)
                JOptionPane.showMessageDialog(null, "You have deleted a " + model.getSelected().toString() + " of id " + value + "!",
                        "Success Message", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void prepareViewTable() {
        int j = 0;
        switch(model.getSelected()) {
            case CAR:
                header = model.getCarModel().getColumns();
                data = new String[model.getCarModel().getSize()][24];
                for(int i = 0; i < model.getCarModel().getSize(); i++) {
                    data[i][j++] = Integer.toString(model.getCarModel().getCarLicense(i));
                    data[i][j++] = model.getCarModel().getCarModelName(i);
                    data[i][j++] = Integer.toString(model.getCarModel().getCarYear(i));
                    data[i][j++] = Integer.toString(model.getCarModel().getCarConsumption(i));
                    data[i][j++] = Integer.toString(model.getCarModel().getCarYearlyCost(i));
                    data[i][j++] = Integer.toString(model.getCarModel().getCarSeats(i));
                    j = 0;
                }
                break;
            case STATION:
                header = model.getStationModel().getColumns();
                data = new String[model.getStationModel().getSize()][24];
                for(int i = 0; i < model.getStationModel().getSize(); i++) {
                    data[i][j++] = Integer.toString(model.getStationModel().getStations().getElement(i).getStationId());
                    data[i][j++] = Integer.toString(model.getStationModel().getStations().getElement(i).getPosX());
                    data[i][j++] = Integer.toString(model.getStationModel().getStations().getElement(i).getPosY());
                    j = 0;
                }
                break;
            case ROUTE:
                header = model.getRouteModel().getColumns();
                data = new String[model.getRouteModel().getSize()][24];
                for(int i = 0; i < model.getRouteModel().getSize(); i++) {
                    data[i][j++] = Integer.toString(model.getRouteModel().getRoutes().getElement(i).getRouteIndex());
                    data[i][j++] = Integer.toString(model.getRouteModel().getRoutes().getElement(i).getStartStation().getStationId());
                    data[i][j++] = Integer.toString(model.getRouteModel().getRoutes().getElement(i).getEndStation().getStationId());
                    data[i][j++] = Float.toString(model.getRouteModel().getRoutes().getElement(i).getRouteDistance());
                    j = 0;
                }
                break;
            case PASSENGER:
                header = model.getPassengerModel().getColumns();
                data = new String[model.getPassengerModel().getSize()][24];
                for(int i = 0; i < model.getPassengerModel().getSize(); i++) {
                    data[i][j++] = Integer.toString(model.getPassengerModel().getPassengers().getElement(i).getId());
                    data[i][j++] = model.getPassengerModel().getPassengers().getElement(i).getName();
                    data[i][j++] = model.getPassengerModel().getPassengers().getElement(i).getSex();
                    data[i][j++] = Integer.toString(model.getPassengerModel().getPassengers().getElement(i).getAge());
                    data[i][j++] = model.getPassengerModel().getPassengers().getElement(i).getDateOfSub();
                    data[i][j++] = Float.toString(model.getPassengerModel().getPassengers().getElement(i).getCredit());
                    j = 0;
                }
                break;
            case WORKER:
                header = model.getWorkerModel().getColumns();
                data = new String[model.getWorkerModel().getSize()][24];
                for(int i = 0; i < model.getWorkerModel().getSize(); i++) {
                    data[i][j++] = Integer.toString(model.getWorkerModel().getWorkers().getElement(i).getId());
                    data[i][j++] = model.getWorkerModel().getWorkers().getElement(i).getName();
                    data[i][j++] = model.getWorkerModel().getWorkers().getElement(i).getSex();
                    data[i][j++] = Integer.toString(model.getWorkerModel().getWorkers().getElement(i).getAge());
                    data[i][j++] = Integer.toString(model.getWorkerModel().getWorkers().getElement(i).getYearExp());
                    data[i][j++] = Integer.toString(model.getWorkerModel().getWorkers().getElement(i).getSalary());
                    data[i][j++] = Integer.toString(model.getWorkerModel().getWorkers().getElement(i).getWarnings());
                    j = 0;
                }
                break;
        }

        view.setTable(data, header);
        view.setScrollPane(view.getTable());
        view.addScroll();
    }
}
