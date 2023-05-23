package com.ssafy.enjoytrip.auth.service;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.auth.dto.FollowDto;
import com.ssafy.enjoytrip.auth.dto.UserDto;
import com.ssafy.enjoytrip.auth.mapper.UserMapper;
import com.ssafy.enjoytrip.auth.util.JwtUtil;
import com.ssafy.enjoytrip.auth.util.PasswordUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	private Long expiredMs = 1000 * 60 * 60L;
	
	@Override
	public void joinUser(UserDto userDto) throws Exception {
		String salt = PasswordUtil.generateSalt();
		userDto.setSalt(salt);
		userDto.setUserPassword(PasswordUtil.generateHash(userDto.getUserPassword(), salt));
		userMapper.joinUser(userDto);
	}
	
	@Override
	public Map<String, Object> login(String userId, String userPassword) throws Exception {
		// 인증과정
		Map<String, Object> authInfo = userMapper.getAuthInfo(userId);
		String currPassword = PasswordUtil.generateHash(userPassword, (String)authInfo.get("salt"));
		if(currPassword.equals(authInfo.get("userPassword"))) {
			log.info("일치합니다.");
			// 사용자 로그인 정보가 일치한다면 토큰 발급
			authInfo.put("authToken", JwtUtil.createJwt(userId, secretKey, expiredMs));
			authInfo.remove("salt");
			authInfo.remove("userPassword");
			return authInfo;
		}
		return null;

	}

	@Override
	public void updateUserInfo(UserDto userDto) throws Exception {
		Map<String, Object> authInfo = userMapper.getAuthInfo(userDto.getUserId());
		String currPassword = PasswordUtil.generateHash(userDto.getUserPassword(), (String)authInfo.get("salt"));
		if(currPassword.equals(authInfo.get("userPassword"))) {
			// 사용자 비밀번호가 같다면, 변경X
			userDto.setUserPassword(null);
		}else {// 비밀번호가 변경되었다면 새로운 비밀번호로 변경
			String salt = PasswordUtil.generateSalt();
			userDto.setSalt(salt);
			userDto.setUserPassword(PasswordUtil.generateHash(userDto.getUserPassword(), salt));			
		}
		userMapper.updateUserInfo(userDto);
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		userMapper.deleteUser(userId);
	}

	@Override
	public List<UserDto> searchUserList(Map<String, Object> map) throws Exception {
		return userMapper.searchUser(map);
	}

	@Override
	public void addFollowUser(FollowDto followDto) throws Exception {
		userMapper.addFollowUser(followDto);
	}

	@Override
	public List<UserDto> getFollowerList(String userId) throws Exception {
		return userMapper.getFollowerList(userId);
	}


}
