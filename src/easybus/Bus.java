package easybus;

public class Bus  extends Car
{
    int numOfSeat;
     // s
    public Bus(int yearlyCost, int fuelConsumption, int licenseNum, String model, int year, int numOfSeat)
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
