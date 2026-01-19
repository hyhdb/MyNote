//메모장의 가장 핵심적인 기능 "쓰기", "읽기"
package com.example.MyNote.controller;

import com.example.MyNote.dto.ApiResponse;
import com.example.MyNote.dto.MemoRequest;
import com.example.MyNote.dto.MemoResponse;
import com.example.MyNote.entity.User;
import com.example.MyNote.repository.UserRepository;
import com.example.MyNote.service.MemoService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //JSON 데이터를 주고받는 컨트롤러임을 선언
@RequestMapping("/memos") //이 컨트롤러의 기본 주소를 /memos로 설정
public class MemoController {
    private final MemoService memoService;
    private final UserRepository userRepository; //사용자 조회를 위해 추가

    //생성자를 통해 비즈니스 로직이 담긴 Service를 연결
    public MemoController(MemoService memoService, UserRepository userRepository) {
        this.memoService = memoService;
        this.userRepository = userRepository;
    }

    //1. 메모 생성 (POST /memos)
    @PostMapping
    public ApiResponse<MemoResponse> create(
            @RequestBody MemoRequest request,
            @AuthenticationPrincipal String username) {
        // @RequestBody: 사용자가 보낸 JSON 데이터를 객체로 변환
        //토큰에서 추출한 username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        return ApiResponse.ok(memoService.create(request, user));
    }

    //2. 내 메모만 조회: 로그인한 상요자의 메모만 가져옴 (GET /memos)
    @GetMapping
    public ApiResponse<List<MemoResponse>> getMyMemos(@AuthenticationPrincipal String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        return ApiResponse.ok(memoService.getMyMemos(user));
    }

    //3.메모 수정 (PUT /memos/{id})
    @PutMapping("/{id}")
    public ApiResponse<MemoResponse> update(
            @PathVariable("id") Long id,
            @RequestBody MemoRequest request,
            @AuthenticationPrincipal String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException(("사용자를 찾을 수 없습니다.")));

        return ApiResponse.ok(memoService.update(id, request, user));
    }

    //4.메모 삭제 (DELETE /memos/{id})
    @DeleteMapping("/{id}")
    public ApiResponse<String> delete(
            @PathVariable("id") Long id,
            @AuthenticationPrincipal String username) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));

        memoService.delete(id, user);
        return ApiResponse.ok("메모가 삭제되었습니다.");

    }
}
