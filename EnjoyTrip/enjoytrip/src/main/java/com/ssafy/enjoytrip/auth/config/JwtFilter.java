package com.ssafy.enjoytrip.auth.config;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ssafy.enjoytrip.auth.service.UserService;
import com.ssafy.enjoytrip.auth.util.JwtUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
	
	/*
	 * JWT를 매번 인증해야한다. -> OncePerRequestFilter
	 * */
	
	private final UserService userService;
	private final String secretKey;
	
	// 인증을 하는데 권한을 부여한다.
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// 토큰이 있는지 확인
		final String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
		log.info("authorization : {}", authorization);
		
		// 토큰이 없다면 권한부여 하지 않음.
		if(authorization == null) {
			log.error("authorization이 없습니다. ");
			filterChain.doFilter(request, response);
			return;
		}
		
		// 토큰이 Bearer로 시작하고, 뒤에 유효한 토큰이 와야한다.
		if(authorization == null || !authorization.startsWith("Bearer ")) {
			log.error("Authorization을 잘못 보냈습니다.");
			filterChain.doFilter(request, response);
			return;
		}
		
		// Token 꺼내기 - Bearer제거
		String token = authorization.split(" ")[1];
		
		// Token Expired되었는지 여부 확인
		if (JwtUtil.isExpired(token, secretKey)) {
			// true이면 expired된 것이다. 
			log.error("Token이 만료되었습니다.");
			filterChain.doFilter(request, response);
			return;
		}
		
		// UserName Token에서 꺼내기 -> 추후 꺼내는 코드 추가
		String userName = JwtUtil.getUserName(token, secretKey);
		log.info(userName); // 잘 꺼내졌는지 확인
		
		// 권한 부여
		UsernamePasswordAuthenticationToken authenticationToken = 
				new UsernamePasswordAuthenticationToken(userName, null, Arrays.asList(new SimpleGrantedAuthority("USER"))); // User Role을 일단은 하드코딩으로 넣는다.
		// Arrays.asList() -> List.of() 가능, JAVA 9부터 지원
		
		// token에 detail 넣어준다. 
		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		
		// Authentication을 Set해준다. filter chain에 request를 넘겨주면 인증이 되었다고 도장이 찍힌다.
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		filterChain.doFilter(request, response);
	}
}
