package com.chapinstore.service.security;

import com.chapinstore.entity.security.JwtToken;
import com.chapinstore.repository.security.JwtTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtTokenService {

    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    public Optional<JwtToken> getToken(String token) {
        return jwtTokenRepository.findByToken(token);
    }

    public void saveToken(String token) {
        jwtTokenRepository.save(new JwtToken(token));
    }

}
