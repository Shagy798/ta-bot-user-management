package com.netcracker.edu.review.controller;

import com.netcracker.edu.review.model.User;
import com.netcracker.edu.review.model.ui.UiUser;
import com.netcracker.edu.review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody UiUser uiUser) {
        return userService.createUser(uiUser);

    }

    @PutMapping("/subscription/{id}")
    public ResponseEntity<User> putReviewById(@PathVariable("id") String id, @RequestBody UiUser uiUser) {
        User users  = userService.getById(id);
        return userService.putSubscription(id, uiUser);
    }

    @PutMapping("/city/{id}")
    public ResponseEntity<User> putCityByUserId(@PathVariable("id") String id, @RequestBody UiUser uiUser) {
        User users  = userService.getById(id);
        return userService.putCity(id, uiUser);

    }
}
