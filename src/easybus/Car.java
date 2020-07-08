package easybus;

public abstract class  Car extends Maintenance
{
    int licenseNum;
    String model;
    int year;

    // GPS location
    int posX;
    int posY;

    public Car(int yearlyCost, int fuelConsumption, int licenseNum, String model, int year)
    {
        super(yearlyCost, fuelConsumption);
        this.setLicenseNum(licenseNum);
        this.setModel(model);
        this.setYear(year);
        posX = 0;
        posY = 0;
    }

    public int getLicenseNum()
    {
        return licenseNum;
    }
    public void setLicenseNum(int licenseNum)
    {
        if (licenseNum<0||licenseNum>99999999)
        {
            System.out.println("Invalid licenseNum");
            System.out.println("Enter licenseNum");
            //להניס לתוך לייסנסנומ את זמן החדש
        }
        else
            this.licenseNum = licenseNum;
    }

    public String getModel() { return model; }
    public void setModel(String model)
    {
        if (!isAlpha(model))
        {
            System.out.println("Invalid Model");
            System.out.println("Enter Model");
            //להכניס מודל תקין  ןלהשוות MODEL
        }
        else
            this.model = model;
    }

    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        if(year<1980 ||year>2021)
        {
            System.out.println("Invalid Year");
            System.out.println("Enter Year");
            //להכניס שנה תקינה  ןלהשוות year
        }
        else
            this.year = year;
    }

    public int getPosX() { return posX; }
    public int getPosY() { return posY; }
    public void setPosX(int posX)
    {
        // לא יודע ממש מה ההגבלות שלנו צריך לבדוק!
        this.posX = posX;
    }
    public void setPosY(int posY)
    {
        // לא יודע ממש מה ההגבלות שלנו צריך לבדוק!

        this.posY = posY;
    }

    public void print() {
        System.out.println("["+ getLicenseNum() + "]: " + getModel() + "/" + getYear());
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
    public abstract int getNumOfSeat();

}