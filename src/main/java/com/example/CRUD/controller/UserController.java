package com.example.CRUD.controller;

import com.example.CRUD.dto.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping("/create")
    public String createUser(@RequestBody UserRequest request) {
        return "User created: " + request.getName() + " (" + request.getAge() + ")";
    }
}
