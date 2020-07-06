package easybus;

import java.io.*;

public class Globals
{
    enum Data {
        VEHICLE,
        STATION,
        ROUTE,
        PASSENGER,
        WORKER
    };

    public static Data currentData = Data.VEHICLE;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    public static Collection<Car> cars;
    public static Collection<Station> stations;
    public static Collection<Lineroute> routes;
    public static Collection<Passenger> customers;
    public static Collection<Busdriver> workers;

    public Globals() throws Exception
    {
        System.out.println("init Globals!!");

        for (Data type : Data.values()) {
            try (FileInputStream fis = new FileInputStream(type.toString() + ".ser")) {
                ObjectInputStream ois = new ObjectInputStream(fis);

                switch (type)
                {
                    case VEHICLE:
                        cars = (Collection<Car>) ois.readObject();
                        break;

                    case STATION:
                        stations = (Collection<Station>) ois.readObject();
                        break;

                    case ROUTE:
                        routes = (Collection<Lineroute>) ois.readObject();
                        break;

                    case PASSENGER:
                        customers = (Collection<Passenger>) ois.readObject();
                        break;

                    case WORKER:
                        workers = (Collection<Busdriver>) ois.readObject();
                        break;
                }

                System.out.println("Loaded file: " + type.toString() + ".ser");
                ois.close();
            } catch (Exception e) {
                System.out.println("Exception: " + e);

                switch (type)
                {
                    case VEHICLE:
                        cars = new Collection<Car>();
                        break;

                    case STATION:
                        stations = new Collection<Station>();
                        break;

                    case ROUTE:
                        routes = new Collection<Lineroute>();
                        break;

                    case PASSENGER:
                        customers = new Collection<Passenger>();
                        break;

                    case WORKER:
                        workers = new Collection<Busdriver>();
                        break;
                }
            }
        }
    }

    public static void save(Data type) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(type.toString() + ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        switch(type) {
            case VEHICLE:
                oos.writeObject(cars);
                break;

            case STATION:
                oos.writeObject(stations);
                break;

            case ROUTE:
                oos.writeObject(routes);
                break;

            case PASSENGER:
                oos.writeObject(customers);
                break;

            case WORKER:
                oos.writeObject(workers);
                break;
        }

        System.out.println("Saved file: " + type.toString() + ".ser");
        oos.flush();
        oos.close();
    }

    // VEHICLES
    //Minibus mini = new Minibus(15000, 140, 22222222, "Skoda", 2012, 30);
    //Bus bus = new Bus(35000, 180, 12345678, "Scania", 2016, 50);
    //public static Collection<Car> cars = new Collection<Car>();
    //Car[] cars = {mini, bus};

    // STATIONS
    //Station first = new Station(1, 7, 8);
    //Station second = new Station(2, 3, 2);
    //public static Collection<Station> stations = new Collection<Station>();
    //Station[] stations = {first, second};

    // ROUTES
    //Lineroute route = new Lineroute(first, second);
    //public static Collection<Lineroute> routes = new Collection<Lineroute>();
    //Lineroute[] routes = {route};

    // WORKERS
    //Busdriver roman = new Busdriver("Roman", 31333333, "M", 47, 3, 7500);
    //public static Collection<Busdriver> workers = new Collection<Busdriver>();
    //Busdriver[] workers = {roman};

    // CUSTOMERS
    //Passenger shalom = new Passenger(10, 31633333, "21/05/2010", "Shalom", "M", 24);
    //Passenger roey = new Passenger(2, 316222222, "01/01/2020", "Roey", "M", 28);
    //public static Collection<Passenger> customers = new Collection<Passenger>();
    //Passenger[] customers = {shalom, roey};

    public static void setCurrentData(Data d) { currentData = d; }
    public static Data getCurrentData() { return currentData; }
}
