package com.canaristar.backend.controller;

import com.canaristar.backend.config.AdminConfig;
import com.canaristar.backend.entity.User;
import com.canaristar.backend.enums.Role;
import com.canaristar.backend.request.AuthRequest;
import com.canaristar.backend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminConfig adminConfig;

    @PostMapping("/make-admin")
    public ResponseEntity<?> makeAdmin(@RequestBody AuthRequest authRequest) {
        Optional<User> user = userService.findByEmail(authRequest.getEmail());

        if (user.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        if (!authRequest.getPassword().equals(adminConfig.getAdminCreationPassword())) {
            return new ResponseEntity<>("Incorrect password", HttpStatus.UNAUTHORIZED);
        }

        User existingUser = user.get();
        existingUser.setRole(Role.ADMIN);

        userService.saveUser(existingUser);

        return  new ResponseEntity<>("Admin created", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.findAll();

        if(users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
