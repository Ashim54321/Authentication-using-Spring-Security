package com.authentication.lms.service.applicationService;

import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityService {

    UserDetails getLoggedUserDetails();
}
