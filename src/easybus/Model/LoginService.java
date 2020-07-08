package easybus.Model;
import java.util.UUID;

public class LoginService
{
    private static LoginService instance = null;
    private LoginRepository loginRepo;

    private LoginService() {
        loginRepo = new LoginRepository();
    }

    public static LoginService getSingleton()
    {
        if (instance == null)
            instance = new LoginService();

        return instance;
    }

    public String login(String username, String password) {
        if (this.loginRepo.validateUser(username, password)) {
            return UUID.randomUUID().toString();
        }

        return null;
    }
}
