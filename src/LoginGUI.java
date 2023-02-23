import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class LoginGUI {
    public JFrame frame;
    public JPanel panel;
    public JLabel loginLabel;
    public JLabel passwordLabel;
    public JTextField loginField;
    public JPasswordField passwordField;
    public JButton loginButton;


    public LoginGUI() throws SQLException, NoSuchAlgorithmException {
        createUI();
    }

    public void createUI() throws SQLException, NoSuchAlgorithmException {
        frame = new JFrame("Login");
        frame.setSize(420, 420);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(new GridLayout(3, 2));

        loginLabel = new JLabel("Username or IIN:");
        panel.add(loginLabel);

        loginField = new JTextField();
        panel.add(loginField);

        passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    handleLogin();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        panel.add(loginButton);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void handleLogin() throws SQLException, NoSuchAlgorithmException {
        String login = loginField.getText();
        String pass = new String(passwordField.getPassword());
        CheckInfo CheckInfo = new CheckInfo(login, pass);
        CheckFunct CheckFunct = new CheckFunct(login, pass);
        HandleOperations handleOp = new HandleOperations();
        if(!CheckFunct.checklogin(login)){JOptionPane.showMessageDialog(frame, "Login must contain uppercase and lowercase letter, please try again.", "Error", JOptionPane.ERROR_MESSAGE);}
        else if(CheckFunct.checklength(pass)){JOptionPane.showMessageDialog(frame, "Password must be at least 6, please try again.", "Error", JOptionPane.ERROR_MESSAGE);}
        else{
            if (CheckInfo.data_check()) {
                JOptionPane.showMessageDialog(frame, "Login successful!");
            }
            else {
                if(handleOp.count == 0){JOptionPane.showMessageDialog(frame, "Invalid data, please try again.", "Error", JOptionPane.ERROR_MESSAGE);}
                else if(handleOp.count == 1){JOptionPane.showMessageDialog(frame, "You have been blocked for 30 seconds.", "Error", JOptionPane.ERROR_MESSAGE);}
                else if(handleOp.count == 2){JOptionPane.showMessageDialog(frame, "You have been blocked for 60 seconds.", "Error", JOptionPane.ERROR_MESSAGE);}
                else{JOptionPane.showMessageDialog(frame, "You have been blocked for 300 seconds.", "Error", JOptionPane.ERROR_MESSAGE);}
            }
        }
    }
}