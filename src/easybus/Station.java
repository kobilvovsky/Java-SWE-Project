package easybus;

public class Station
{
    int stationId;
    int posX;
    int posY;

    public Station(int stationId, int posX, int posY)
    {
        this.setStationId(stationId);
        this.posX = posX;
        this.posY = posY;
    }

    public int getStationId()
    {
        return stationId;
    }
    public void setStationId(int stationId)
    {
        if (stationId<0)//יכול להיות עוד תנאים!
        {
            System.out.println("Invalid StationId");
            System.out.println("Enter StationId");
            //לקבל מספר stationId תקין ולהשוות stationId
        }
        else
            this.stationId = stationId;
    }

    public int getPosX()
    {
        return posX;
    }
    public void setPosX(int posX)
    {
        this.posX = posX;
    }//אין תנאים ברורים נצטרך לשבת

    public int getPosY()
    {
        return posY;
    }
    public void setPosY(int posY)
    {
        this.posY = posY;
    }//אין תנאים ברורים נצטרך לשבת

    public void print() {
        System.out.println("["+ getStationId() + "]: " + getPosX() + "/" + getPosY());
    }
}