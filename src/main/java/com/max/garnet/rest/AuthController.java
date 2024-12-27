package com.max.garnet.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.max.garnet.dto.JwtAuthResponse;
import com.max.garnet.dto.LoginRequestDTO;
import com.max.garnet.service.AuthService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private AuthService authService;

	
	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	// Đăng nhập tài khoản
	@PostMapping("/login")
	public ResponseEntity<?> logIn(@RequestBody LoginRequestDTO loginRequestDto) {
		try {

			JwtAuthResponse jwt = authService.login(loginRequestDto);
			return ResponseEntity.ok(jwt);
		} catch (BadCredentialsException e) {
			logger.error("Bad credentials provided: ", e);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Thông tin đăng nhập không chính xác");
		} catch (UsernameNotFoundException e) {
			logger.error("User not found: ", e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Người dùng không tồn tại");
		} catch (Exception e) {
			logger.error("Unexpected error during login: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi không xác định");
		}
	}

}
