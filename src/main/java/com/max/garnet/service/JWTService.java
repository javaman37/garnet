package com.max.garnet.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.max.garnet.entities.User;


public interface JWTService {

	String extractUserName(String jwt);

	boolean isTokenValid(String jwt, UserDetails userDetails);

	String generateToken(UserDetails userDetails);

	String generateResetToken(User user);

}
