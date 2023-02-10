package com.authentication.lms.service;

import com.authentication.lms.domain.ProfileInfo;

import java.util.UUID;

public interface ProfileInfoService{

    ProfileInfo addProfileInfo(ProfileInfo profileInfo, UUID userCode);

    ProfileInfo getProfileInfo(UUID userCode);

}
