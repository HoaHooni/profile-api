package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Resume")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResumeEntity extends BaseEntity<Long> {

    @Column(name = "skill_message")
    private String skillMessage;

    @Column(name = "user_id")
    private Long userId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resume")
    private List<EducationEnity> educations;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resume")
    private List<WorkEntity> works;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "resume")
    private List<SkillEntity> skills;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

}
