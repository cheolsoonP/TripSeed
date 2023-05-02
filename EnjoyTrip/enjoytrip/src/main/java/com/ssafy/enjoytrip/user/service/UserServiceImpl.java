package com.ssafy.enjoytrip.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.user.dto.UserDto;
import com.ssafy.enjoytrip.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


	@Override
	public void joinUser(UserDto userDto) throws Exception {
		userMapper.joinUser(userDto);
	}

	@Override
	public UserDto loginUser(UserDto userDto) throws Exception {
		return userMapper.loginUser(userDto);
	}


	@Override
	public UserDto getUserInfo(HttpSession session) throws Exception {
		UserDto user = (UserDto) session.getAttribute("userInfo");		
		return user;
	}
}
