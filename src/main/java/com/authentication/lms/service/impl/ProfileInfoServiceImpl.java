package com.authentication.lms.service.impl;

import com.authentication.lms.domain.ProfileInfo;
import com.authentication.lms.domain.User;
import com.authentication.lms.repository.ProfileRepository;
import com.authentication.lms.repository.UserRepository;
import com.authentication.lms.service.ProfileInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProfileInfoServiceImpl implements ProfileInfoService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;


    @Override
    public ProfileInfo addProfileInfo(ProfileInfo profileInfo, UUID userCode) {

        User user = userRepository.findByUserCode(userCode)
                .orElseThrow(() -> new RuntimeException("USER NOT FOUND"));
        User userId = new User();
        userId.setId(user.getId());
        ProfileInfo profileInfo1 = new ProfileInfo();
        profileInfo1.setCity(profileInfo.getCity());
        profileInfo1.setAltEmail(profileInfo.getAltEmail());
        profileInfo1.setMunicipality(profileInfo.getMunicipality());
        profileInfo1.setProvince(profileInfo.getProvince());
        profileInfo1.setMobileNumber(profileInfo.getMobileNumber());
        profileInfo1.setPermanentAddress(profileInfo.getPermanentAddress());
        profileInfo1.setProfileCode(UUID.randomUUID());
        profileInfo1.setUser(userId);
        profileRepository.save(profileInfo1);
        return profileInfo1;
    }

    @Override
    public ProfileInfo getProfileInfo(UUID profileCode) {
        return profileRepository.findProfileInfoByUserCode(profileCode);
    }
}
