package com.ssafy.enjoytrip.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.auth.dto.UserDto;
import com.ssafy.enjoytrip.auth.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/join")
	public ResponseEntity<?> joinUser(@RequestBody UserDto userDto) throws Exception{
		userService.joinUser(userDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		//201 Created 클라이언트의 요청을 서버가 정상적으로 처리했고 새로운 리소스가 생겼다.
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserDto userDto ) throws Exception{
		String token = userService.login(userDto.getUserId(), userDto.getUserPassword());
		// 입력한 정보가 올바르다면 토큰 발급
		if(token != null) {
			return ResponseEntity.ok().body(token);			
		}
		// 잘못된 정보 입력할 경우 badRequest
		return ResponseEntity.badRequest().body("다시 입력해주세요.");		 
	}
}
