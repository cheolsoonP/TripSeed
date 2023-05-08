package com.ssafy.enjoytrip.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.enjoytrip.auth.config.JwtTokenProvider;
import com.ssafy.enjoytrip.user.dto.UserDto;
import com.ssafy.enjoytrip.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;
	
    private final BCryptPasswordEncoder encoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
	
    public UserServiceImpl(UserMapper userMapper, 
            BCryptPasswordEncoder encoder, 
            AuthenticationManagerBuilder authenticationManagerBuilder, 
            JwtTokenProvider jwtTokenProvider) {
		this.userMapper = userMapper;
		this.encoder = encoder;
		this.authenticationManagerBuilder = authenticationManagerBuilder;
		this.jwtTokenProvider = jwtTokenProvider;
	}


	@Override
	public void joinUser(UserDto userDto) throws Exception {
		userMapper.joinUser(userDto);
	}

	@Override
	public UserDto loginUser(UserDto userDto) throws Exception {
		return userMapper.loginUser(userDto);
	}


	@Override
	public UserDto getUserInfo(String userId) throws Exception {
//		UserDto user = (UserDto) session.getAttribute("userInfo");
		return userMapper.getUserInfo(userId);
	}


	@Override
	public void updatePw(UserDto userDto) throws Exception {
		userMapper.updatePw(userDto);
	}


	@Override
	public void updateNickname(UserDto userDto) throws Exception {
		userMapper.updateNickname(userDto);
	}


	@Override
	public void deleteUser(String userId) throws Exception {
		userMapper.deleteUser(userId);
	}


	@Override
	public String login(String id, String password) throws Exception {
        UserDto user = userMapper.getUserInfo(id);
        if (user == null) {
            throw new UsernameNotFoundException("사용자가 존재하지 않습니다.");
        }

        // BCryptPasswordEncoder를 사용하여 입력한 비밀번호와 저장된 비밀번호를 비교
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        if (!passwordEncoder.matches(password, user.getPw())) {
        if(!user.getPw().equals(password)) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        // 사용자 정보로 인증 객체 생성
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 검증된 인증 정보로 JWT 토큰 생성
        String token = jwtTokenProvider.generateToken(authentication);

        return token;
	}
}
