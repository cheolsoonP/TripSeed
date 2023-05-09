package com.ssafy.enjoytrip.auth.config;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
    private final Key key;

	public static String createJwt(String userId, String secretKey, Long expiredMs) {
		Claims claims = Jwts.claims();
		claims.put("userId", userId);
		
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(secretKey, SignatureAlgorithm.HS256)
				.compact();
		
	}
}
