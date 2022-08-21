package com.example.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Resume")
@Data
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
