package seminars.third.tdd;

import java.util.Objects;

public class User {
    public String name;
    public String password;
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public boolean auth(String login, String password) {
        return Objects.equals(login, this.name) && Objects.equals(password, this.password);
        }
    }

