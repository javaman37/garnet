package com.max.garnet.service;

import com.max.garnet.models.dto.JwtResponse;
import com.max.garnet.models.dto.LoginRequest;

public interface AuthenticationService {
    JwtResponse login(LoginRequest request);
}
