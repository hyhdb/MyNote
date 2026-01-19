package com.example.MyNote.service;

import com.example.MyNote.dto.MemoRequest;
import com.example.MyNote.dto.MemoResponse;
import com.example.MyNote.entity.Memo;
import com.example.MyNote.entity.User;
import com.example.MyNote.repository.MemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 이 클래스가 서비스 레이어 임을 스프링에 알림
public class MemoService {

    private final MemoRepository memoRepository;

    //의존성 주입을 위해 Repository 연결
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    //1. 메모 생성 로직
    public MemoResponse create(MemoRequest request, User currentUser) {
        Memo memo = new Memo();
        memo.setTitle(request.getTitle());  //요청받은 제목 담기
        memo.setContent(request.getContent()); //요청받은 내용 담기
        memo.setUser(currentUser); //메모에 현재 로그인한 사용자 정보를 연결

        Memo saved = memoRepository.save(memo); //DB에 저장

        //저장된 결과를 응답용 DTO에 담아 반환
        //DTO(Data Transfer Object, 데이터 전송 객체) 프로세스 간 데이터 전달하는 객체
        return new MemoResponse(saved.getId(), saved.getTitle(), saved.getContent());
    }

    // 2. 모든 메모 조회 로직
    public List<MemoResponse> getMyMemos(User currentUser) {
        // Repository에 findByUser 메서드를 추가하여 내 메모만 가져오기
        return memoRepository.findByUser(currentUser).stream()
                .map(m -> new MemoResponse(m.getId(), m.getTitle(), m.getContent())) //응답 양식으로 변환
                .toList();
    }

    //3. 메모 수정
    public MemoResponse update(Long id, MemoRequest request, User currentUser) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("메모를 찾을 수 없습니다."));

        //작성자 확인: 메모의 주인과 현재 로그인한 유저가 같은지 체크
        if (!memo.getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("수정 권한이 없습니다.");
        }

        memo.setTitle(request.getTitle());
        memo.setContent(request.getContent());
        Memo updated = memoRepository.save(memo);

        return new MemoResponse(updated.getId(), updated.getTitle(), updated.getContent());
    }

    //4. 메모 삭제
    public void delete(Long id, User currentUser) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("메모를 찾을 수 없습니다."));

        if (!memo.getUser().getId().equals(currentUser.getId())) {
            throw new RuntimeException("삭제 권한이 없습니다.");
        }

        memoRepository.delete(memo);
    }
}
