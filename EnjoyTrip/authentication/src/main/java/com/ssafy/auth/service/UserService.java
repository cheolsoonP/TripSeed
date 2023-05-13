package com.ssafy.auth.service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.auth.domain.dto.UserDto;
import com.ssafy.auth.domain.mapper.UserMapper;
import com.ssafy.auth.util.JwtUtil;
import com.ssafy.auth.util.PasswordUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	private UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	private Long expiredMs = 1000 * 60 * 60L;
	
	public void joinUser(UserDto userDto) throws Exception {
		String salt = PasswordUtil.generateSalt();
		userDto.setSalt(salt);
		userDto.setUserPassword(PasswordUtil.generateHash(userDto.getUserPassword(), salt));
		userMapper.joinUser(userDto);
	}
	
	public String login(String userId, String userPassword) throws Exception {
		
		// 인증과정
		Map<String, Object> authInfo = userMapper.getAuthInfo(userId);
		String currPassword = PasswordUtil.generateHash(userPassword, (String)authInfo.get("salt"));
		if(currPassword.equals(authInfo.get("userPassword"))) {
			log.info("일치합니다.");
			// 사용자 로그인 정보가 일치한다면 토큰 발급
			return JwtUtil.createJwt(userId, secretKey, expiredMs);
		}
		return null;

	}
}
