//회원 저장소
package com.example.MyNote.repository;

import com.example.MyNote.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //로그인을 위해 아이디로 사용자를 찾는 기능을 추가
    Optional<User> findByUsername(String username);
}

