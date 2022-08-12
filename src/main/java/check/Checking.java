package check;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checking {
    public static boolean checkLogInInfo(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        String regex = "^[a-zA-Z0-9_/-]{3,40}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(regex);
        if (!login.matches(regex)) {
            throw new WrongLoginException("Incorrect login");
        }
        if (!password.matches(regex) ||
                !confirmPassword.matches(regex) ||
                !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Incorrect password");
        }
        return true;
    }
}