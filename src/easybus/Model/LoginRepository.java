package easybus.Model;
import java.io.File;
import java.util.Scanner;

public class LoginRepository
{
    String filepath = "users.txt";

    public boolean validateUser(String username, String password) {
        boolean found = false;
        String itUser = "";
        String itPass = "";

        try {
            Scanner x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                itUser = x.next();
                itPass = x.next();
                if (itUser.equals(username) && itPass.trim().equals(password)) {
                    found = true;
                }
            }

            x.close();
        } catch (Exception ex) {
            System.out.println("Scanner error: " + ex);
        }

        if(found)
            return true;

        return false;
    }
}
