package easybus;

public class GUIConstants
{
    enum Data {
        VEHICLE,
        STATION,
        ROUTE,
        CUSTOMER,
        WORKER
    };

    public Data currentData = Data.VEHICLE;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    // VEHICLES
    Minibus mini = new Minibus(15000, 140, 22222222, "Mercedez", 2012, 30);
    Bus bus = new Bus(35000, 180, 12345678, "Mercedez", 2016, 50);
    Car[] cars = {mini, bus};

    // STATIONS
    Station first = new Station(1, 5, 5);
    Station second = new Station(2, 5, 10);
    Station[] stations = {first, second};

    // ROUTES
    Lineroute route = new Lineroute(first, second);
    Lineroute[] routes = {route};

    // WORKERS
    Busdriver roman = new Busdriver("Roman", 31333333, "M", 47, 3, 7500, 0);

    // CUSTOMERS
    Passenger shalom = new Passenger(10, 31633333, "21/05/2010", "Shalom", "M", 24);
    Passenger roey = new Passenger(2, 316222222, "01/01/2020", "Roey", "M", 28);

    Person[] persons = {roman, shalom, roey};

    public Data getCurrentData() {
        return currentData;
    }
}
