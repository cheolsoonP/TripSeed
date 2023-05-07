package com.ssafy.enjoytrip.auth.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ssafy.enjoytrip.auth.dto.JwtUserDetails;

public interface UserDetailsService {

	JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
