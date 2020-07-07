package easybus.Model;
import java.io.Serializable;
import java.lang.Math;

public class Lineroute implements Serializable
{
    public static int counter = 1;
    private int routeIndex;
    private Station startStation;
    private Station endStation;
    private float routDistance;

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

    public void setCounter(int c) { counter = c; }

    public float getRouteDistance() { return routDistance; }
    public void setRouteDistance()
    {
        this.routDistance = (float) Math.sqrt(Math.pow(endStation.getPosX() - startStation.getPosX(), 2) + Math.pow(endStation.getPosY() - startStation.getPosY(), 2));
    }

    public void print() {
        startStation.print();
        System.out.println("/");
        endStation.print();
    }
}
