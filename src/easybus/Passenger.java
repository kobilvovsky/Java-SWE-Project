package easybus;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Passenger extends Person
{
    float credit;
    int id;
    String dateOfSub;

    public Passenger(float credit, int id, String dateOfSub, String name, String sex, int age)
    {
        super(id, name, sex, age);
        this.setCredit(credit);
        this.setId(id);
        this.setDateOfSub(dateOfSub);
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
    public void setId(int id)
    {
        if (id<0||id>1000000000)
        {
            System.out.println("Invalid Id");
            System.out.println("Enter Id");
            //להניס לתוך id את id החדש
        }
        else
            this.id = id;
    }

    public String getDateOfSub() { return dateOfSub; }
    public void setDateOfSub(String dateOfSub)
    {
        if (!checkdate(dateOfSub))
        {
            //כל ההערות כבר בפנקציה! רק להכניס מחדש Date
            System.out.println("Eror");
        }
        else
            this.dateOfSub = dateOfSub;
    }
    public  boolean checkdate(String dateOfSub)
    {
        if(!isValidDate(dateOfSub))
        {
            System.out.println("Invalid date ");
            System.out.println("Enter new Date");
            return false;
            //להכניס תאריך חדש ולבדוק תקינות

        }
        String[] values = dateOfSub.split("[-/]+");
        int day = Integer.parseInt(values[0]);
        int month = Integer.parseInt(values[1]);
        int year = Integer.parseInt(values[2]);
        if(day<0||day>31)
        {
            System.out.println("Invalid Day");
            System.out.println("Enter new Date");
            return false;
            //להכניס תאריך חדש ולבדוק תקינות
        }
        if (month<1||month>12)
        {
            System.out.println("Invalid Month");
            System.out.println("Enter new Date");
            return false;
            //להכניס תאריך חדש ולבדוק תקינות
        }
        if (year<1900||year>2020)
        {
            System.out.println("Invalid Year");
            System.out.println("Enter new Date");
            return false;
            //להכניס תאריך חדש ולבדוק תקינות
        }
        return true;

    }

    public static boolean isValidDate(String inDate)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:ms");
        dateFormat.setLenient(false);
        try
        {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe)
        {
            return false;
        }
        return true;

    }

}

