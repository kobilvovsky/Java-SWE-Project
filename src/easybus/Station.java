package easybus;

public class Station
{
    static int stationId = 0;
    int posX;
    int posY;

    public Station(int posX, int posY)
    {
        this.stationId = stationId++;
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