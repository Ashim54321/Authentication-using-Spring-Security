package com.authentication.lms.resources;

import com.authentication.lms.security.AuthenticationRequest;
import com.authentication.lms.security.AuthenticationResponce;
import com.authentication.lms.security.RegisterRequest;
import com.authentication.lms.security.SecurityConfiguration;
import com.authentication.lms.service.AuthenticationService;
import com.authentication.lms.service.applicationService.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class AuthResource {

    private final AuthenticationService authenticationService;
    private final SecurityService securityService;

    @PostMapping("/register")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<AuthenticationResponce> register(@RequestBody RegisterRequest request){
     return ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/authenticate")
    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<AuthenticationResponce> register(@RequestBody AuthenticationRequest request){
      return ResponseEntity.ok(authenticationService.authenticate(request));
    }


}
