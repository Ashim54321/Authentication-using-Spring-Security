package com.authentication.lms.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(value = {"id"}, allowSetters = true)
@Entity
public class Location {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private UUID locationCode;
    @NonNull
    private String Name;
    @NonNull
    private String longitude;
    @NonNull
    private String latitude;
    @NonNull
    private String areaThumbnails;
    @NonNull
    private String postalCode;

    private String status;

}
