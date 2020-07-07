package easybus.Model;

import easybus.Collection;
import java.io.*;

public class Globals
{
    public enum Data {
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

    public Globals()
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
                        Station.counter = stations.getElement(stations.getSize()-1).getStationId() + 1;
                        break;

                    case ROUTE:
                        routes = (Collection<Lineroute>) ois.readObject();
                        Lineroute.counter = routes.getElement(routes.getSize()-1).getRouteIndex() + 1;
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

    public static boolean isInt(String[] strArr) {
        for(int i = 0; i < strArr.length; i++) {
            for (char ch: strArr[i].toCharArray()) {
                if(!Character.isDigit(ch))
                    return false;
            }
        }

        return true;
    }

    public static void setCurrentData(Data d) { currentData = d; }
    public static Data getCurrentData() { return currentData; }
}
