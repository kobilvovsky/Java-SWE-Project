package easybus;

public class Car
{
    int licenseNum;
    String model;
    int year;

    public Car(int licenseNum, String model, int year)
    {
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
