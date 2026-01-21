package com.example.MyNote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //RestController가 아닌 일반 Controller 사용
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index"; //templates/index.html 파일을 찾아가라는 뜻
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; //templates/login.html
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // templates/register.html 파일을 찾음
    }

    @GetMapping("/memos-view")
    public String memosPage() {
        return "memos"; //templates/memos.html
    }
}
