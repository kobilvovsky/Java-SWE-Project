package easybus;

public class Busdriver extends Person
{
    int yearExp;
    int salary;
    int warnings;

    public Busdriver(String name, String sex, int age, int yearExp, int salary, int warnings)
    {
        super(name, sex, age);
        this.yearExp = yearExp;
        this.salary = salary;
        this.warnings = warnings;
    }

    public int getYearExp()
    {
        return yearExp;
    }

    public void setYearExp(int yearExp)
    {
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
