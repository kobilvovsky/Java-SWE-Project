package easybus;

import java.io.Serializable;

public class Maintenance implements Serializable
{
    int yearlyCost;
    int fuelConsumption; //in liter

    public Maintenance(int yearlyCost, int fuelConsumption)
    {
        this.yearlyCost = yearlyCost;
        this.fuelConsumption = fuelConsumption;
    }

    public int getYearlyCost()
    {
        return yearlyCost;
    }
    public void setYearlyCost(int yearlyCost)
    {
        this.yearlyCost = yearlyCost;
    }

    public int getFuelConsumption()
    {
        return fuelConsumption;
    }
    public void setFuelConsumption(int fuelConsumption)
    {
        this.fuelConsumption = fuelConsumption;
    }
}
