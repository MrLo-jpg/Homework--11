import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public class Validator {
    private  static final Pattern LOGIN_PATTERN = Pattern.compile("[a-zA-Z0-9 _]{1,20}");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9 _]{1,20}");
    public static void validator(String login,String password,String confirnPassword){
       try {
           validatorLogin(login);
           validatorPassword(password,confirnPassword);
       }
       catch (WrongLoginException e) {
           System.out.println(e.getMessage());
       }catch (WrongPasswordException e) {
           System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
       finally {
           System.out.println("Проверка пройдена");
       }
    }


    private static void validatorLogin(String login) throws WrongLoginException {
        if (!LOGIN_PATTERN.matcher(login).matches()) {
            throw new WrongLoginException("Логин неверный");

        }

    }

    private static void validatorPassword(String password, String confirnPassword)throws WrongPasswordException {
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new WrongPasswordException("Пороль не верный");
        }
        if (!password.equals(confirnPassword)) {
            throw new WrongPasswordException("Пороли не совпадают");
        }

    }

}
