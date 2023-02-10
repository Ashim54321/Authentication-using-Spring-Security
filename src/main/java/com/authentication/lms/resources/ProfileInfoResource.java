package com.authentication.lms.resources;

import com.authentication.lms.domain.ProfileInfo;
import com.authentication.lms.repository.ProfileRepository;
import com.authentication.lms.service.ProfileInfoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileInfoResource {

    private final ProfileInfoService profileInfoService;

    @PostMapping("/{userCode}")
    public ResponseEntity<ProfileInfo> addProfileInfo(
            @RequestBody ProfileInfo profileInfo,
            @PathVariable UUID userCode
            ){
        return ResponseEntity.ok(profileInfoService.addProfileInfo(profileInfo,userCode));
    }

    @GetMapping("/{userCode}")
    public ResponseEntity<ProfileInfo> getProfileInfo(@PathVariable UUID userCode){
        return ResponseEntity.ok(profileInfoService.getProfileInfo(userCode));
    }
}
