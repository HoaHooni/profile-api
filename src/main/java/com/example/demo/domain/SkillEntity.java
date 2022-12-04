package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "Skill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SkillEntity extends BaseEntity<Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private int level;

    @Column(name = "description")
    private String description;

    @Column(name = "resume_id")
    private Long resumeId;

    @ManyToOne
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private ResumeEntity resume;
}
