package easybus;
import java.io.Serializable;

public class Car extends Maintenance implements Serializable
{
    int licenseNum;
    String model;
    int year;

    // GPS location
    int posX;
    int posY;

    public Car(int yearlyCost, int fuelConsumption, int licenseNum, String model, int year)
    {
        super(yearlyCost, fuelConsumption);
        this.licenseNum = licenseNum;
        this.model = model;
        this.year = year;
        posX = 0;
        posY = 0;
    }

    public int getLicenseNum()
    {
        return licenseNum;
    }
    public void setLicenseNum(int licenseNum)
    {
        this.licenseNum = licenseNum;
    }

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
}