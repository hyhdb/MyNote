package com.example.CRUD.service;

import com.example.CRUD.dto.PostRequest;
import com.example.CRUD.dto.PostResponse;
import com.example.CRUD.entity.Post;
import com.example.CRUD.exception.NotFoundException;
import com.example.CRUD.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponse create(PostRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());

        Post saved = postRepository.save(post);
        return new PostResponse(saved.getId(), saved.getTitle(), saved.getContent());
    }

    public List<PostResponse> getAll() {
        return postRepository.findAll().stream()
                .map(p -> new PostResponse(p.getId(), p.getTitle(), p.getContent()))
                .toList();
    }

    public PostResponse getOne(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("게시물이 존재하지 않습니다. id=" + id));

        return new PostResponse(post.getId(), post.getTitle(), post.getContent());
    }

    public PostResponse update(Long id, PostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("게시물이 존재하지 않습니다. id=" + id));

        post.setTitle(request.getTitle());
        post.setContent(request.getContent());

        Post updated = postRepository.save(post);
        return new PostResponse(updated.getId(), updated.getTitle(), updated.getContent());
    }

    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("게시물이 존재하지 않습니다. id=" + id));

        postRepository.delete(post);
    }
}
