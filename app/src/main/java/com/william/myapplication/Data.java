package com.william.myapplication;

public class Data {
    private String username;
    private String password;
    private String counter;


    public Data(String username, String password) {
        this.username = username;
        this.password = password;
//        this.counter = counter;
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

    public String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

}
