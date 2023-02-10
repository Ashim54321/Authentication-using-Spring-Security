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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Content {
    @Id
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private UUID contentCode;
    @NotNull
    private String description;

}
