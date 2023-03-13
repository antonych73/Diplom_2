package praktikum;

public class UserCredentials {

    public final String password;
    public final String email;

    public UserCredentials(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public static UserCredentials getUserCredentials(User user) {
        return new UserCredentials(user.getPassword(), user.getEmail());
    }

    public static UserCredentials getUserCredentials(String password, String email) {
        return new UserCredentials(password, email);
    }

}