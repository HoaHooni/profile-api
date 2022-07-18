package com.example.demo.model.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Social")
@Data
@AllArgsConstructor
public class Social {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "class_name")
	private String className;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "main_id")
	private Main main;
}
