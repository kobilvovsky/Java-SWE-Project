package easybus;

import java.io.Serializable;

public class Busdriver extends Person implements Serializable
{
    int yearExp;
    int salary;
    int warnings;

    public Busdriver(String name, int id, String sex, int age, int yearExp, int salary)
    {
        super(id, name, sex, age);
        this.yearExp = yearExp;
        this.salary = salary;
        this.warnings = 0;
    }

    public int getYearExp()
    {
        return yearExp;
    }
    public void setYearExp(int yearExp)
    {
        if (yearExp < 0 || yearExp > 80)
            System.out.println("Invalid NumofSeat");
        else
            this.yearExp = yearExp;
    }

    public int getSalary()
    {
        return salary;
    }
    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public int getWarnings()
    {
        return warnings;
    }
    public void setWarnings(int warnings)
    {
        this.warnings = warnings;
    }
}
