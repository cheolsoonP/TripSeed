package com.ssafy.enjoytrip.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private String userId;
	private String userName;
	private String userNickname;
	private String userEmail;
	private String userPassword;
	private String salt;
	private String profile;
	
}
