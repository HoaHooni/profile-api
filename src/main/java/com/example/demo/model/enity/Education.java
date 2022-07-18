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
@Table(name = "Education")
@Data
@AllArgsConstructor
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

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
	private Resume resume;
}
