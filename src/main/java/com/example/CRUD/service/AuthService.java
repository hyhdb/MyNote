package com.example.CRUD.service;

import com.example.CRUD.dto.LoginRequest;
import com.example.CRUD.dto.RegisterRequest;
import com.example.CRUD.entity.User;
import com.example.CRUD.repository.UserRepository;
import com.example.CRUD.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public void register(RegisterRequest request) {
        if (userRepository.existsByUserid(request.getUserid())) {
            throw new IllegalArgumentException("이미 존재하는 userid");
        }

        User user = new User();
        user.setUserid(request.getUserid());// userid 필드에 저장
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // 반드시 암호화

        userRepository.save(user);
    }

    public String login(LoginRequest request) {
        User user = userRepository.findByUserid(request.getUserid())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 userid"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호 불일치");
        }

        // 토큰 subject는 보통 String으로 넣음 (userid 또는 id)
        return jwtTokenProvider.createToken(user.getUserid());
        // 또는: return jwtTokenProvider.createToken(String.valueOf(user.getId()));
    }
}
