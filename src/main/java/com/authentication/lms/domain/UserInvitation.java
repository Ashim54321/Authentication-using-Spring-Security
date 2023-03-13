package com.authentication.lms.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(value = {"id"}, allowSetters = true)
@Entity
public class UserInvitation {
    @Id
    @GeneratedValue
    private Long id;
    private UUID invitationCode;
    @OneToOne(cascade = CascadeType.ALL)
    private ProviderEntity providerEntity;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    private String Role;
    private LocalDateTime confirmationDate;
    private String status;
}
