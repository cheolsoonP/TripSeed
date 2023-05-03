package com.ssafy.enjoytrip.user.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.enjoytrip.user.dto.UserDto;

@Mapper
public interface UserMapper {

	void joinUser(UserDto userDto) throws SQLException;
	UserDto loginUser(UserDto userDto) throws SQLException;
	void updatePw(UserDto userDto) throws SQLException;
	void updateNickname(UserDto userDto) throws SQLException;
	void deleteUser(String userId) throws SQLException;
	UserDto getUserInfo(String userId) throws SQLException;
	
}
