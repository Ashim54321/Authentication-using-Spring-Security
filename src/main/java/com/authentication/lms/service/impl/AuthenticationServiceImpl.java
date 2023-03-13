package com.authentication.lms.service.impl;

import com.authentication.lms.config.JwtService;
import com.authentication.lms.domain.User;
import com.authentication.lms.domain.enumaration.Role;
import com.authentication.lms.repository.UserRepository;
import com.authentication.lms.security.AuthenticationRequest;
import com.authentication.lms.security.AuthenticationResponce;
import com.authentication.lms.security.RegisterRequest;
import com.authentication.lms.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponce register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .userCode(UUID.randomUUID())
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponce.builder().token(jwtToken).build();
    }

    @Override
    public AuthenticationResponce authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new RuntimeException("USER NOT FOUND"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponce.builder().token(jwtToken).build();
    }
}
