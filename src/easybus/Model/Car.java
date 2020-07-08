package easybus.Model;

import java.io.Serializable;

abstract class Car extends Maintenance implements Serializable
{
    private int licenseNum;
    private String model;
    private int year;

    // GPS location
    private int posX;
    private int posY;

    public Car(int yearlyCost, int fuelConsumption, int licenseNum, String model, int year)
    {
        super(yearlyCost, fuelConsumption);
        setLicenseNum(licenseNum);
        setModel(model);
        setYear(year);
        setPosX(0);
        setPosY(0);
    }

    public void setLicenseNum(int licenseNum)
    {
        this.licenseNum = licenseNum;
    }
    public int getLicenseNum() { return licenseNum; }
    public String getModel() { return model; }
    public void setModel(String model)
    {
        this.model = model;
    }

    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }

    public int getPosX() { return posX; }
    public int getPosY() { return posY; }
    public void setPosX(int posX) { this.posX = posX; }
    public void setPosY(int posY) { this.posY = posY; }

    public void print() {
        System.out.println("["+ getLicenseNum() + "]: " + getModel() + "/" + getYear());
    }

    abstract public void horn();
    abstract public int getSeats();
}