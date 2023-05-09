package com.ssafy.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.auth.domain.dto.UserDto;
import com.ssafy.auth.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserDto userDto ){
		return ResponseEntity.ok().body(userService.login(userDto.getUserName(), ""));
	}
}
