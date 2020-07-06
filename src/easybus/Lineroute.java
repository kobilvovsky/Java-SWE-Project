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
        this.setRoutDistance();
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
        float d;
        float distance = (float) (( Math.pow(endStation.posX - startStation.posX,(float) 2)) + (Math.pow(endStation.posY - startStation.posY,(float) 2)));
        d = distance;
        this.routDistance = (float) Math.sqrt(distance);
    }

    public void print() {
        startStation.print();
        System.out.println("/");
        endStation.print();
    }
}
