package com.authentication.lms.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"altEmail"})
)
public class ProfileInfo  {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private UUID profileCode;
    @NotNull
    private String permanentAddress;
    private String temporaryAddress;
    @NotNull
    private String city;
    @NotNull
    private String municipality;
    @NotNull
    private String province;
    private String altEmail;
    private String phoneNumber;
    @NotNull
    private String mobileNumber;

    @OneToOne
    private User user;

}
