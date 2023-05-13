package com.ssafy.enjoytrip.auth.service;

import com.ssafy.enjoytrip.auth.dto.UserDto;

public interface UserService {
	public void joinUser(UserDto userDto) throws Exception;
	public String login(String userId, String userPassword) throws Exception;
	public void updateUserInfo(UserDto userDto) throws Exception;
}
