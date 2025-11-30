package com.example.CRUD.service;

import com.example.CRUD.dto.UserRequest;
import com.example.CRUD.entity.User;
import com.example.CRUD.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    //생성자 주입(스프링이 자동으로 Repository 넣어줌)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //사용자 저장
    public User createUser(String name, int age) {
        User user = new User(name, age);
        return userRepository.save(user); // DB에 저장
    }

    //사용자 전체 조회
    public List<User> getUsers() {
        return userRepository.findAll(); //DB에서 전체 목록 조회
    }
}
