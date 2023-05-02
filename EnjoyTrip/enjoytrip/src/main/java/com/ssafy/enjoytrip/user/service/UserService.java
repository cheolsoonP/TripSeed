package com.ssafy.enjoytrip.user.service;

import java.util.List;
import java.util.Map;

import com.ssafy.enjoytrip.user.dto.UserDto;

public interface UserService {
	
//	int idCheck(String userId) throws Exception;
	void joinUser(UserDto userDto) throws Exception;
	UserDto loginUser(UserDto userDto) throws Exception;
	
//	/* Admin */
//	List<UserDto> listUser(Map<String, Object> map) throws Exception;
//	UserDto getUser(String userId) throws Exception;
//	void updateUser(UserDto userDto) throws Exception;
//	void deleteUser(String userId) throws Exception;
	
}
