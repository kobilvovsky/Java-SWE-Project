package easybus;

public class Car extends Maintenance,Gps
{
    int licenseNum;
    String model;
    int year;

    public Car(int yearlyCost, int fuelConsumption, int licenseNum, String model, int year)
    {
        super(yearlyCost, fuelConsumption);
        this.licenseNum = licenseNum;
        this.model = model;
        this.year = year;
    }

    public int getLicenseNum()
    {
        return licenseNum;
    }

    public void setLicenseNum(int licenseNum)
    {
        this.licenseNum = licenseNum;
    }

    public String getModel()
    {
        return model;
    }

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
}