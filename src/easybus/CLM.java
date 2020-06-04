package easybus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class CLM
{
    int CURRENT_MENU_DIALOG;
    boolean isRUNNING;
    Dictionary<Integer, String> menuOption;
    Enumeration menu;

    public CLM() throws IOException
    {
        this.CURRENT_MENU_DIALOG = 0;
        this.isRUNNING = true;
        Dictionary<Integer, String> menuOption = new Hashtable<Integer, String>();
        this.menuOption = menuOption;

        populateOptions();
    }

    public void populateOptions() {
        //ArrayList[][] table = new ArrayList[10][10];
        //ArrayList<Integer, String> options = { {1, "2"}};

        // [1, 2, 6, 10, 14, 18] -> main menu options (+into & exit)
        // [3, 4, 5] -> Vehicles menu
        // [7, 8, 9] -> Stations menu
        // [11, 12, 13] -> Routes menu
        // [15, 16, 17] -> Passengers menu

        // [19] -> go back (special)


        menuOption.put(1, "Introduction");
        menuOption.put(2, "Vehicles menu");
        menuOption.put(3, "[Vehicles] insert");
        menuOption.put(4, "[Vehicles] view");
        menuOption.put(5, "[Vehicles] remove");

        menuOption.put(6, "View Stations");
        menuOption.put(7, "[Stations] insert");
        menuOption.put(8, "[Stations] view");
        menuOption.put(9, "[Stations] remove");

        menuOption.put(10, "View Routes");
        menuOption.put(11, "[Routes] insert");
        menuOption.put(12, "[Routes] view");
        menuOption.put(13, "[Routes] remove");

        menuOption.put(14, "View Persons");
        menuOption.put(15, "[Passengers] insert");
        menuOption.put(16, "[Passengers] view");
        menuOption.put(17, "[Passengers] remove");

        menuOption.put(18, "Exit");

        menuOption.put(19, "Go back");
    }

    /* MENU */




    /*
    System.out.println("The options are: ");
    while (menu.hasMoreElements()) { System.out.println(menu.nextElement()); }

    while (isRUNNING)
    {
        java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //name = in.readLine();
        CURRENT_MENU_DIALOG = Integer.parseInt(in.readLine());

        switch (CURRENT_MENU_DIALOG)
        {
            case 1:
            {
                System.out.println(".................");
                System.out.println("The options are: ");
                while (menu.hasMoreElements())
                {
                    System.out.println(menu.nextElement());
                }
                break;
            }
            case 2:
            {
                for (Car c : cars)
                    c.print();

                System.out.println("The options are: ");
                while (menu.hasMoreElements())
                {
                    System.out.println(menu.nextElement());
                }
                break;
            }
            case 3:
            {
                for (Station s : stations)
                    s.print();

                System.out.println("The options are: ");
                while (menu.hasMoreElements())
                {
                    System.out.println(menu.nextElement());
                }
                break;
            }
            case 4:
            {
                for (Lineroute l : routes)
                    l.print();

                System.out.println("The options are: ");
                while (menu.hasMoreElements())
                {
                    System.out.println(menu.nextElement());
                }
                break;
            }
            case 5:
            {
                for (Person p : persons)
                    p.print();

                System.out.println("The options are: ");
                while (menu.hasMoreElements())
                {
                    System.out.println(menu.nextElement());
                }
                break;
            }
            case 6:
            {
                System.out.println("You have chosen to exit! Have a great day!");
                isRUNNING = false;
                break;
            }
            default:
            {
                System.out.println("Entered wrong input!");
                System.out.println("The options are: ");
                while (menu.hasMoreElements())
                {
                    System.out.println(menu.nextElement());
                }
                break;
            }
        }
    }*/
}
