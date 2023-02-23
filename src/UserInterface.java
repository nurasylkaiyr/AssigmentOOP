import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    public JTextField textField1;
    public JPasswordField passwordField1;
    public JButton loginButton;
    private JPanel panel1;

    public UserInterface() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
