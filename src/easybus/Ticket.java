package easybus;

public class Ticket
{
    int ticketid;
    int currentAmount;

    public Ticket(int ticketid, int currentAmount)
    {
        this.setTicketid(ticketid);
        this.setCurrentAmount(currentAmount);
    }


    public int getTicketid()
    {
        return ticketid;
    }
    public void setTicketid(int ticketid)
    {
        if (ticketid<0||ticketid>10000000)
        {
            System.out.println("Invalid TicketId");
            System.out.println("Enter TicketId");
            //לקבל מספר TicketId תקין ולהשוות TicketId
        }
        else
            this.ticketid = ticketid;
    }

    public int getCurrentAmount()
    {
        return currentAmount;
    }
    public void setCurrentAmount(int currentAmount)
    {
        if (currentAmount < 0)// יכול להיות עוד תנאים צריך לשבת ולחשוב
        {
            System.out.println("Invalid CurrentAmount");
            System.out.println("Enter CurrentAmount");
            //לקבל מספר currentAmount תקין ולהשוות currentAmount
        }
        else
            this.currentAmount = currentAmount;
    }
}
