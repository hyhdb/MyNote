package com.example.CRUD.controller;

import com.example.CRUD.dto.ApiResponse;
import com.example.CRUD.dto.PostRequest;
import com.example.CRUD.dto.PostResponse;
import com.example.CRUD.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ApiResponse<PostResponse> create(@RequestBody PostRequest request) {
        return ApiResponse.ok(postService.create(request));
    }

    @GetMapping
    public ApiResponse<List<PostResponse>> getAll() {
        return ApiResponse.ok(postService.getAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<PostResponse> getOne(@PathVariable("id") Long id) {
        return ApiResponse.ok(postService.getOne(id));
    }

    @PutMapping("/{id}")
    public ApiResponse<PostResponse> update(
            @PathVariable("id") Long id,
            @RequestBody PostRequest request
    ) {
        return ApiResponse.ok(postService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable("id") Long id) {
        postService.delete(id);
        return ApiResponse.ok(null);
    }
}
