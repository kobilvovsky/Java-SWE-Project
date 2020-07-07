package easybus.View;

import easybus.Model.Globals;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainMenu
{
    private JFrame mainFrame;
    private JPanel controlPanel;

    BufferedImage myPicture;
    JLabel picLabel;

    private JComboBox classList;
    private JLabel headerLabel;
    private JButton insertButton;
    private JButton viewButton;

    String[] options = { "Vehicles", "Station", "Route", "Passenger", "Worker" };

    public MainMenu(String title) throws IOException
    {
        // WINDOW DEFINITIONS
        title = "[easyBus] Menu (" + title + ")";
        mainFrame = new JFrame(title);
        controlPanel = new JPanel();

        mainFrame.getContentPane();
        mainFrame.setSize(Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);

        // COMPONENETS INIT
        myPicture = ImageIO.read(new File("C:\\Users\\Erez\\Pictures\\logo.png"));
        picLabel = new JLabel(new ImageIcon(myPicture));

        headerLabel = new JLabel("Select Menu:");
        classList = new JComboBox(options);
        insertButton = new JButton("Insert");
        viewButton = new JButton("View");

        controlPanel.setLayout(null);

        // COMPONENETS LOCATION
        picLabel.setBounds(50, 50, 200, 200);
        headerLabel.setBounds((Globals.WINDOW_WIDTH/3)-50+90, 100, 90, 35);
        classList.setBounds(Globals.WINDOW_WIDTH/3+50+90, 100, 250, 35);
        insertButton.setBounds(Globals.WINDOW_WIDTH/3+50+90, 150, 70, 35);
        viewButton.setBounds(Globals.WINDOW_WIDTH/3+120+90, 150, 70, 35);

        // COMPONENTS TO PANEL
        mainFrame.add(controlPanel);
        controlPanel.add(picLabel);
        controlPanel.add(headerLabel);
        controlPanel.add(classList);
        controlPanel.add(insertButton);
        controlPanel.add(viewButton);

        // EVENTS
        insertButton.setActionCommand("Insert");
        viewButton.setActionCommand("View");

        insertButton.addActionListener(new ButtonClickListener());
        viewButton.addActionListener(new ButtonClickListener());

        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            changeDataTo();
            if(command.equals("Insert"))  {
                InsertMenu insertMenu = new InsertMenu();
            } else if(command.equals("View"))  {
                ViewMenu viewMenu = new ViewMenu();
            }
        }
    }

    private void changeDataTo() {
        int index = Arrays.asList(options).indexOf((String) classList.getSelectedItem());
        switch(index) {
            case 0:
                Globals.setCurrentData(Globals.Data.VEHICLE);
                break;
            case 1:
                Globals.setCurrentData(Globals.Data.STATION);
                break;
            case 2:
                Globals.setCurrentData(Globals.Data.ROUTE);
                break;
            case 3:
                Globals.setCurrentData(Globals.Data.PASSENGER);
                break;
            case 4:
                Globals.setCurrentData(Globals.Data.WORKER);
                break;
        }
    }
}
