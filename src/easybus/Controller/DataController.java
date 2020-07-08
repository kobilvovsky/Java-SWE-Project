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
    CollectionFactory collectionFactory = new CollectionFactory();

    public CarCollection cars = (CarCollection) collectionFactory.getCollection("CAR");
    public StationCollection stations = (StationCollection) collectionFactory.getCollection("STATION");
    public RouteCollection routes = (RouteCollection) collectionFactory.getCollection("ROUTE");
    public PassengerCollection passengers = (PassengerCollection) collectionFactory.getCollection("PASSENGER");
    public WorkerCollection workers = (WorkerCollection) collectionFactory.getCollection("WORKER");

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
}
