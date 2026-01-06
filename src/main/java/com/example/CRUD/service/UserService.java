package com.example.CRUD.service;

import com.example.CRUD.dto.UserRequest;
import com.example.CRUD.dto.UserResponse;
import com.example.CRUD.entity.User;
import com.example.CRUD.exception.NotFoundException;
import com.example.CRUD.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse create(UserRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());

        User saved = userRepository.save(user);

        return new UserResponse(saved.getId(), saved.getName(), saved.getAge());
    }

    public List<UserResponse> getAll() {
        return userRepository.findAll().stream()
                .map(u -> new UserResponse(u.getId(), u.getName(), u.getAge()))
                .toList();
    }

    public UserResponse getOne(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("회원이 존재하지 않습니다. id=" + id));

        return new UserResponse(user.getId(), user.getName(), user.getAge());
    }

    public UserResponse update(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("회원이 존재하지 않습니다. id=" + id));

        user.setName(request.getName());
        user.setAge(request.getAge());

        User updated = userRepository.save(user);
        return new UserResponse(updated.getId(), updated.getName(), updated.getAge());
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("회원이 존재하지 않습니다. id=" + id);
        }
        userRepository.deleteById(id);
    }
}
