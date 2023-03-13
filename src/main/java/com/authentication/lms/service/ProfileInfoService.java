package com.authentication.lms.service;

import com.authentication.lms.domain.ProfileInfo;

import java.util.UUID;

public interface ProfileInfoService{


    ProfileInfo getProfileInfo(UUID userCode);

    ProfileInfo updateProfileInfo(ProfileInfo profileInfo , UUID userCode);

}
