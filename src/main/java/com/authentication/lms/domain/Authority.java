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
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(value = {"id"}, allowSetters = true)
@Entity
public class Authority {
    @Id
    @GeneratedValue
    private Long id;

    private UUID authorityCode;

    private String Role;

    @OneToOne(cascade = CascadeType.ALL)
    private ProviderEntity providerEntity;

    private String status;

}
