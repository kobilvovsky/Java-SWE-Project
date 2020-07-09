package easybus.Model;

import java.io.*;
import java.util.Iterator;

public class RouteCollection implements Base
{
    private static Collection<Lineroute> routes;
    private String fileName;
    private String[] insertColumns = {"startStation ID", "endStation ID"};
    private String[] viewColumns = {"Route ID", "startStation ID", "endStation ID", "Distance"};

    public RouteCollection(String name) {
        setFileName(name);
        loadRoutes();
    }

    public String getFileName() { return fileName; }
    public void setFileName(String str) { fileName = str; }
    public Collection<Lineroute> getRoutes() { return routes; }
    public void addRoute(Lineroute lr) throws IOException {
        getRoutes().insert(lr);
        saveRoutes();
    }
    public boolean removeRoute(Lineroute lr) throws IOException {
        if(findRoute(lr.getRouteIndex()) != null) {
            getRoutes().remove(lr);
            saveRoutes();
            return true;
        }

        return false;
    }
    public Lineroute findRoute(int id) {
        Iterator it = getRoutes().getCollection().iterator();

        while(it.hasNext()) {
            Lineroute lr = (Lineroute) it.next();
            if(lr.getRouteIndex() == id)
                return lr;
        }

        return null;
    }
    public int lastRouteId() {
        Iterator it = getRoutes().getCollection().iterator();
        int max = 1;

        while(it.hasNext()) {
            Lineroute lr = (Lineroute) it.next();
            max = lr.getRouteIndex();
        }

        return max;
    }
    public int getSize() { return getRoutes().getSize(); }
    public String[] getInsertColumns() { return insertColumns; }
    public String[] getViewColumns() { return viewColumns; }

    public boolean loadRoutes() {
        try (FileInputStream fis = new FileInputStream(getFileName() + ".ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            routes = (Collection<Lineroute>) ois.readObject();
            Lineroute.setCounter(lastRouteId());
            System.out.println("loadRoutes" + Station.counter );
            System.out.println("Loaded: " + getFileName() + ".ser");
            ois.close();

            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            routes = new Collection<Lineroute>();
        }

        return false;
    }
    public boolean saveRoutes() throws IOException
    {
        try {
            FileOutputStream fos = new FileOutputStream(getFileName() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(routes);

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
