package com.ssafy.enjoytrip.auth.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class JwtUserDetails {

	   private String username;
	   private String password;
	   private Collection<? extends GrantedAuthority> authorities;

	   public JwtUserDetails(String username, String password, List<GrantedAuthority> grantedAuthorities) {
	       this.username = username;
	       this.password = password;
	       this.authorities = grantedAuthorities;
	   }

	   public String getUsername() {
	       return username;
	   }

	   public String getPassword() {
	       return password;
	   }

	   public Collection<? extends GrantedAuthority> getAuthorities() {
	       return authorities;
	   }

	   public boolean isAccountNonExpired() {
	       return true;
	   }

	   public boolean isAccountNonLocked() {
	       return true;
	   }

	   public boolean isCredentialsNonExpired() {
	       return true;
	   }

	   public boolean isEnabled() {
	       return true;
	   }
	}