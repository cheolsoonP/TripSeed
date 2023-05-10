package com.ssafy.enjoytrip.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.user.dto.UserDto;
import com.ssafy.enjoytrip.user.service.UserService;

@RestController
@RequestMapping("/users")
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
	public ResponseEntity<?> login(@RequestBody UserDto userDto) {
		try {
			UserDto user = userService.loginUser(userDto);
			
			if(user != null) {
				return new ResponseEntity<Void>(HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("일치하는 정보가 없습니다.\n 아이디 또는 비밀번호 확인 후 다시 로그인하세요!", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
		
	}
	
	@GetMapping("/logout")
	public ResponseEntity<?> logout() {
		//session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/info")
	public ResponseEntity<?> getUserInfo() {
		try {
			UserDto user = userService.getUserInfo("ssafy");
			if(user != null) {
				return new ResponseEntity<UserDto>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("로그인이 필요합니다.", HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/password")
	public ResponseEntity<?> updatePw(@RequestParam String newPw) {
		try {
			UserDto user = userService.getUserInfo("ssafy");
			if(user != null) {				
				user.setPw(newPw);
				userService.updatePw(user);
				return new ResponseEntity<Void>(HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("로그인이 필요합니다.", HttpStatus.UNAUTHORIZED);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/nickname")
	public ResponseEntity<?> updateNickname(@RequestParam String newNickname) {
		try {
			UserDto user = userService.getUserInfo("ssafy");
			if(user != null) {				
				user.setNickname(newNickname);
				userService.updateNickname(user);
				return new ResponseEntity<Void>(HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("로그인이 필요합니다.", HttpStatus.UNAUTHORIZED);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
	    try {
	        UserDto user = userService.getUserInfo(userId);
	        if (user != null) {
	            if (user.getId().equals(userId)) { // 현재 로그인된 사용자의 아이디와 삭제할 사용자 아이디가 일치하는 경우
	                userService.deleteUser(userId);
	                //session.invalidate(); // 세션 정보 삭제
	                return new ResponseEntity<Void>(HttpStatus.OK);
	            } else {
	                return new ResponseEntity<String>("삭제 권한이 없습니다.", HttpStatus.UNAUTHORIZED);
	            }
	        } else {
	            return new ResponseEntity<String>("로그인이 필요합니다.", HttpStatus.UNAUTHORIZED);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        return exceptionHandling(e);
	    }
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}