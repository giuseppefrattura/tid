package com.giuseppefrattura.tid.controller;

import com.giuseppefrattura.tid.model.UserModel;
import com.giuseppefrattura.tid.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserModel userModel;

    @Autowired
    private List<UserModel> users;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel user) {
        userModel = userRepository.save(user);
        log.info("Saved quote="+userModel.toString());
        if (userModel != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserModel>> getAllUsers() {

        users = userRepository.findAll();
        if (users.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }


    @DeleteMapping("/user")
    public ResponseEntity<UserModel> deleteUser(@RequestBody UserModel user) {
        userRepository.delete(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
