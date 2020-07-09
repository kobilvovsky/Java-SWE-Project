package easybus.View;

import easybus.Controller.DataController;
import easybus.Controller.LoginController;
import easybus.Controller.MainMenuController;
import easybus.Model.Globals;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginMenu extends JFrame {

    private JFrame mainFrame;
    private JPanel controlPanel;

    private JLabel picLabel;
    private JLabel largePicture;

    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton resetButton;
    private JCheckBox showPassword;

    private LoginController loginController;

    public LoginMenu() {
        mainFrame = new JFrame("Login Menu");
        controlPanel = new JPanel();

        mainFrame.getContentPane();
        mainFrame.setSize(Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        controlPanel.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlPanel.setLayout(null);

        picLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/logov2.png")));
        largePicture = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("images/bus.jpg")));

        userLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        showPassword = new JCheckBox("Show Password");

        picLabel.setBounds(50, 50, 200, 200);
        userLabel.setBounds((Globals.WINDOW_WIDTH/3)+40, 100, 90, 35);
        passwordLabel.setBounds((Globals.WINDOW_WIDTH/3)+40, 150, 90, 35);
        userTextField.setBounds(Globals.WINDOW_WIDTH/3+140, 100, 250, 35);
        passwordField.setBounds(Globals.WINDOW_WIDTH/3+140, 150, 250, 35);
        showPassword.setBounds(Globals.WINDOW_WIDTH/3+135, 185, 150, 30);
        loginButton.setBounds(Globals.WINDOW_WIDTH/3+140, 235, 100, 30);
        resetButton.setBounds(Globals.WINDOW_WIDTH/3+240, 235, 100, 30);
        largePicture.setBounds(50, 330, 700, 200);

        mainFrame.add(controlPanel);
        controlPanel.add(picLabel);
        controlPanel.add(largePicture);
        controlPanel.add(userLabel);
        controlPanel.add(passwordLabel);
        controlPanel.add(userTextField);
        controlPanel.add(passwordField);
        controlPanel.add(showPassword);
        controlPanel.add(loginButton);
        controlPanel.add(resetButton);

        // EVENTS
        loginButton.setActionCommand("Login");
        resetButton.setActionCommand("Reset");
        showPassword.setActionCommand("ShowPass");

        loginButton.addActionListener(new ButtonClickListener());
        resetButton.addActionListener(new ButtonClickListener());
        showPassword.addActionListener(new ButtonClickListener());

        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
    }

    private class ButtonClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Login")) {
                String userText = userTextField.getText();
                String pwdText = passwordField.getText();

                loginController = new LoginController();
                if(loginController.login(userText, pwdText)) {
                    try {
                        JOptionPane.showMessageDialog(null, "You are authorized!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);

                        DataController data = new DataController();
                        MainMenu mainMenu = new MainMenu(loginController.getUID());
                        MainMenuController controller = new MainMenuController(data, mainMenu, loginController.getUID());

                        mainFrame.dispose();
                        mainFrame.setVisible(false);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }

            // addons
            if (command.equals("Reset")) {
                userTextField.setText("");
                passwordField.setText("");
            }

            if (command.equals("ShowPass")) {
                if (showPassword.isSelected())
                    passwordField.setEchoChar((char) 0);
                else
                    passwordField.setEchoChar('*');
            }
        }
    }
}