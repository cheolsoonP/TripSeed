package com.ssafy.auth.domain.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.auth.domain.dto.UserDto;


@Mapper
public interface UserMapper {

	Map<String, Object> getAuthInfo(String userId) throws SQLException;
	
	void joinUser(UserDto userDto) throws SQLException;

}
