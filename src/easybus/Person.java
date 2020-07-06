package easybus;
public  class Person
{
    String name;
    String sex;
    int age;
    int id;


    public Person(String name, String sex, int age){}

    public Person(int id, String name, String sex, int age)
    {
        this.setId(id);
        this.setName(name);
        this.setSex(sex);
        this.setAge(age);
    }

    public int getId()
    {

        return id;

    }
    public void setId(int id)
    {
        if(id<100000000||id>999999999)
        {
            System.out.println("Invalid number");
            System.out.println("Enter id");
            //להכניס מספר תקין  ןלהשוות לid
        }
        else
        {
            this.id = id;
        }
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {

        if (!isAlpha(name))
        {
            System.out.println("Invalid Name");
            System.out.println("Enter Name");
            //להכניס שם תקין  ןלהשוות Name
        }
        else
            this.name = name;
    }

    public String getSex()
    {
        return sex;
    }
    public void setSex(String sex)
    {
        if(sex.toLowerCase().equals("male")|| sex.toLowerCase().equals("female"))
        {
            System.out.println("Invalid Sex");
            System.out.println("Enter Sex");
            // להכניס מין תקין ולהשוות לSEX
        }
        else
            this.sex = sex;
    }

    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        if(age<0||age>120)
        {
            System.out.println("Invalid Age");
            System.out.println("Enter Age");
            //ךהכניס גיל חדש ולהשוות לAGE
        }
        else
        {
            this.age = age;
        }
    }

    public void print()
    {
        System.out.println("["+ getId() + "]: " + getName() + "/" + getSex());
    }
    public boolean isAlpha(String name)
    {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
}



