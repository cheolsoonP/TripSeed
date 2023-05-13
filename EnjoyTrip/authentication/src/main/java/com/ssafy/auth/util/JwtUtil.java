package com.ssafy.auth.util;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	public static String getUserName(String token, String secretKey) {
		// username 꺼냄.
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
				.getBody().get("userName", String.class);
	}
	
	public static boolean isExpired(String token, String secretKey) {
		
		// 토큰이 Expired된게 현재보다 이전이면 -> expired된 것이다!
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
				.getBody().getExpiration().before(new Date());
	}
	
	/*
	 * Claim - 원하는 정보를 담아놓는 공간을 제공함.
	 * */
	public static String createJwt(String userName, String secretKey, Long expiredMs) {
		Claims claims = Jwts.claims();
		claims.put("userName", userName);
		
		return Jwts.builder()
				.setClaims(claims) // username이 claim에 있다. 
				.setIssuedAt(new Date(System.currentTimeMillis())) // 오늘 날짜를 넣어줘야한다. 
				.setExpiration(new Date(System.currentTimeMillis() + expiredMs))
				.signWith(SignatureAlgorithm.HS256, secretKey) // 이 알고리즘, 키로 사인되었다. 
				.compact();
	}			
}
