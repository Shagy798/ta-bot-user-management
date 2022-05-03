package com.netcracker.edu.api.manager;

import com.netcracker.edu.api.model.Review;
import com.netcracker.edu.api.model.ui.UiReview;
import com.netcracker.edu.api.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewManager {

    @Autowired
    private ReviewService reviewService;

    public ResponseEntity<Review> createReview(UiReview uiReviewUpdated) {
        return reviewService.createReview(uiReviewUpdated);
    }

    public List<Review> getByAuthorId(int authorId, int page) {
        return reviewService.getByAuthorId(authorId, page);
    }

    public List<Review> getByPlaceId(int placeId, int page) {
        return reviewService.getByPlaceId(placeId, page);
    }

    public List<Review> getByMarkIdAndPlaceId(int markId, int placeId, int page) {
        return reviewService.getByMarkIdAndPlaceId(markId, placeId, page);
    }

    public List<Review> getByPlaceIdAndAuthorId(int placeId, int authorId, int page) {
        return reviewService.getByPlaceIdAndAuthorId(placeId, authorId, page);
    }

    public ResponseEntity<Review> putReview(String id, UiReview uiReviewUpdated) {
        return reviewService.putReview(id, uiReviewUpdated);
    }

    public void deleteById(String id) {
        reviewService.deleteById(id);
    }
}
