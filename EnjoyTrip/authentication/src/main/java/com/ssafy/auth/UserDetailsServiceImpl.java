package com.ssafy.auth;

import java.sql.SQLException;
import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public MyUserDetails loadUserByUsername(String email){
    	User user;
		try {
			user = userMapper.findByEmail(email);
	    	MyUserDetails myUserDetails = new MyUserDetails(user, Collections.singleton(new SimpleGrantedAuthority(user.getRole().getValue())));
	        return myUserDetails;
		} catch (SQLException e) {
			new UserNotFoundException(email);
		}
		return null;
    }
    
}