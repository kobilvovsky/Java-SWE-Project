package easybus;

import java.io.Serializable;

public class Bus extends Car implements Serializable
{
    int numOfSeat;

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
        if(numOfSeat < 0||numOfSeat > 100)
            System.out.println("Invalid NumofSeat");
        else
            this.numOfSeat = numOfSeat;
    }
}
