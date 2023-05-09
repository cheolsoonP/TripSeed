package com.ssafy.auth;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	User findByEmailAndPw(User user) throws SQLException;
	User findByEmail(String email) throws SQLException;
}
