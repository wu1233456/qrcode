package com.qrcode.bean;

public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer admin;
    private String location;

    public User() {
    }

    public User(Integer id, String username, String password, Integer admin, String location) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", location='" + location + '\'' +
                '}';
    }
}
