package com.ssafy.enjoytrip.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.user.dto.UserDto;
import com.ssafy.enjoytrip.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	
//	@Override
//	public int idCheck(String userId) throws Exception {
//		return userMapper.idCheck(userId);
//	}

	@Override
	public void joinUser(UserDto userDto) throws Exception {
		userMapper.joinUser(userDto);
	}

//	@Override
//	public UserDto loginUser(Map<String, String> map) throws Exception {
//		return userMapper.loginUser(map);
//	}
//
//	
//	/* Admin */
//	@Override
//	public List<UserDto> listUser(Map<String, Object> map) throws Exception {
//		return userMapper.listUser(map);
//	}
//
//	@Override
//	public UserDto getUser(String userId) throws Exception {
//		return userMapper.getUser(userId);
//	}
//
//	@Override
//	public void updateUser(UserDto userDto) throws Exception {
//		userMapper.updateUser(userDto);
//	}
//
//	@Override
//	public void deleteUser(String userId) throws Exception {
//	}

}
