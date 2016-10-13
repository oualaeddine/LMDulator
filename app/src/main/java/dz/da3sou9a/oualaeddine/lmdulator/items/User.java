package dz.da3sou9a.oualaeddine.lmdulator.items;

/**
 * Created by Ouala eddine on 01/10/2016.
 */

public class User {
    private String password,userName;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
