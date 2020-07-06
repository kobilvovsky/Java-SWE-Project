package easybus;

import org.junit.*;


public class junitTesting
{


    @Before
    public void start()
    {

        System.out.println(" Start ______________________");

    }


    @After
    public void end()
    {

        System.out.println(" end ______________________");

    }
    @Test
    public void distanceTest()
           //
    {
        Station A;
        A = new Station(11000,5,4);
        Station B;
        B = new Station(10000,5,4);
        Lineroute AB = new Lineroute( B ,A );
        Assert.assertEquals(0,AB.getRoutDistance(),0);
    }

    @Test
    public void distanceTest1()
    {
        Station A1 = new Station(100,1,2);
        Station A2= new Station(110,5,5);
        Lineroute A12 = new Lineroute(A1,A2);
        Assert.assertEquals(2,A12.getRoutDistance(),0);
    }

    @Test
    public void seatTest()
    {
        Minibus A = new Minibus(2000,5,5,"mpd",10,10);
        Minibus AA = new Minibus(2000,5,5,"mpd",10,100);

        Assert.assertEquals(10,A.getNumOfSeat(),0);
        //Assert.assertEquals(100,AA.getNumOfSeat(),0);
    }

    @Test
    public void seatTest1()
    {
        Minibus C = new Minibus(2000,5,5,"mpd",20,25);
        Minibus CC = new Minibus(2000,5,5,"mpd",20,30);

        Assert.assertEquals(25,C.getNumOfSeat(),0);
        Assert.assertEquals(30,CC.getNumOfSeat(),0);

    }


}
