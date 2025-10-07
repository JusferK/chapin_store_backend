package com.chapinstore.repository.security;

import com.chapinstore.entity.security.JwtToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JwtTokenRepository extends JpaRepository<JwtToken, String> {

    Optional<JwtToken> findByToken(String token);

}
