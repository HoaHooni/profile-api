package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "Work")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class WorkEntity extends BaseEntity<Long> {

    @Column(name = "company")
    private String company;

    @Column(name = "title")
    private String title;

    @Column(name = "year_start")
    private long yearStart;

    @Column(name = "year_end")
    private Long yearEnd;

    @Column(name = "description")
    private String description;

    @Column(name = "resume_id")
    private Long resumeId;

    @ManyToOne
    @JoinColumn(name = "resume_id", insertable = false, updatable = false)
    private ResumeEntity resume;

}
