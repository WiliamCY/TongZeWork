package com.example.administrator.tongze.Entiy;

/**
 *
 * Created by admin on 2018/4/8.
 */

public class LoginUser {

    /**
     * id : 1
     * username : 15088403027
     * password : 219141
     * role : 0
     * timestamp : 1522655768
     * isFirstBind : 1
     * token : DD1B7652D5517C25B5E5095C336DDF02F7F1743A268F16264CA9FD564EA1ED78
     */

    private int  id;
    private String username;
    private String password;
    private String role;
    private String timestamp;
    private int isFirstBind;
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getIsFirstBind() {
        return isFirstBind;
    }

    public void setIsFirstBind(int isFirstBind) {
        this.isFirstBind = isFirstBind;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
