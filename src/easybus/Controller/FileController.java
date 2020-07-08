package easybus.Controller;

import java.io.*;

public class FileController
{
    private String fileName;

    public FileController(String name) {
        setFileName(name);
    }

    public void setFileName(String name) { fileName = name; }
    public String getFileName() { return fileName; }

    public void saveFile(Object obj) throws IOException
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(getFileName() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();

            System.out.println("Saved file: " + getFileName().toString() + ".ser");
        } catch (IOException ex) {
            System.out.println("An error has occured: " + ex);
        }
    }

    public boolean loadFile(Object obj) throws IOException
    {
        try (FileInputStream fis = new FileInputStream(getFileName().toString() + ".ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            obj = ois.readObject();
            System.out.println("Loaded file: " + getFileName().toString() + ".ser");
            ois.close();

            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("An error has occured: " + e);
        }

        return false;
    }
}
