//메모장의 가장 핵심적인 기능 "쓰기", "읽기"
package com.example.MyNote.controller;

import com.example.MyNote.dto.ApiResponse;
import com.example.MyNote.dto.MemoRequest;
import com.example.MyNote.dto.MemoResponse;
import com.example.MyNote.service.MemoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //JSON 데이터를 주고받는 컨트롤러임을 선언
@RequestMapping("/memos") //이 컨트롤러의 기본 주소를 /memos로 설정
public class MemoController {
    private final MemoService memoService;

    //생성자를 통해 비즈니스 로직이 담긴 Service를 연결
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    //1. 메모 생성 (POST /memos)
    @PostMapping
    public ApiResponse<MemoResponse> create(@RequestBody MemoRequest request) {
        // @RequestBody: 사용자가 보낸 JSON 데이터를 객체로 변환
        return ApiResponse.ok(memoService.create(request));
    }

    //2. 모든 메모 조회 (GET /memos)
    @GetMapping
    public ApiResponse<List<MemoResponse>> getAll() {
        return ApiResponse.ok(memoService.getAll());
    }
}
