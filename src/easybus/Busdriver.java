package easybus;

public class Busdriver extends easybus.Person
{
    int yearExp;
    int salary;
    int warnings;

    public Busdriver(String name, int id, String sex, int age, int yearExp, int salary, int warnings)
    {
        super(id, name, sex, age);
        this.setYearExp(yearExp);
        this.setSalary(salary);
        this.setWarnings(warnings);
    }

    public int getYearExp()
    {
        return yearExp;
    }
    public void setYearExp(int yearExp)
    {
        if (yearExp<0||yearExp>80)
        {
            System.out.println("Invalid YearExp");
            System.out.println("Enter YearExp");
            //להניס לתוך אייראקפ את זמן החדש
        }
        else
            this.yearExp = yearExp;
    }

    public int getSalary()
    {
        return salary;
    }
    public void setSalary(int salary)
    {
        if (salary<0)
        {
            System.out.println("Invalid Salary");
            System.out.println("Enter Salary");
            //להניס לתוך סלרי את זמן החדש
        }
        else
            this.salary = salary;
    }

    public int getWarnings()
    {
        return warnings;
    }
    public void setWarnings(int warnings)
    {
        if (warnings<0)
        {
            System.out.println("Invalid Warnings");
            System.out.println("Enter Warnings");
            //להניס לתוך וורנינג את זמן החדש
        }
        else
            this.warnings = warnings;
    }
}
