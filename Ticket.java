package easybus;

public class Ticket
{
    int ticketid;
    int currentAmount;

    public Ticket(int ticketid, int currentAmount)
    {
        this.ticketid = ticketid;
        this.currentAmount = currentAmount;
    }

    public int getTicketid()
    {
        return ticketid;
    }

    public void setTicketid(int ticketid)
    {
        this.ticketid = ticketid;
    }

    public int getCurrentAmount()
    {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount)
    {
        this.currentAmount = currentAmount;
    }
}
