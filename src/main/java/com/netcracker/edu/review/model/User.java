package com.netcracker.edu.review.model;


import java.util.Date;

public class User {

    private int id;
    private Role role;
    private String name;
    private Date registrationDate;
    private boolean subscription;

    public int getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public String getCity() {
        return city;
    }

    private String city;

}

