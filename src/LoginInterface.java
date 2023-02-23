import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class LoginInterface extends JDialog{
    private JFrame frame;
    private JPanel LoginPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton signInButton;

    public LoginInterface(JFrame parent){
        super(parent);
        setTitle("Authorization");
        setContentPane(LoginPanel);
        setMinimumSize(new Dimension(450, 430));
        setModal(true);
        setLocationRelativeTo(parent);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    handlelogin();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        setVisible(true);
    }

    private void handlelogin() throws SQLException, NoSuchAlgorithmException {
        String login = textField1.getText();
        String pass = new String(passwordField1.getPassword());
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
                boolean i = true;
                int k = 0;
                JOptionPane.showMessageDialog(frame, "Invalid data, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(frame, "You have been blocked for 30 seconds.", "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(frame, "You have been blocked for 60 seconds.", "Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(frame, "You have been blocked for 300 seconds.", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }

    public static void main(String[] args){
        LoginInterface myGUI = new LoginInterface(null);
    }
}
