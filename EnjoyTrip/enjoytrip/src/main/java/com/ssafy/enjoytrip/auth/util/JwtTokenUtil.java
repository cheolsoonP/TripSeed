package com.ssafy.enjoytrip.auth.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ssafy.enjoytrip.auth.dto.JwtUserDetails;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtil {
	
	private String SECRET_KEY = "your_secret_key";
	
	
	public String generateToken(JwtUserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}

	private String createToken(Map<String, Object> claims, String subject) {
		long currentTimeMillis = System.currentTimeMillis();
		long expirationMillis = currentTimeMillis + (5 * 60 * 1000); // 토큰 만료 시간은 5분으로 설정합니다.
		Date expiration = new Date(expirationMillis);
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(currentTimeMillis))
				.setExpiration(expiration)
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				.compact();	
	}		
		
	public boolean validateToken(String token, JwtUserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		final Date expiration = extractExpiration(token);
		return expiration.before(new Date());
	}

	private Date extractExpiration(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
	}

	private String extractUsername(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
	}
	
	
}
