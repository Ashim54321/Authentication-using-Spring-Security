package com.authentication.lms.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Course extends AbstractAuditingEntity {
    @Id
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private UUID courseCode;

    private String image;
    @NotNull
    private String description;
    @NotNull
    private String slug;

    @OneToMany
    private List<Unit> courseUnit;
}
