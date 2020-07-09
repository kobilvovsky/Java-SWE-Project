package easybus.View;

import easybus.Controller.InsertController;
import easybus.Controller.ViewController;
import easybus.Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InsertMenu
{
    private JFrame mainFrame;
    private JPanel controlPanel;

    private JLabel headerLabel;
    private JButton saveButton;

    private JLabel labels[];
    private JTextField inputField[];

    public InsertMenu()
    {
        // WINDOW DEFINITIONS
        mainFrame = new JFrame("Insert Menu");
        controlPanel = new JPanel();

        mainFrame.getContentPane();
        mainFrame.setSize(Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        controlPanel.setLayout(null);

        // COMPONENETS INIT
        initSet();
        saveButton = new JButton("Save");

        // COMPONENTS TO PANEL
        headerLabel.setBounds((Globals.WINDOW_WIDTH/3)+170, 50, 150, 35);

        mainFrame.add(controlPanel);
        controlPanel.add(saveButton);
        controlPanel.add(headerLabel);

        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public void initSet() { headerLabel = new JLabel("???"); }
    public void setSet(String str) { headerLabel.setText("Entering new " + str); }

    public JLabel getLabel(int i) { return labels[i]; }
    public int setLabel(int i, String[] str, int j) {
        labels[i] = new JLabel(str[j] + ":");
        return ++j;
    }
    public void setLabels(int length) { labels = new JLabel[length]; }
    public JLabel[] getLabels() { return labels; }
    public int getLabelsLength() { return getLabels().length; }

    public void initField(int i) { inputField[i] = new JTextField(); }
    public JTextField getField(int i) { return inputField[i]; }
    public void setField(String[] str) { inputField = new JTextField[str.length]; }
    public JTextField[] getFields() { return inputField; }
    public int getFieldsLength() { return getFields().length; }

    public JPanel getPanel() { return controlPanel; }
    public void addLabelToPane(int i) {  getPanel().add(getLabel(i)); }

    public void addFieldToPane(int i) {  getPanel().add(getField(i)); }

    public void setSaveButtonLoc(int x, int y, int w, int h) {
        saveButton.setBounds(x, y, w, h);
    }

    public void initButtons(ActionListener al) {
        saveButton.addActionListener(al);
    }
}
