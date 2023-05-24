package com.ssafy.enjoytrip.auth.service;

import java.util.List;
import java.util.Map;

import com.ssafy.enjoytrip.auth.dto.FollowDto;
import com.ssafy.enjoytrip.auth.dto.UserDto;

public interface UserService {
	public void joinUser(UserDto userDto) throws Exception;
	public  Map<String, Object> login(String userId, String userPassword) throws Exception;
	public void updateUserInfo(UserDto userDto) throws Exception;
	public void deleteUser(String userId) throws Exception;
	public List<UserDto> searchUserList(Map<String, Object> map) throws Exception;
	public void addFollowUser(FollowDto followDto) throws Exception;
	public List<UserDto> getFollowerList(String userId) throws Exception;
}
