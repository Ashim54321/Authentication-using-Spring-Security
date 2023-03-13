package com.authentication.lms.resources;

import com.authentication.lms.domain.ProfileInfo;
import com.authentication.lms.domain.User;
import com.authentication.lms.repository.ProfileRepository;
import com.authentication.lms.repository.UserRepository;
import com.authentication.lms.service.ProfileInfoService;
import com.authentication.lms.service.applicationService.SecurityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor

public class ProfileInfoResource {

    private final ProfileInfoService profileInfoService;

    private final SecurityService securityService;
    private final UserRepository userRepository;


    @GetMapping
    public ResponseEntity<ProfileInfo> getProfileInfo(){
        UserDetails userDetails = securityService.getLoggedUserDetails();
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("USER NOT FOUND"));
        return ResponseEntity.ok(profileInfoService.getProfileInfo(user.getUserCode()));
    }


    @PutMapping
    public ResponseEntity<ProfileInfo> updateProfileInfo(
            @RequestBody ProfileInfo profileInfo
    ){
        UserDetails userDetails = securityService.getLoggedUserDetails();
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("USER NOT FOUND"));
        return ResponseEntity.ok(profileInfoService.updateProfileInfo(profileInfo,user.getUserCode()));
    }
}
