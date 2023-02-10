package com.authentication.lms.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "entity")
public class EntityDetail extends AbstractAuditingEntity {

    @Id
    private Long id;

    @NotNull
    private String entityName;

    @NotNull
    private String address;

    @NotNull
    private  String city;

    @NotNull
    private  String province;

    private String logo;

    @NotNull
    private UUID entityCode;

    @NotNull
    private String contact;

    @NotNull
    private  Long phone;




}
