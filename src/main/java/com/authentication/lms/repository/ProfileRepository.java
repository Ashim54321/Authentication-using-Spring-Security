package com.authentication.lms.repository;

import com.authentication.lms.domain.ProfileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface ProfileRepository extends JpaRepository<ProfileInfo,Long> {

    @Query(
            "select pp from ProfileInfo pp where pp.user.userCode=:userCode"
    )
   ProfileInfo findProfileInfoByUserCode(@Param("userCode") UUID userCode);

}
