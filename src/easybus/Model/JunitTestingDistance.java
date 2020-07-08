package easybus.Model;

import org.junit.*;

public class JunitTestingDistance
{
    @Before
    public void start()
    {
        System.out.println(" Start __");
    }

    @Test
    public void DistanceTest1()
    {
        Station Atry1;
        Atry1 = new Station(5,10);
        Station Btry1;
        Btry1 = new Station(8,6);
        Lineroute ABtry1 = new Lineroute( Btry1 ,Atry1 );
        Assert.assertEquals(5,ABtry1.getRouteDistance(),0);
    }

    @Test
    public void DistanceTest2()
    {
        Station Atry2;
        Atry2 = new Station(4,2);
        Station Btry2;
        Btry2 = new Station(4,2);
        Lineroute ABtry2 = new Lineroute( Btry2 ,Atry2 );
        Assert.assertNotEquals(String.valueOf(0),10,ABtry2.getRouteDistance(),0);
    }

    @Test
    public void DistanceTest3()
    {
        Station Atry3;
        Atry3 = new Station(10,3);
        Station Btry3;
        Btry3 = new Station(0,3);
        Lineroute ABtry3 = new Lineroute( Btry3 ,Atry3 );
        Assert.assertEquals(10, ABtry3.getRouteDistance(), 0);
    }

    @Test
    public void cartext()
    {
        Car A = new Bus(11000,10,4,"Mazda",1998,1);
        Car B = new Minibus(11000,10,4,"Mazda",2000,50);

        Assert.assertEquals(1, A.getSeats(),0);
        Assert.assertEquals(50, B.getSeats(),0);
    }

    @After
    public void end()
    {
        System.out.println(" end __");
    }
}