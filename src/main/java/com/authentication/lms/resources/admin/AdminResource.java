package com.authentication.lms.resources.admin;

import com.authentication.lms.service.applicationService.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/")
@RequiredArgsConstructor
public class AdminResource {

    private final SecurityService securityService;

    @GetMapping("/user")
    public UserDetails getLoggedUserDetail(){
        return securityService.getLoggedUserDetails();
    };
}
