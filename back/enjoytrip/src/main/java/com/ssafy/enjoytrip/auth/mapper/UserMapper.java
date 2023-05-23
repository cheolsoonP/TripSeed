package com.ssafy.enjoytrip.auth.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.auth.dto.UserDto;



@Mapper
public interface UserMapper {

	
	void joinUser(UserDto userDto) throws SQLException;
	
	Map<String, Object> getAuthInfo(String userId) throws SQLException;

	void updateUserInfo(UserDto userDto) throws SQLException;
	
	void deleteUser(String userId) throws SQLException;
	
	UserDto getUserInfo(String userId) throws SQLException;

	List<UserDto> searchUser(Map<String, Object> map) throws SQLException;

}
