package easybus;


public class Minibus extends easybus.Car
{
    int numOfSeat;

    public Minibus(int yearlyCost, int fuelConsumption, int licenseNum, String model, int year, int numOfSeat)
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
        if(numOfSeat<0||numOfSeat>50)
        {
            System.out.println("Invalid Minibus  NumofSeat");
            System.out.println("Enter NumofSeat");
            //לקבל מספר כסאות תקין ולהשוות לנאמאופסיט
        }
        else
            this.numOfSeat = numOfSeat;
    }
}
