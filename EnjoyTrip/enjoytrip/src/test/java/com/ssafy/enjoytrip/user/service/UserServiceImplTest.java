package com.ssafy.enjoytrip.user.service;

import static org.junit.jupiter.api.Assertions.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest()
@Transactional
@Slf4j
class UserServiceImplTest {
	
	
//	@Autowired
//	UserService userService;
//	
//	@Test
//	@DisplayName("회원가입 테스트")
//	void testJoinUser() {
//		UserDto userDto = new UserDto();
//		userDto.setId("ssafy2");
//		userDto.setEmail("ssafy2@ssafy.com");
//		userDto.setName("김싸피2");
//		userDto.setNickname("ssafy2");
//		userDto.setPw("1234");
//		
//		try {
//			userService.joinUser(userDto);
//		} catch (Exception e) {
//			fail("회원가입 실패");
//		}
//	}
//
//	@Test
//	@DisplayName("로그인 테스트")
//	void testLoginUser() {
//		UserDto userDto = new UserDto();
//		userDto.setId("ssafy");
//		userDto.setPw("1234");
//		
//		try {
//			userService.loginUser(userDto);
//		} catch (Exception e) {
//			fail("로그인 실패");
//		}
//	}
//
//	@Test
//	@DisplayName("회원정보 조회 테스트")
//	void testGetUserInfo() {
//		try {
//			userService.getUserInfo("ssafy");
//		} catch (Exception e) {
//			fail("정보 조회 실패");
//		}
//	}
//
//	@Test
//	@DisplayName("비밀번호 변경 테스트")
//	void testUpdatePw() {
//		UserDto userDto = new UserDto();
//		userDto.setId("ssafy");
//		userDto.setPw("1111");
//		try {
//			userService.updatePw(userDto);
//		} catch (Exception e) {
//			fail("비밀번호 변경 실패");
//		}
//	}
//
//	@Test
//	@DisplayName("닉네임 변경 테스트")
//	void testUpdateNickname() {
//		UserDto userDto = new UserDto();
//		userDto.setId("ssafy");
//		userDto.setNickname("hohoho");
//		try {
//			userService.updateNickname(userDto);
//		} catch (Exception e) {
//			fail("닉네임 변경 실패");
//		}
//	}
//
//	@Test
//	@DisplayName("회원 탈퇴 테스트")
//	void testDeleteUser() {
//		try {
//			userService.deleteUser("pcs");
//		} catch (Exception e) {
//			fail("탈퇴 실패");
//		}
//	}

}
