package easybus;

public class Minibus extends Car
{
    int numOfSeat;

    public Minibus(int yearlyCost, int fuelConsumption, int licenseNum, String model, int year, int numOfSeat)
    {
        super(yearlyCost, fuelConsumption, licenseNum, model, year);
        this.numOfSeat = numOfSeat;
    }

    public int getNumOfSeat()
    {
        return numOfSeat;
    }
    public void setNumOfSeat(int numOfSeat)
    {
        this.numOfSeat = numOfSeat;
    }
}
