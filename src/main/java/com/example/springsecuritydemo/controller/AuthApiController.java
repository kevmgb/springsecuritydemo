package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.models.AuthRequest;
import com.example.springsecuritydemo.models.AuthResponse;
import com.example.springsecuritydemo.authentication.jwt.JwtTokenUtil;
import com.example.springsecuritydemo.entity.User;
import com.example.springsecuritydemo.service.JwtUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/auth")
public class AuthApiController {

    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthApiController(AuthenticationManager authenticationManager, JwtUserDetailsService jwtUserDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid AuthRequest request) {
        authenticate(request.getEmail(), request.getPassword());
        User user = jwtUserDetailsService.loadUserByUsername(request.getEmail());
        String accessToken = jwtTokenUtil.generateAccessToken(user);
        AuthResponse response = new AuthResponse(request.getEmail(), accessToken);
        return ResponseEntity.ok(response);

    }
    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }
}
