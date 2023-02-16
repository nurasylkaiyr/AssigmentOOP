import java.util.Scanner;
public class UserInputHandler {
    public String getLogin() {
        System.out.print("Username or IIN: ");
        Scanner log = new Scanner(System.in);
        return log.nextLine();
    }

    public String getPassword() {
        System.out.print("Password: ");
        Scanner pas = new Scanner(System.in);
        return pas.nextLine();
    }
}