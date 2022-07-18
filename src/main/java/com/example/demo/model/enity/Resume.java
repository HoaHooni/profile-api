package com.example.demo.model.enity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Resume")
@Data
@AllArgsConstructor
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resume")
	private Set<Education> educations;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resume")
	private Set<Work> works;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "resume")
	private Set<Skill> skills;


}
