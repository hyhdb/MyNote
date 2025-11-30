package com.example.CRUD.repository;

import com.example.CRUD.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DB와 연결되는 부분
//Service -> Repository -> DB 저장/조회
@Repository // 이 interface가 DB 작업을 담당하는 곳
public interface UserRepository extends JpaRepository<User, Long> {
    //JpaRepository가 save(), findAll(), findById(), deleteById()등 자동 제공
}
