package laborator.model;

import java.util.List;

public class User {
    private String userName;
    private String password;
    private List<User> friends;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public List<User> getFriends() {
        return friends;
    }
}
