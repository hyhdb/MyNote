package com.example.CRUD.service;

import org.springframework.stereotype.Service;


//Service는 실제 로직이 들어가는 부분
//Controller는 Service를 호출함
//ex) 회원가입 로직, 리스트 조회, 글 작성
@Service
public class HelloService {
    public String getHelloMessage() {
        return "Hello from Service!";
    }
}
