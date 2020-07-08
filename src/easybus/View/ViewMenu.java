package easybus.View;

import easybus.Model.Globals;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewMenu
{
    private JFrame mainFrame;
    private JPanel controlPanel;

    private JButton deleteButton;
    private JTable table;
    private JScrollPane scrollPane;

    String[][] data;
    String[] header;

    public ViewMenu()
    {
        // WINDOW DEFINITIONS
        mainFrame = new JFrame("[easyBus] View");
        controlPanel = new JPanel();

        mainFrame.getContentPane();
        mainFrame.setSize(Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);

        // COMPONENETS INIT
        deleteButton = new JButton("Delete");

        // COMPONENETS LOCATION
        controlPanel.setLayout(new BorderLayout());
        deleteButton.setBounds(Globals.WINDOW_WIDTH-Globals.WINDOW_WIDTH/16, 500, 70, 35);

        // COMPONENTS TO PANEL
        mainFrame.add(controlPanel);

        controlPanel.add(deleteButton, BorderLayout.SOUTH);

        // EVENTS
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public void addScroll() { controlPanel.add(scrollPane, BorderLayout.CENTER); }
    public void initButtons(ActionListener al) {
        deleteButton.addActionListener(al);
    }

    public JTable getTable() { return table; }
    public void setTable(Object[][] row, Object[] col) { table = new JTable(row, col); }
    public JScrollPane getPane() { return scrollPane; }
    public void setScrollPane(Component c) { scrollPane = new JScrollPane(c); }
}
