package easybus;
import java.lang.Math;

public class Lineroute
{
    Station startStation;
    Station endStation;
    float routDistance;

    public Lineroute(Station startStation, Station endStation)
    {
        this.startStation = startStation;
        this.endStation = endStation;
        setRoutDistance();
    }

    public Station getStartStation()
    {
        return startStation;
    }
    public void setStartStation(Station startStation)
    {
        this.startStation = startStation;
    }

    public Station getEndStation()
    {
        return endStation;
    }
    public void setEndStation(Station endStation)
    {
        this.endStation = endStation;
    }

    public float getRoutDistance()
    {
        return routDistance;
    }
    public void setRoutDistance()
    {
        this.routDistance = (float) Math.sqrt( ((endStation.posX - startStation.posX)^2) -
                        (endStation.posY - startStation.posY));
    }

    public void print() {
        startStation.print();
        System.out.println("/");
        endStation.print();
    }
}
