package com.ssafy.enjoytrip.auth.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ssafy.enjoytrip.auth.dto.JwtUserDetails;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Override
	public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       if ("your_username".equals(username)) {
           return new JwtUserDetails("your_username", "$2a$10$MHJy7TGLTJxuZsOgb52YKu2bATDrOugX9Q0jKfejpGWbylHxxJpmK", new ArrayList<>());
       } else {
           throw new UsernameNotFoundException("User not found with username: " + username);
       }
   }
}
