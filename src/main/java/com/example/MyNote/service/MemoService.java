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
}
