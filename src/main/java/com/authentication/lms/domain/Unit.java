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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Unit extends AbstractAuditingEntity {
    @Id
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private UUID unitCode;
    @NotNull
    private String slug;
    @NotNull
    private String description;
    private String image;
    @OneToMany
    private List<Lesson> unitLesson;
}
