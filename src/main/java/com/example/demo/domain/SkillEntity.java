package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Skill")
@Data
@AllArgsConstructor
@SuperBuilder
public class SkillEntity extends BaseEntity<Long> {

	@Column(name = "name")
	private String name;

	@Column(name = "level")
	private int level;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "resume_id")
	private ResumeEntity resume;
}
