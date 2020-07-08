package easybus.Model;
import easybus.Model.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection<T> implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<T> collection = new ArrayList<T>();

    public Collection() { System.out.println("A new List has been initialized!"); }
    public void insert(T t) { collection.add(t); }
    public void remove(T t) { collection.remove(t); System.out.println("Object " + t + " removed!"); }
    public void print() { System.out.println("List t:" + collection); }
    public int getSize() { return collection.size(); }
    public void remoteAll() { collection.clear(); }
    public int indexOf(T t) { return collection.indexOf(t); }
    public T getElement(int i) { return collection.get(i); }

    public List<T> getCollection() { return collection; }
    public Car getCarById(int id) {
        Iterator it = collection.iterator();

        while(it.hasNext()) {
            Car car = (Car) it.next();

            if(car.getLicenseNum() == id)
                return car;
        }

        return null;
    }
    public Station getStationById(int id) {
        Iterator it = collection.iterator();

        while (it.hasNext()) {
            Station station = (Station) it.next();
            if (station.getStationId() == id) {
                return station;
            }
        }
        return null;
    }
    public Lineroute getRouteById(int id) {
        Iterator it = collection.iterator();

        while(it.hasNext()) {
            Lineroute route = (Lineroute) it.next();
            if(route.getRouteIndex() == id)
                return route;
        }

        return null;
    }
    public Passenger getPassengerById(int id) {
        Iterator it = collection.iterator();

        while(it.hasNext()) {
            Passenger passenger = (Passenger) it.next();
            if(passenger.getId() == id)
                return passenger;
        }

        return null;
    }
    public Busdriver getWorkerById(int id) {
        Iterator it = collection.iterator();

        while(it.hasNext()) {
            Busdriver driver = (Busdriver) it.next();
            if(driver.getId() == id)
                return driver;
        }

        return null;
    }
}
