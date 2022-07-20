package com.example.demo.model.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDto extends BaseDto<Long>{

	private String name;

	private String description;

	private String image;

	private String bio;

	private String contactmessage;

	private String email;

	private String phone;

	private String github;

	private String project;

	private String facebook;

	private String linkedin;

	private String street;

	private String city;

	private String country;

	private String website;
	
	private List<SocialDto> socials; 
	
	private List<ResumeDto> resumes; 
	
	private List<ProjectDto> projects; 
	

}
