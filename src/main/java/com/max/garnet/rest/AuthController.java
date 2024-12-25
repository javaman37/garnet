package com.max.garnet.rest;

import com.max.garnet.models.dto.JwtResponse;
import com.max.garnet.models.dto.LoginRequest;
import com.max.garnet.service.AuthenticationService;
import com.max.garnet.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            JwtResponse response = authService.login(loginRequest);
            return Utils.appendResponse(HttpStatus.OK, "Login success", response);
        } catch (Exception e) {
            log.error("Bad credentials provided: {}", e.getMessage());
            return Utils.appendResponse(HttpStatus.UNAUTHORIZED, "Login fail", "Incorrect login information");
        }
    }
}
