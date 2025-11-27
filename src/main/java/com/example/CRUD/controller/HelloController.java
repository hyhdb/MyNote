package com.example.CRUD.controller;

import com.example.CRUD.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//Controller는 URL을 받아 처리하는 입구
//사용자의 HTTP 요청 -> 서비스 호출 -> 응답 반환
@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring!";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return helloService.getHelloMessage();
    }
}
