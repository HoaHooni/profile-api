package com.example.demo.model.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Skill")
@Data
@AllArgsConstructor
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name ="name")
	private String name;
	
	@Column(name = "level")
	private int level;
	
	@Column(name ="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name ="resume_id")
	private Resume resume;
}
