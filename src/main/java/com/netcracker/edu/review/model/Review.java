package com.netcracker.edu.review.model;

import java.util.Date;


public class Review {

    public int getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public int getAuthorId() {
        return authorId;
    }

    public Mark getMark() {
        return mark;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateEdit() {
        return dateEdit;
    }

    public int getPlaceId() {
        return placeId;
    }

    private int id;
    private String review;
    private int authorId;
    private Mark mark;
    private Date dateCreation = new Date();
    private Date dateEdit = null;
    private int placeId;
    public Review() {
    }

}

