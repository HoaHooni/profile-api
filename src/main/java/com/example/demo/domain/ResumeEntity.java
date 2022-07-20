package com.example.demo.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Resume")
@Data
@AllArgsConstructor
public class ResumeEntity extends BaseEntity<Long>{
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resume")
	private Set<EducationEnity> educations;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resume")
	private Set<WorkEntity> works;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resume")
	private Set<SkillEntity> skills;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private UserEntity user;


}
