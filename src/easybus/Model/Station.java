package easybus.Model;
import java.io.Serializable;

public class Station implements Serializable
{
    public static int counter = 1;
    private int stationId;
    private int posX;
    private int posY;

    public Station(int posX, int posY)
    {
        this.stationId = counter++;
        this.posX = posX;
        this.posY = posY;
    }

    public int getStationId()
    {
        return stationId;
    }

    public int getPosX()
    {
        return posX;
    }
    public void setPosX(int posX)
    {
        this.posX = posX;
    }

    public int getPosY()
    {
        return posY;
    }
    public void setPosY(int posY)
    {
        this.posY = posY;
    }

    public void print() {
        System.out.println("["+ getStationId() + "]: " + getPosX() + "/" + getPosY());
    }
}