package easybus.Model;

import java.io.*;
import java.util.Iterator;

public class StationCollection
{
    private static Collection<Station> stations;
    private String fileName;
    private String[] columns = {"stationId", "posX", "posY"};

    public StationCollection(String name) {
        setFileName(name);
        loadStations();
    }

    public String getFileName() { return fileName; }
    public void setFileName(String str) { fileName = str; }
    public Collection<Station> getStations() { return stations; }
    public void addStation(Station st) throws IOException {
        getStations().insert(st);
        saveStations();
    }
    public boolean removeStation(Station st) throws IOException {
        if(findStation(st.getStationId()) != null) {
            getStations().remove(st);
            saveStations();
            return true;
        }
        return false;
    }
    public Station findStation(int id) {
        Iterator it = getStations().getCollection().iterator();

        while(it.hasNext()) {
            Station st = (Station) it.next();
            if(st.getStationId() == id)
                return st;
        }

        return null;
    }
    public int getSize() { return getStations().getSize(); }
    public String[] getColumns() { return columns; }

    public boolean loadStations() {
        try (FileInputStream fis = new FileInputStream(getFileName() + ".ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            stations = (Collection<Station>) ois.readObject();
            System.out.println("Loaded: " + getFileName() + ".ser");
            ois.close();

            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            stations = new Collection<Station>();
        }

        return false;
    }
    public boolean saveStations() throws IOException
    {
        try {
            FileOutputStream fos = new FileOutputStream(getFileName() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(stations);

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
