package easybus;

public class Bus extends Car
{
    int numOfSeat;

    public Bus(int yearlyCost, int fuelConsumption, int licenseNum, String model, int year, int numOfSeat)
    {
        super(yearlyCost, fuelConsumption, licenseNum, model, year);
        this.setNumOfSeat(numOfSeat);
    }

    public int getNumOfSeat()
    {
        return numOfSeat;
    }
    public void setNumOfSeat(int numOfSeat)
    {
        if(numOfSeat<0||numOfSeat>100)
        {
            System.out.println("Invalid NumofSeat");
            System.out.println("Enter NumofSeat");
            //לקבל מספר כסאות תקין ולהשוות לנאמאופסיט
        }
        else
            this.numOfSeat = numOfSeat;
    }
}
