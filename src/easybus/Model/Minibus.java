package easybus.Model;
import java.io.Serializable;

public class Minibus extends Car implements Serializable
{
    int numOfSeat;

    public Minibus(int yearlyCost, int fuelConsumption, int licenseNum, String model, int year, int numOfSeat)
    {
        super(yearlyCost, fuelConsumption, licenseNum, model, year);
        setNumOfSeat(numOfSeat);
    }

    public int getNumOfSeat()
    {
        return numOfSeat;
    }
    public void setNumOfSeat(int numOfSeat)
    {
        // 0 <= x <= 15
        if(numOfSeat < getMinPassengers() || numOfSeat > 15)
            System.out.println("Invalid NumofSeat");
        else
            this.numOfSeat = numOfSeat;
    }

    @Override
    public void horn() {
        System.out.println("BEEP BEEP!");
    }

    @Override
    public int getSeats() {
        return getNumOfSeat();
    }

    public int getMinPassengers(){
        return 0;
    }
}
