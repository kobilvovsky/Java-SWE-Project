package easybus.Model;

import java.io.*;
import java.util.Iterator;

public class WorkerCollection
{
    private static Collection<Busdriver> workers;
    private String fileName;
    private String[] columns = {"Id", "Name", "Sex", "Age", "Experience (year)", "Salary", "Warnings"};

    public WorkerCollection(String name) {
        setFileName(name);
        loadWorkers();
    }

    public String getFileName() { return fileName; }
    public void setFileName(String str) { fileName = str; }
    public Collection<Busdriver> getWorkers() { return workers; }
    public void addWorker(Busdriver driver) throws IOException {
        getWorkers().insert(driver);
        saveWorkers();
    }
    public boolean removeWorker(Busdriver driver) throws IOException {
        if(findWorker(driver.getId()) != null) {
            getWorkers().remove(driver);
            saveWorkers();
            return true;
        }
        return false;
    }
    public Busdriver findWorker(int id) {
        Iterator it = getWorkers().getCollection().iterator();

        while(it.hasNext()) {
            Busdriver driver = (Busdriver) it.next();
            if(driver.getId() == id)
                return driver;
        }

        return null;
    }
    public int getSize() { return getWorkers().getSize(); }
    public String[] getColumns() { return columns; }

    public boolean loadWorkers() {
        try (FileInputStream fis = new FileInputStream(getFileName() + ".ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            workers = (Collection<Busdriver>) ois.readObject();
            System.out.println("Loaded: " + getFileName() + ".ser");
            ois.close();

            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            workers = new Collection<Busdriver>();
        }

        return false;
    }
    public boolean saveWorkers() throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(getFileName() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(workers);

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
