package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "Education")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EducationEnity extends BaseEntity<Long> {

    @Column(name = "school")
    private String school;

    @Column(name = "degree")
    private String degree;

    @Column(name = "graduated")
    private String graduated;

    @Column(name = "description")
    private String description;

    @Column(name = "resume_id")
    private Long resumeId;

    @ManyToOne
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private ResumeEntity resume;
}
