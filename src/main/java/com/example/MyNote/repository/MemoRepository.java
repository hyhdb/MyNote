//DB 대화 창구
package com.example.MyNote.repository;

import com.example.MyNote.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    // 이 인터페이스가 메모를 저장하고 찾는 모든 기능을 자동으로 제공
}
