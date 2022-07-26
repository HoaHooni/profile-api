package com.example.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "User")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserEntity extends BaseEntity<Long> {

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "image")
	private String image;

	@Column(name = "bio")
	private String bio;

	@Column(name = "contact_message")
	private String contactMessage;

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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<SocialEntity> socials;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<ResumeEntity> resumes;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<ProjectEntity> projects;


}
