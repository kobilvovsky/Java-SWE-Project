package easybus.Controller;
import easybus.Model.LoginService;

public class LoginController {

    private static LoginService loginService;
    private String UID = null;

    public LoginController() {
        loginService = LoginService.getSingleton();
    }

    public boolean login(String username, String password) {
        String session = loginService.login(username, password);
        setUID(session);

        if (getUID() != null) {
            System.out.println("token: " + session);
            return true;
        }

        return false;
    }

    public String getUID() { return UID; }
    public void setUID(String str) { UID = str; }
}
