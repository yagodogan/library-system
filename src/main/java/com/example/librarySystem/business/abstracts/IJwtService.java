package com.example.librarySystem.business.abstracts;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface IJwtService {
    String extractUsername(String token);

    <T> T extractClaim(String token, Function <Claims, T> claims);

    boolean isTokenValid(String token, UserDetails userDetails);

    String generateToken(UserDetails userDetails);

    String generateToken(Map<String, Object> claims, UserDetails userDetails);
}
