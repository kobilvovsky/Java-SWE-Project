package easybus.Model;

public class Globals
{
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    public Globals() {

    }

    public static boolean isInt(String[] strArr) {
        for(int i = 0; i < strArr.length; i++) {
            for (char ch: strArr[i].toCharArray()) {
                if(!Character.isDigit(ch))
                    return false;
            }
        }

        return true;
    }
}
