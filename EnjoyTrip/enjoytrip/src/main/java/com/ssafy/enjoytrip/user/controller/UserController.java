package com.ssafy.enjoytrip.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.user.dto.UserDto;
import com.ssafy.enjoytrip.user.service.UserService;

@RestController("/users")
@CrossOrigin("*")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/join")
	public ResponseEntity<?> join(UserDto userDto) {
		
		try {
			userService.joinUser(userDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDto, HttpSession session) {
		try {
			UserDto user = userService.loginUser(userDto);
			
			if(user != null) {
				session.setAttribute("userinfo", user);
				return new ResponseEntity<Void>(HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("일치하는 정보가 없습니다.\n 아이디 또는 비밀번호 확인 후 다시 로그인하세요!", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
		
	}
	
//	@GetMapping("/logout")
//	@GetMapping("/{userid}")
//	@PutMapping("/password")
//	@PutMapping("/nickname")
//	@DeleteMapping("/{userid}")
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}