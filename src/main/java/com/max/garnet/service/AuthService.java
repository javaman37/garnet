package com.max.garnet.service;

import com.max.garnet.dto.JwtAuthResponse;
import com.max.garnet.dto.LoginRequestDTO;


public interface AuthService {

	JwtAuthResponse login(LoginRequestDTO loginRequestDto);

}
