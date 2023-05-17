package hw1;

import java.security.InvalidParameterException;
import java.util.Objects;

public class User {
    private String login;
    private String email;

    private static String char1 ="@";
    private static String char2 =".";

    public User(){
    }

    public User(String login){
        validationLogin(login);
        this.login = login;
    }
    public User(String login, String email) {
        validationParameter(login, email);
        this.login = login;
        this.email = email;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void validationParameter(String login, String email) {
        validationLogin(login);
        if (login.equals(email)){
            throw new IllegalArgumentException("login and email are the same");
        }
        if (email == null || !email.contains(char1) || !email.contains(char2) ) {
            throw new IllegalArgumentException("Incorrect email");
        }
    }

    private void validationLogin(String login) {
        if (login == null) {
            throw new IllegalArgumentException("fields should be filled");
        }
        if (login.length() < 6){
            System.out.println("login.length() < 6");
            throw new IllegalArgumentException("the number of characters must be at least 6");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, email);
    }
}
