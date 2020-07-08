package easybus.Model;
import java.io.Serializable;

public class Bus extends Car implements Serializable
{
    private int numOfSeat;

    public Bus(int yearlyCost, int fuelConsumption, int licenseNum, String model, int year, int numOfSeat)
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
        // 15 <= x <= 100
        if(numOfSeat < getMinPassengers() || numOfSeat > 100)
            System.out.println("Invalid NumofSeat");
        else
            this.numOfSeat = numOfSeat;
    }

    @Override
    public void horn() {
        System.out.println("WROLOLO WRLO");
    }

    @Override
    public int getSeats() {
        return getNumOfSeat();
    }

    public static int getMinPassengers() {
        return 15;
    }
}
