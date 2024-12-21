package com.max.garnet.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.max.garnet.config.CustomUserDetails;
import com.max.garnet.dao.UserDAO;
import com.max.garnet.dto.JwtAuthResponse;
import com.max.garnet.dto.LoginRequestDTO;

@Service
public class AuthServiceImpl implements AuthService {
	
	private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final UserDAO userDAO;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JWTService jwtService, UserDAO userDAO) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDAO = userDAO;
    }

	@Override
	public JwtAuthResponse login(LoginRequestDTO loginRequestDto) {
		//lấy thông tin đăng nhập
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequestDto.getUsername(), 
						loginRequestDto.getPassword()));
		//lấy thông tin ng dùng từ email
		var user = userDAO.findByUsername(loginRequestDto.getUsername())
				.orElseThrow(() -> new IllegalArgumentException("sai username hoặc mật khẩu"));
        
		// Chuyển đổi đối tượng `User` thành `CustomUserDetails`
	    CustomUserDetails userDetails = new CustomUserDetails(user);
	    
	   // Tạo token JWT bằng cách truyền `userDetails` vào phương thức `generateToken`
		var jwt = jwtService.generateToken(userDetails);
		
		// Tạo đối tượng `JwtAuthResponse` để trả về cho người dùng
		JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
		jwtAuthResponse.setToken(jwt);
		return jwtAuthResponse;
	}

}
