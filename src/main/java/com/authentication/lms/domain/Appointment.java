package com.authentication.lms.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime reqTime;
    private UUID appointmentCode;
    @OneToOne
    private ProfileInfo client;
    @OneToOne
    private ProfileInfo provider;
    private LocalDateTime resTime;
    private String Status;
    @OneToOne
    private Location location ;
    @OneToOne
    private ProviderEntity providerEntity;
    @OneToOne
    private Feedback feedback;

}
