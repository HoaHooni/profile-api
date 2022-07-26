package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Education")
@Data
@NoArgsConstructor
@SuperBuilder
public class EducationEnity extends BaseEntity<Long>{

	@Column(name = "school")
	private String school;

	@Column(name = "degree")
	private String degree;

	@Column(name = "graduated")
	private String graduated;

	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private ResumeEntity resume;
}
