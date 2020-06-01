package easybus;

public class Lineroute
{
   int startStation;
   int endStation;
   int routDistance;

    public Lineroute(int startStation, int endStation, int routDistance)
    {
        this.startStation = startStation;
        this.endStation = endStation;
        this.routDistance = routDistance;
    }

    public int getStartStation()
    {
        return startStation;
    }

    public void setStartStation(int startStation)
    {
        this.startStation = startStation;
    }

    public int getEndStation()
    {
        return endStation;
    }

    public void setEndStation(int endStation)
    {
        this.endStation = endStation;
    }

    public int getRoutDistance()
    {
        return routDistance;
    }

    public void setRoutDistance(int routDistance)
    {
        this.routDistance = routDistance;
    }
}
