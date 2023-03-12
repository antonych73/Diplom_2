package praktikum;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;


public class User {

    private static final int LENGHT = 10;
    private final static String EMAIL_SUFFIX = "@gmail.ru";

    private String name;
    private String password;
    private String email;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public static User getCorrectUser() {
        return new User(random(), random(), random() + EMAIL_SUFFIX);
    }

    public static User getWithoutName(String name) {
        return new User(name, random(), random() + EMAIL_SUFFIX);
    }

    public static User getWithoutPassword(String password) {
        return new User(random(), password, random() + EMAIL_SUFFIX);
    }

    public static User getWithoutEmail(String email) {
        return new User(random(), random(), email);
    }

    public static String random() {
        return randomAlphabetic(LENGHT);
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
