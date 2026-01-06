package com.example.CRUD.repository;

import com.example.CRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//DB와 연결되는 부분
//Service -> Repository -> DB 저장/조회
public interface UserRepository extends JpaRepository<User, Long> {
    //JpaRepository가 save(), findAll(), findById(), deleteById()등 자동 제공
    boolean existsByUserid(String userid);
    Optional<User> findByUserid(String userid);
}
