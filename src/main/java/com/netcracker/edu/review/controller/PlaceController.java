package com.netcracker.edu.review.controller;

import com.netcracker.edu.review.model.Place;
import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.User;
import com.netcracker.edu.review.model.ui.UiPlace;
import com.netcracker.edu.review.model.ui.UiUser;
import com.netcracker.edu.review.service.PlaceService;
import com.netcracker.edu.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping("/place/{address}")
    public ResponseEntity<Place> getPlaceByAddress(@PathVariable("address") String address) {

        return ResponseEntity.ok(placeService.getByAddress(address));
    }

    @GetMapping("/place")
    public ResponseEntity<List<Place>> getAll() {

        return ResponseEntity.ok(placeService.getAll());
    }

    @PostMapping("/place")
    public ResponseEntity<Place> createUser(@RequestBody UiPlace uiPlace) {
        return placeService.createPlace(uiPlace);

    }

    @DeleteMapping("/place/{id}")
    public ResponseEntity<HttpStatus> deletePlaceById(@PathVariable("id") int id) {
        placeService.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
