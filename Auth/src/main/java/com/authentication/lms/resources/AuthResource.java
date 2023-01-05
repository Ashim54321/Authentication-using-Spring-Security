package com.authentication.lms.resources;

import com.authentication.lms.security.AuthenticationRequest;
import com.authentication.lms.security.AuthenticationResponce;
import com.authentication.lms.security.RegisterRequest;
import com.authentication.lms.security.SecurityConfiguration;
import com.authentication.lms.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class AuthResource {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponce> register(@RequestBody RegisterRequest request){
     return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponce> register(@RequestBody AuthenticationRequest request){
      return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
