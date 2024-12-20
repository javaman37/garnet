package com.max.garnet.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.max.garnet.entities.User;


public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private final User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}

	public Long getUserId() {
		return user.getId();
	}
	@Override
	public String getUsername() {
		return user.getUsername();
	}
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));

	}

	

	

}
