package com.example.harrisonj2.invite;

/**
 * Created by harrisonj2 on 12/8/2015.
 */
public class Host {
    private int id;
    private String email;

    public Host(){
    }

    public Host(String email){
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
