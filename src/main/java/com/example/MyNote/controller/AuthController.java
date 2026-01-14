package com.example.MyNote.controller;

import com.example.MyNote.dto.ApiResponse;
import com.example.MyNote.dto.LoginRequest;
import com.example.MyNote.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody LoginRequest request) {
        authService.register(request);
        return ApiResponse.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ApiResponse<String> login(@RequestBody LoginRequest request) {
        return ApiResponse.ok(authService.login(request));
    }
}

