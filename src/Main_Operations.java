import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;

public class Main_Operations{
    public boolean isTrue;
    public int count;
    RunTimer time = new RunTimer(isTrue, count);
    UserInputHandler userInputHandler = new UserInputHandler();

    public Main_Operations(boolean isTrue, int count) throws SQLException {
        this.isTrue = isTrue;
        this.count = count;
    }
    public void call_op(boolean isTrue, int count) throws SQLException, NoSuchAlgorithmException {
        while (!isTrue){
            String login = userInputHandler.getLogin();
            String pass = userInputHandler.getPassword();
            CheckInfo CheckInfo = new CheckInfo(login, pass);
            CheckFunct CheckFunctionality = new CheckFunct(login, pass);
            if(!CheckFunctionality.checklogin(login)){
                isTrue = false;
            }
            else{
                if(CheckFunctionality.checklength(pass)){
                }
                else {
                    if (CheckInfo.data_check()) {

                        isTrue = true;
                    } else {
                        count++;
                        time.timeRun(count);
                    }
                }
            }
        }
    }
}