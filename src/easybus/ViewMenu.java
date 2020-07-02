package easybus;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ViewMenu extends GUIConstants
{
    private JFrame mainFrame;
    private JPanel controlPanel;

    private JButton deleteButton;
    private JTable table;

    String[][] data = {
            { "1", "Steve", "AUS" },
            { "2", "Virat", "IND" },
            { "3", "Kane", "NZ" },
            { "4", "David", "AUS" },
            { "5", "Ben", "ENG" },
            { "6", "Eion", "ENG" },
    };
    String[] header = { "Rank", "Player", "Country" };

    public ViewMenu()
    {
        // WINDOW DEFINITIONS
        mainFrame = new JFrame("[easyBus] View Menu");
        controlPanel = new JPanel();

        mainFrame.getContentPane();
        mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // COMPONENETS INIT
        deleteButton = new JButton("Delete");
        table = new JTable(data, header);
        //prepareViewTable();

        // COMPONENETS LOCATION
        //table.setBounds(WINDOW_WIDTH/16, WINDOW_HEIGHT/16, WINDOW_WIDTH-120, WINDOW_HEIGHT-120);
        deleteButton.setBounds(WINDOW_WIDTH/16, 500, 70, 35);

        // COMPONENTS TO PANEL
        mainFrame.add(controlPanel);
        controlPanel.add(new JScrollPane(table));
        controlPanel.add(deleteButton);

        // EVENTS
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    private void prepareViewTable() {
        /*switch(getCurrentData()) {
            case VEHICLE:
            case STATION:
            case ROUTE:
            case CUSTOMER:
            case WORKER:
        }*/

        table = new JTable(data, header);
    }
}
