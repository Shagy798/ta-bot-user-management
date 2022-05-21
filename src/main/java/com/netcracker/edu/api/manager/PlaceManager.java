package com.netcracker.edu.api.manager;

import com.netcracker.edu.api.model.Category;
import com.netcracker.edu.api.model.Place;
import com.netcracker.edu.api.model.Rating;
import com.netcracker.edu.api.model.ui.RatingResponse;
import com.netcracker.edu.api.model.ui.UiPlace;
import com.netcracker.edu.api.service.PlaceService;
import com.netcracker.edu.api.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceManager {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private RatingService ratingService;

    public List<RatingResponse> placeByCategory(Category category) {
        List<Place> placeByCategory = placeService.findPlaceByCategory(category);
        int[] placeIds = new int[placeByCategory.size()];
        for (int i = 0; i < placeByCategory.size(); i++) {
            placeIds[i] = placeByCategory.get(i).getId();
        }

        List<Rating> ratings = ratingService.findPopularPlace(placeIds);

        List<RatingResponse> ratingResponses = new ArrayList<>();

        for (int i = 0; i < ratings.size(); i++) {

            int ratingId = ratings.get(i).getId();

            RatingManager.createAnswer(ratings, placeByCategory, ratingResponses, i, ratingId);
        }

        return ratingResponses;
    }

    public Place getByAddress(UiPlace uiPlace) {
        return placeService.getByAddress(uiPlace);
    }

    public List<Place> getAll() {
        return placeService.getAll();
    }

    public ResponseEntity<Place> createPlace(UiPlace uiPlace) {
        return placeService.createPlace(uiPlace);
    }

    public void deleteById(int id) {
        placeService.deleteById(id);
    }

    public List<Place> getPlaceIds(Integer[] placeId) {
        return placeService.getPlaceIds(placeId);
    }

    public Place getByName(UiPlace uiPlace) {
        return placeService.getByName(uiPlace);
    }

    public Place getPlaceById(int id) {
        return placeService.getPlaceById(id);
    }
}
