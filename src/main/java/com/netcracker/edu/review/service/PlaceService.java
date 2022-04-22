package com.netcracker.edu.review.service;

import com.netcracker.edu.review.model.Place;
import com.netcracker.edu.review.model.Review;
import com.netcracker.edu.review.model.User;
import com.netcracker.edu.review.model.ui.UiPlace;
import com.netcracker.edu.review.model.ui.UiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PlaceService {

    @Value("#{'${place-service-url}' + '${place-service-place}'}")
    private String placeServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    public Place getById(String id) {
        String url = placeServiceUrl + "/{id}";
        return restTemplate.getForObject(url, Place.class, id);
    }

    public Place getByAddress(String address) {
        String url = placeServiceUrl + "/{address}";
        return restTemplate.getForObject(url, Place.class, address);
    }

    public List<Place> getAll() {
        return Arrays.asList(restTemplate.getForObject(placeServiceUrl, Place[].class));
    }

    public ResponseEntity<Place> createPlace(UiPlace uiPlace) {
        HttpEntity request = new HttpEntity(uiPlace);
        return restTemplate.exchange(placeServiceUrl, HttpMethod.POST, request, Place.class);
    }

    public void deleteById(int   id) {
        String url = placeServiceUrl + "/{id}";
        restTemplate.delete(url, id);
    }

}
