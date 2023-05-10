package com.ssafy.enjoytrip.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ssafy.enjoytrip.auth.service.UserService;

import lombok.RequiredArgsConstructor;

/*
 * SpringSecurity는 기본적으로 모든 요청에 대해 인증을 확인한다.
 * */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AuthenticationConfig {
	
	private final UserService userService;
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.httpBasic().disable()
				.csrf().disable()
				.cors().and()
				.authorizeRequests()
				.antMatchers("/users/join","/users/login").permitAll() // 요청에 대해서 인증이 없어도 됨.
				.antMatchers(HttpMethod.POST, "**").authenticated() // Post 요청에 대해서 인증이 필요함
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				// username과 password로 인증을 했기 때문에 토큰을 준것이다. -> filter에서 처리를 한다. 
				.addFilterBefore(new JwtFilter(userService, secretKey), UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
}
