package easybus;
import java.io.Serializable;
import java.lang.Math;

public class Lineroute implements Serializable
{
    static int counter = 1;
    int routeIndex;
    Station startStation;
    Station endStation;
    float routDistance;

    public Lineroute(Station startStation, Station endStation)
    {
        this.routeIndex = counter++;
        this.startStation = startStation;
        this.endStation = endStation;
        getRouteDistance();
    }

    public int getRouteIndex()
    {
        return routeIndex;
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

    public float getRouteDistance() { return routDistance; }
    public void setRouteDistance()
    {
        this.routDistance = (float) Math.sqrt(Math.pow(endStation.posX - startStation.posX, 2) + Math.pow(endStation.posY - startStation.posY, 2));
    }

    public void print() {
        startStation.print();
        System.out.println("/");
        endStation.print();
    }
}
