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
@Table(name = "Work")
@Data
@AllArgsConstructor
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name ="company")
	private String company;
	
	@Column(name ="title")
	private String title;
	
	@Column(name ="year_start")
	private long yearStart;
	
	@Column(name = "year_end")
	private Long yearEnd;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
}
