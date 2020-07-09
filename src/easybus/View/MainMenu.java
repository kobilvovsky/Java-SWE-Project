package easybus.View;

import easybus.Model.Globals;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class MainMenu
{
    private String title = "[easyBus] Menu (" ;

    private JFrame mainFrame;
    private JPanel controlPanel;

    JLabel picLabel;

    private JComboBox classList;
    private JLabel headerLabel;
    private JButton insertButton;
    private JButton viewButton;

    private String[] options = { "Vehicles", "Station", "Route", "Passenger", "Worker" };

    public MainMenu(String title) throws IOException {
        // WINDOW DEFINITIONS
        mainFrame = new JFrame(getTitle());
        controlPanel = new JPanel();

        mainFrame.getContentPane();
        mainFrame.setSize(Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);

        // COMPONENETS INIT
        picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/logo.png")));

        headerLabel = new JLabel("Select Menu:");
        classList = new JComboBox(getOptionList());
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

        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public void initButtons(ActionListener al) {
        insertButton.addActionListener(al);
        viewButton.addActionListener(al);
    }
    public String getTitle() { return title; }
    public String[] getOptionList() { return options; }
    public void setTitle(String str) {
        title = str + " )";
    }
    public JComboBox getOptionsList() { return classList; }
}
