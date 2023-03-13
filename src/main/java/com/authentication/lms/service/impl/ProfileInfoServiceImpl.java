package com.authentication.lms.service.impl;

import com.authentication.lms.domain.ProfileInfo;
import com.authentication.lms.domain.User;
import com.authentication.lms.repository.ProfileRepository;
import com.authentication.lms.repository.UserRepository;
import com.authentication.lms.service.ProfileInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProfileInfoServiceImpl implements ProfileInfoService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;




    @Override
    public ProfileInfo getProfileInfo(UUID profileCode) {
        ProfileInfo info = profileRepository.findProfileInfoByUserCode(profileCode);
        if(info != null){
            return info;
        }
        throw new RuntimeException("USER NOT FOUND");
    }

    @Override
    public ProfileInfo updateProfileInfo(ProfileInfo profileInfo, UUID userCode) {

      ProfileInfo profileInfo1 = profileRepository.findProfileInfoByUserCode(userCode);
        if(profileInfo1 == null){
            ProfileInfo profileInfoObject = new ProfileInfo();
            profileInfoObject.setCity(profileInfo.getCity());
            profileInfoObject.setAltEmail(profileInfo.getAltEmail());
            profileInfoObject.setMunicipality(profileInfo.getMunicipality());
            profileInfoObject.setProvince(profileInfo.getProvince());
            profileInfoObject.setMobileNumber(profileInfo.getMobileNumber());
            profileInfoObject.setPhoneNumber(profileInfo.getPhoneNumber());
            profileInfoObject.setPermanentAddress(profileInfo.getPermanentAddress());
            profileInfoObject.setTemporaryAddress(profileInfo.getTemporaryAddress());
            profileInfoObject.setProfileCode(UUID.randomUUID());
            return profileRepository.save(profileInfo1);
        }
            profileInfo1.setCity(profileInfo.getCity());
            profileInfo1.setAltEmail(profileInfo.getAltEmail());
            profileInfo1.setMunicipality(profileInfo.getMunicipality());
            profileInfo1.setProvince(profileInfo.getProvince());
            profileInfo1.setMobileNumber(profileInfo.getMobileNumber());
            profileInfo1.setPhoneNumber(profileInfo.getPhoneNumber());
            profileInfo1.setPermanentAddress(profileInfo.getPermanentAddress());
            profileInfo1.setTemporaryAddress(profileInfo.getTemporaryAddress());
            return profileRepository.save(profileInfo1);
    };
}
