package com.ssafy.enjoytrip.auth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.ssafy.enjoytrip.attraction.dto.AttractionDto;
import com.ssafy.enjoytrip.auth.dto.FollowDto;
import com.ssafy.enjoytrip.auth.dto.UserDto;
import com.ssafy.enjoytrip.auth.service.UserService;
import com.ssafy.enjoytrip.board.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/join")
	public ResponseEntity<?> joinUser(@RequestBody UserDto userDto){
		try {
			userService.joinUser(userDto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		//201 Created 클라이언트의 요청을 서버가 정상적으로 처리했고 새로운 리소스가 생겼다.
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDto userDto ){
		Map<String, Object> authInfo = new HashMap<>();
		try {
			authInfo = userService.login(userDto.getUserId(), userDto.getUserPassword());
			// 입력한 정보가 올바르다면 토큰 발급
			if(authInfo != null) {
				return new ResponseEntity<Map<String, Object>>(authInfo, HttpStatus.OK);
			}
			// 잘못된 정보 입력할 경우 badRequest
			return ResponseEntity.badRequest().body("다시 입력해주세요.");
		} catch (Exception e) {
			return exceptionHandling(e);
		}

	}
	
	@PutMapping("/modify")
	public ResponseEntity<?> updateUserInfo(@RequestBody UserDto userDto) {
		
		try {
			userService.updateUserInfo(userDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
	    try {
            userService.deleteUser(userId);
            return new ResponseEntity<Void>(HttpStatus.OK);
	    } catch (Exception e) {
	        return exceptionHandling(e);
	    }
	}
	

	@GetMapping("/search")
	public ResponseEntity<?> searchUserList(
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "userNickname", required = false) String userNickname) 
	{
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("userId", userId);
			map.put("userNickname", userNickname);
			List<UserDto> userList;
			userList = userService.searchUserList(map);
			System.out.println(userList);
			return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/{userId}/following")
	public ResponseEntity<?> addFollowUser(@RequestBody Object followingUserId, 
			@PathVariable String userId){
		try {
			FollowDto followDto = new FollowDto();
			followDto.setUserId(userId);
			followDto.setFollowingUserId(followingUserId.toString());
			userService.addFollowUser(followDto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		//201 Created 클라이언트의 요청을 서버가 정상적으로 처리했고 새로운 리소스가 생겼다.
	}
	
	@GetMapping("/{userId}/followers")
	public ResponseEntity<?> getFollowerList(@PathVariable String userId) {
		try {
			List<UserDto> userList;
			userList = userService.getFollowerList(userId);
			System.out.println(userList);
			return new ResponseEntity<List<UserDto>>(userList, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
