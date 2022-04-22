package com.netcracker.edu.review.model;

public class Place {

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Category getCategory() {
        return category;
    }

    private int id;
    private String city;
    private String address;
    private Category category;

}
