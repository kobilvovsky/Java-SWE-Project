package easybus.Model;

import java.io.*;
import java.util.Iterator;

public class PassengerCollection implements Base
{
    private static Collection<Passenger> passengers;
    private String fileName;
    private String[] insertColumns = {"Id", "Name", "Sex", "Age", "Date Of Sub", "Credit"};
    private String[] viewColumns = insertColumns;

    public PassengerCollection(String name) {
        setFileName(name);
        loadPassengers();
    }

    public String getFileName() { return fileName; }
    public void setFileName(String str) { fileName = str; }
    public Collection<Passenger> getPassengers() { return passengers; }
    public void addPassenger(Passenger p) throws IOException {
        getPassengers().insert(p);
        savePassengers();
    }
    public boolean removePassenger(Passenger p) throws IOException {
        if(findPassenger(p.getId()) != null) {
            passengers.remove(p);
            savePassengers();
            return true;
        }
        return false;
    }
    public Passenger findPassenger(int id) {
        Iterator it = getPassengers().getCollection().iterator();

        while(it.hasNext()) {
            Passenger p = (Passenger) it.next();
            if(p.getId() == id)
                return p;
        }

        return null;
    }
    public int getSize() { return getPassengers().getSize(); }
    public String[] getInsertColumns() { return insertColumns; }
    public String[] getViewColumns() { return viewColumns; }

    public boolean loadPassengers() {
        try (FileInputStream fis = new FileInputStream(getFileName() + ".ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            passengers = (Collection<Passenger>) ois.readObject();
            System.out.println("Loaded: " + getFileName() + ".ser");
            ois.close();

            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            passengers = new Collection<Passenger>();
        }

        return false;
    }
    public boolean savePassengers() throws IOException
    {
        try {
            FileOutputStream fos = new FileOutputStream(getFileName() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(passengers);

            System.out.println("Saved: " + getFileName() + ".ser");
            oos.flush();
            oos.close();

            return true;
        } catch(IOException e) {
            System.out.println("Exception: " + e);
        }

        return false;
    }
}
