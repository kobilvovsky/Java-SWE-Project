package easybus;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;



public class main
{
    public static void main(String[] args) throws IOException //throws IOException
    {
        MainMenu mainMenu = new MainMenu();

        /*
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
        }*/
    }
}
