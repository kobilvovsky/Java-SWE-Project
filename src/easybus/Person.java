package easybus;
import java.util.ArrayList;
import java.util.List;


public class Person
{
    String name;
    String sex;
    int age;
    int id;

    public Person(String name, String sex, int age){}

    public Person(int id, String name, String sex, int age)
    {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return sex;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    public void print() {
        System.out.println("["+ getId() + "]: " + getName() + "/" + getSex());
    }
}



