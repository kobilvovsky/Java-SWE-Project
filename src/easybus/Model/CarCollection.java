package easybus.Model;

import java.io.*;
import java.util.Iterator;

public class CarCollection implements Base
{
    private static Collection<Car> cars;
    private String fileName;
    private String[] columns = {"licenseNum", "Model", "Year", "Fuel", "yearlyCost", "Seats"};//, "Seats"};

    public CarCollection(String name) {
        setFileName(name);
        loadCars();
    }

    public String getFileName() { return fileName; }
    public void setFileName(String str) { fileName = str; }
    public Collection<Car> getCars() { return cars; }
    public void addCar(Car car) throws IOException {
        cars.insert(car);
        saveCars();
    }
    public boolean removeCar(Car car) throws IOException {
        if(findCar(car.getLicenseNum()) != null) {
            cars.remove(car);
            saveCars();
            return true;
        }
        return false;
    }
    public Car findCar(int id) {
        Iterator it = cars.getCollection().iterator();

        while(it.hasNext()) {
            Car car = (Car) it.next();
            if(car.getLicenseNum() == id)
                return car;
        }

        return null;
    }
    public int getCarLicense(int i) {
        return getCars().getElement(i).getLicenseNum();
    }
    public String getCarModelName(int i) {
        return getCars().getElement(i).getModel();
    }
    public int getCarYear(int i) {
        return getCars().getElement(i).getYear();
    }
    public int getCarConsumption(int i) {
        return getCars().getElement(i).getFuelConsumption();
    }
    public int getCarYearlyCost(int i) {
        return getCars().getElement(i).getYearlyCost();
    }
    public int getCarSeats(int i) { return getCars().getElement(i).getSeats(); }

    public int getSize() { return getCars().getSize(); }
    public String[] getColumns() { return columns; }

    public boolean loadCars() {
        try (FileInputStream fis = new FileInputStream(getFileName() + ".ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            cars = (Collection<Car>) ois.readObject();
            System.out.println("Loaded: " + getFileName() + ".ser");
            ois.close();

            return true;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            cars = new Collection<Car>();
        }

        return false;
    }
    public boolean saveCars() throws IOException
    {
        try {
            FileOutputStream fos = new FileOutputStream(getFileName() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cars);

            System.out.println("Saved: " + getFileName() + ".ser");
            oos.flush();
            oos.close();

            return true;
        } catch(IOException e) {
            System.out.println("Exception: " + e);
        }

        return false;
    }

    @Override
    public void draw() {
        System.out.println("CarCollection");
    }
}
