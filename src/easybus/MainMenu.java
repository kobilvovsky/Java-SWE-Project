package easybus;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MainMenu extends GUIConstants
{
    private JFrame mainFrame;
    private JPanel controlPanel;

    BufferedImage myPicture;
    JLabel picLabel;

    private JComboBox classList;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JButton insertButton;
    private JButton viewButton;
    //private JButton deleteButton; ??

    String[] options = { "Vehicles", "Station", "Route", "Customer", "Worker" };

    public MainMenu() throws IOException
    {
        // WINDOW DEFINITIONS
        mainFrame = new JFrame("[easyBus] Menu");
        controlPanel = new JPanel();

        mainFrame.getContentPane();
        mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // COMPONENETS INIT
        myPicture = ImageIO.read(new File("C:\\Users\\Erez\\Pictures\\logo.png"));
        picLabel = new JLabel(new ImageIcon(myPicture));

        headerLabel = new JLabel("Select Menu:");
        classList = new JComboBox(options); //classList.addActionListener();
        statusLabel = new JLabel("Control in action: Button");
        insertButton = new JButton("Insert");
        viewButton = new JButton("View");

        controlPanel.setLayout(null);

        // COMPONENETS LOCATION
        picLabel.setBounds(50, 50, 200, 200);
        headerLabel.setBounds((WINDOW_WIDTH/3)-50+90, 100, 90, 35);
        classList.setBounds(WINDOW_WIDTH/3+50+90, 100, 250, 35);
        statusLabel.setBounds(WINDOW_WIDTH/3+90, 300, 200, 35);

        insertButton.setBounds(WINDOW_WIDTH/3+50+90, 150, 70, 35);
        viewButton.setBounds(WINDOW_WIDTH/3+120+90, 150, 70, 35);

        // COMPONENTS TO PANEL
        mainFrame.add(controlPanel);
        controlPanel.add(picLabel);
        controlPanel.add(headerLabel);
        controlPanel.add(classList);
        controlPanel.add(statusLabel);
        controlPanel.add(insertButton);
        controlPanel.add(viewButton);

        // EVENTS
        //okButton.setActionCommand("Insert");
        insertButton.setActionCommand("Insert");
        viewButton.setActionCommand("View");

        insertButton.addActionListener(new ButtonClickListener());
        viewButton.addActionListener(new ButtonClickListener());

        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if(command.equals( "Insert" ))  {
                statusLabel.setText("Insert: " + (String) classList.getSelectedItem());
                changeDataTo();
            } else if(command.equals( "View" ))  {
                statusLabel.setText("View: " + (String) classList.getSelectedItem());
                changeDataTo();
                ViewMenu viewMenu = new ViewMenu();
            }
        }
    }

    private void changeDataTo() {
        int index = Arrays.asList(options).indexOf((String) classList.getSelectedItem());
        switch(index) {
            case 0:
                currentData = Data.VEHICLE;
                break;

            case 1:
                currentData = Data.STATION;
                break;

            case 2:
                currentData = Data.ROUTE;
                break;

            case 3:
                currentData = Data.CUSTOMER;
                break;
            case 4:
                currentData = Data.WORKER;
                break;
        }
    }
}
