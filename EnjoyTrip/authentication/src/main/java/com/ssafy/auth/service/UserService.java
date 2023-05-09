package com.ssafy.auth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ssafy.auth.util.JwtUtil;

@Service
public class UserService {
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	private Long expiredMs = 1000 * 60 * 60L;
	
	public String login(String userName, String password) {
		// 인증과정 생략 -> 추후 인증 로직 추가
		
		
		// secretKey - 깃에 올라가면 안됨. 외부에 노출하면안됨.
		return JwtUtil.createJwt(userName, secretKey, expiredMs);
	}
}
