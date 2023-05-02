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
	
//	/* Admin */
//	List<UserDto> listUser(Map<String, Object> map) throws SQLException;
//	UserDto getUser(String userId) throws SQLException;
//	void updateUser(UserDto userDto) throws SQLException;
//	void deleteUser(String userId) throws SQLException;
	
}
