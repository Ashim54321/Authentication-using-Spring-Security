package com.authentication.lms.service;

import com.authentication.lms.security.AuthenticationRequest;
import com.authentication.lms.security.AuthenticationResponce;
import com.authentication.lms.security.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface AuthenticationService {

    public AuthenticationResponce register(RegisterRequest request);

    public AuthenticationResponce authenticate(AuthenticationRequest request);
}
