package com.netcracker.edu.review.model.ui;

public class UiReview {

    public int getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getMark() {
        return mark;
    }

    public int getPlaceId() {
        return placeId;
    }

    private int id;
    private String review;
    private int authorId;
    private String mark;
    public int placeId;
}
