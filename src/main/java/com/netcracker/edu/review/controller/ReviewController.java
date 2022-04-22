package com.netcracker.edu.review.controller;

import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.ui.UiReview;
import com.netcracker.edu.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/review")
    public ResponseEntity<Review> createReview(@RequestBody UiReview uiReviewUpdated) {
        return reviewService.createReview(uiReviewUpdated);

    }

    @GetMapping("/author/{authorId}/{page}")
    public ResponseEntity<List<Review>> getEmployeeByAuthorId(@PathVariable("authorId") int authorId, @PathVariable("page") int page) {
        List<Review> review = reviewService.getByAuthorId(authorId, page);
        return ResponseEntity.ok(reviewService.getByAuthorId(authorId, page));
    }

    @GetMapping("/place/{placeId}/{page}")
    public ResponseEntity<List<Review>> getEmployeeByPlaceId(@PathVariable("placeId") int placeId, @PathVariable("page") int page) {
        List<Review> review = reviewService.getByPlaceId(placeId, page);
        return ResponseEntity.ok(reviewService.getByPlaceId(placeId, page));
    }

    @GetMapping("/place/{placeId}/{authorId}/{page}")
    public ResponseEntity<List<Review>> findReviewByPlaceIdAndAuthorId(@PathVariable("placeId") int placeId, @PathVariable("authorId") int authorId, @PathVariable("page") int page) {
        List<Review> review = reviewService.getByPlaceIdAndAuthorId(placeId, authorId, page);
        return ResponseEntity.ok(reviewService.getByPlaceIdAndAuthorId(placeId, authorId, page));
    }


    @PutMapping("/review/{id}")
    public ResponseEntity<Review> putReviewById(@PathVariable("id") String id, @RequestBody UiReview uiReviewUpdated) {
        List<Review> review = reviewService.getById(id);
        return reviewService.putReview(id, uiReviewUpdated);

    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<HttpStatus> deleteReviewById(@PathVariable("id") String id) {
        reviewService.deleteById(id);
        return ResponseEntity.accepted().build();
    }

}
