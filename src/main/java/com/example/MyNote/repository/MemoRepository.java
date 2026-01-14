//DB 대화 창구
package com.example.MyNote.repository;

import com.example.MyNote.entity.Memo;
import com.example.MyNote.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    // 이 인터페이스가 메모를 저장하고 찾는 모든 기능을 자동으로 제공
    List<Memo> findByUser(User user); //사용자 정보로 메모 목록을 찾는 메서드
}
