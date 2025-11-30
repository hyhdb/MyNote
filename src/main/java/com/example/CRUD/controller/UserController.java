package com.example.CRUD.controller;

import com.example.CRUD.dto.UserRequest;
import com.example.CRUD.entity.User;
import com.example.CRUD.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //사용자 생성(POST 요청)
    @PostMapping("/create")
    public User createUser(@RequestParam String name, @RequestParam int age) {
        return userService.createUser(name, age);
    }

    //사용자 전체 조회(GET 요청)
    @GetMapping("/list")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}