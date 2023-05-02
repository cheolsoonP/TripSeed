package com.ssafy.enjoytrip.user.service;

import java.util.List;
import java.util.Map;

import com.ssafy.enjoytrip.user.dto.UserDto;

public interface UserService {
	
	void joinUser(UserDto userDto) throws Exception;
	UserDto loginUser(UserDto userDto) throws Exception;

}
