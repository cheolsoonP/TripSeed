package com.ssafy.enjoytrip.user.service;

import javax.servlet.http.HttpSession;

import com.ssafy.enjoytrip.user.dto.UserDto;

public interface UserService {
	
	void joinUser(UserDto userDto) throws Exception;
	UserDto loginUser(UserDto userDto) throws Exception;
	
	UserDto getUserInfo(HttpSession session) throws Exception;

}
