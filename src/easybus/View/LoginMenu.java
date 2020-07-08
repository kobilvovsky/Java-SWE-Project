package easybus.View;

import easybus.Controller.DataController;
import easybus.Controller.LoginController;
import easybus.Controller.MainMenuController;
import easybus.Model.Globals;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginMenu extends JFrame {

    private JFrame mainFrame;
    private JPanel controlPanel;

    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton resetButton;
    private JCheckBox showPassword;

    private LoginController loginController;

    public LoginMenu() {
        mainFrame = new JFrame("[easyBus] Login");
        controlPanel = new JPanel();

        mainFrame.getContentPane();
        mainFrame.setSize(Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT);
        controlPanel.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlPanel.setLayout(null);

        userLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        showPassword = new JCheckBox("Show Password");

        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);

        mainFrame.add(controlPanel);
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