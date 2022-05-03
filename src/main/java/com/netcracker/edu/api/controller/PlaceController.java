package com.netcracker.edu.api.controller;

import com.netcracker.edu.api.manager.PlaceManager;
import com.netcracker.edu.api.model.*;
import com.netcracker.edu.api.model.ui.UiPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PlaceController {

    @Autowired
    private PlaceManager placeManager;

    @GetMapping("/place/{address}")
    public ResponseEntity<Place> getPlaceByAddress(@PathVariable("address") String address) {
        return ResponseEntity.ok(placeManager.getByAddress(address));
    }

    @GetMapping("/place")
    public ResponseEntity<List<Place>> getAll() {
        return ResponseEntity.ok(placeManager.getAll());
    }

    @PostMapping("/place")
    public ResponseEntity<Place> createUser(@RequestBody UiPlace uiPlace) {
        return placeManager.createPlace(uiPlace);
    }

    @PostMapping("/place/category")
    public ResponseEntity <List<Rating>> findPopularPlace(@RequestBody Category category) {
       return ResponseEntity.ok(placeManager.placeByCategory(category));
    }

    @PostMapping("/place/placeid")
    public ResponseEntity <List<Place>> findPlaceById(@RequestBody Integer[] placeId){
        return ResponseEntity.ok(placeManager.getPlaceIds(placeId));
    }

    @DeleteMapping("/place/{id}")
    public ResponseEntity<HttpStatus> deletePlaceById(@PathVariable("id") int id) {
        placeManager.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
