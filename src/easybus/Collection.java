package easybus;
import javax.sound.sampled.Line;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Collection<T> implements Serializable
{
    private List<T> collection = new ArrayList<T>();

    public Collection() { System.out.println("A new List has been initialized!"); }
    public void insert(T t) { collection.add(t); }
    public void remove(T t) { collection.remove(t); System.out.println("Object " + t + " removed!"); }
    public void print() { System.out.println("List t:" + collection); }
    public int getSize() { return collection.size(); }
    public void remoteAll() { collection.clear(); }
    public int indexOf(T t) { return collection.indexOf(t); }
    public T getElement(int i) { return collection.get(i); }

    public Car getCarById(int id) {
        Iterator it = collection.iterator();

        while(it.hasNext()) {
            Car car = (Car) it.next();

            if(car.getLicenseNum() == id)
                return (Car) it.next();
        }

        throw new NoSuchElementException();
    }
    public Station getStationById(int id) {
        Iterator it = collection.iterator();

        while(it.hasNext()) {
            Station station = (Station) it.next();

            if(station.getStationId() == id) {
                station.print();
                return (Station) it.next();
            }
        }

        throw new NoSuchElementException();
    }
    public Lineroute getRouteById(int id) {
        Iterator it = collection.iterator();

        while(it.hasNext()) {
            Lineroute route = (Lineroute) it.next();

            if(route.getRouteIndex() == id)
                return (Lineroute) it.next();
        }

        throw new NoSuchElementException();
    }
    public Passenger getPassengerById(int id) {
        Iterator it = collection.iterator();

        while(it.hasNext()) {
            Passenger passenger = (Passenger) it.next();

            if(passenger.getId() == id)
                return (Passenger) it.next();
        }

        throw new NoSuchElementException();
    }
    public Busdriver getWorkerById(int id) {
        Iterator it = collection.iterator();

        while(it.hasNext()) {
            Busdriver driver = (Busdriver) it.next();

            if(driver.getId() == id)
                return (Busdriver) it.next();
        }

        throw new NoSuchElementException();
    }

    public Station getStation(int byIndex) {
        Iterator it = collection.iterator();

        while(it.hasNext()) {
            Station st = (Station) it.next();

            if(st.getStationId() == byIndex)
                return st;
        }

        throw new NoSuchElementException();
        //return new Station(-1, -1);
    }
}
