package easybus;

public class Passenger extends Person
{
    float credit;
    int id;
    String dateOfSub;

    public Passenger(float credit, int id, String dateOfSub, String name, String sex, int age)
    {
        super(id, name, sex, age);
        this.credit = credit;
        this.id = id;
        this.dateOfSub = dateOfSub;
    }

    public float getCredit()
    {
        return credit;
    }
    public void setCredit(float credit)
    {
        this.credit = credit;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id) { this.id = id; }

    public String getDateOfSub() { return dateOfSub; }
    public void setDateOfSub(String dateOfSub) { this.dateOfSub = dateOfSub; }
}
