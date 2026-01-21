package com.example.MyNote.exception;

import com.example.MyNote.dto.ApiResponse;
import com.example.MyNote.dto.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Void>> handleRuntimeException(RuntimeException e) {
        // ApiError 생성자에 (에러코드, 메시지) 두 개를 넣어야 합니다.
        // 에러코드는 임의로 "BAD_REQUEST"나 "400" 등으로 넣어주세요.
        ApiError apiError = new ApiError("400", e.getMessage());

        return ResponseEntity.ok(ApiResponse.fail(apiError));
    }
}