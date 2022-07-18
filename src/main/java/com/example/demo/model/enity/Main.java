package com.example.demo.model.enity;

import java.util.List;

import javax.persistence.Column;
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
@Table(name = "Main")
@Data
@AllArgsConstructor
public class Main {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "bio")
	private String bio;

	@Column(name = "contactmessage")
	private String contactmessage;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "github")
	private String github;

	@Column(name = "project")
	private String project;

	@Column(name = "facebook")
	private String facebook;

	@Column(name = "linkedin")
	private String linkedin;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;

	@Column(name = "website")
	private String website;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "main")
	private List<Social> socials; 

}
