package easybus.Controller;
import easybus.Model.*;

public class DataController
{
    public enum OPTIONS {
        CAR,
        STATION,
        ROUTE,
        PASSENGER,
        WORKER
    };

    public static OPTIONS selected;

    // Sets
    public static CarCollection cars = new CarCollection("CAR");
    public static StationCollection stations = new StationCollection("STATION");
    public static RouteCollection routes = new RouteCollection("ROUTE");
    public static PassengerCollection passengers = new PassengerCollection("PASSENGER");
    public static WorkerCollection workers = new WorkerCollection("WORKER");

    public DataController() {
        System.out.println("loading DataController...");
        selected = OPTIONS.CAR;
    }

    public void setSelected(OPTIONS o) { selected = o; }
    public OPTIONS getSelected() { return selected; }

    public CarCollection getCarModel() { return cars; }
    public StationCollection getStationModel() { return stations; }
    public RouteCollection getRouteModel() { return routes; }
    public PassengerCollection getPassengerModel() { return passengers; }
    public WorkerCollection getWorkerModel() { return workers; }

    /*
    public <T extends Collection> T getSelectedSet() {
        Class<T> type = null;
        switch(getSelected()) {
            case CAR:
                return type.cast(cars);
            case STATION:
                return type.cast(stations);
            case ROUTE:
                return type.cast(routes);
            case PASSENGER:
                return type.cast(passengers);
            case WORKER:
                return type.cast(workers);
        }

        return null;
    }*/
}
