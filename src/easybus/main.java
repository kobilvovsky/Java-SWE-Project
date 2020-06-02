package easybus;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class main
{
    public static void main(String[] args) throws IOException
    {
        /* MENU */
        Dictionary<Integer, String> menuOption = new Hashtable<Integer, String>();
        menuOption.put(1, "Introduction");
        menuOption.put(2, "View Vehicles");
        menuOption.put(3, "View Stations");
        menuOption.put(4, "View Routes");
        menuOption.put(5, "View Passengers");
        menuOption.put(6, "Exit");
        Enumeration menu = menuOption.elements();

        int CURRENT_MENU_DIALOG = 0;
        boolean RUNNING = true;

        // =====================
        Minibus mini = new Minibus(15000, 140, 22222222, "Mercedez", 2012, 30);
        Bus bus = new Bus(35000, 180, 12345678, "Mercedez", 2016, 50);
        Car[] cars = {mini, bus};

        Station first = new Station(1, 5, 5);
        Station second = new Station(2, 5, 10);
        Station[] stations = {first, second};

        Lineroute route = new Lineroute(first, second);
        Lineroute[] routes = {route};

        Busdriver roman = new Busdriver("Roman", 31333333, "M", 47, 3, 7500, 0);

        //public Passenger(float credit, int id, String dateOfSub,String name, String sex, int age)
        Passenger shalom = new Passenger(0, 31633333, "21/05/2010", "Shalom", "M", 24);
        Passenger roey = new Passenger(0, 316222222, "01/01/2020", "Roey", "M", 28);

        Person[] persons = {roman, shalom, roey};

        System.out.println("The options are: ");
        while (menu.hasMoreElements()) {
            System.out.println(menu.nextElement());
        }
        while(RUNNING) {
            java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //name = in.readLine();
            CURRENT_MENU_DIALOG = Integer.parseInt(in.readLine());

            switch(CURRENT_MENU_DIALOG) {
                case 1: {
                    System.out.println(".................");
                    System.out.println("The options are: ");
                    while (menu.hasMoreElements()) {
                        System.out.println(menu.nextElement());
                    }
                    break;
                }
                case 2: {
                    for (Car c: cars)
                        c.print();

                    System.out.println("The options are: ");
                    while (menu.hasMoreElements()) {
                        System.out.println(menu.nextElement());
                    }
                    break;
                }
                case 3: {
                    for (Station s: stations)
                        s.print();

                    System.out.println("The options are: ");
                    while (menu.hasMoreElements()) {
                        System.out.println(menu.nextElement());
                    }
                    break;
                }
                case 4: {
                    for (Lineroute l: routes)
                        l.print();

                    System.out.println("The options are: ");
                    while (menu.hasMoreElements()) {
                        System.out.println(menu.nextElement());
                    }
                    break;
                }
                case 5: {
                    for (Person p: persons)
                        p.print();

                    System.out.println("The options are: ");
                    while (menu.hasMoreElements()) {
                        System.out.println(menu.nextElement());
                    }
                    break;
                }
                case 6: {
                    System.out.println("You have chosen to exit! Have a great day!");
                    RUNNING = false;
                    break;
                }
                default: {
                    System.out.println("Entered wrong input!");
                    System.out.println("The options are: ");
                    while (menu.hasMoreElements()) {
                        System.out.println(menu.nextElement());
                    }
                    break;
                }
            }
        }
    }
}
