package easybus;

public class Maintenance
{
    int yearlyCost;
    int fuelConsumption; //in liter

    public Maintenance(int yearlyCost, int fuelConsumption)
    {
        this.setYearlyCost(yearlyCost);
        this.setFuelConsumption(fuelConsumption);
    }

    public int getYearlyCost()
    {
        return yearlyCost;
    }
    public void setYearlyCost(int yearlyCost)
    {
        if (yearlyCost<0||yearlyCost>100000000)
        {
            System.out.println("Invalid YearlyCost");
            System.out.println("Enter YearlyCost");
            //להניס לתוך yearlyCost את yearlyCost החדש
        }
        else
            this.yearlyCost = yearlyCost;
    }

    public int getFuelConsumption()
    {
        return fuelConsumption;
    }
    public void setFuelConsumption(int fuelConsumption)
    {
        if(fuelConsumption<0||fuelConsumption>10000)
        {
            System.out.println("Invalid FuelConsumption");
            System.out.println("Enter FuelConsumption");
            //להניס לתוך fuelConsumption את fuelConsumption החדש
        }
        else
            this.fuelConsumption = fuelConsumption;
    }
}
