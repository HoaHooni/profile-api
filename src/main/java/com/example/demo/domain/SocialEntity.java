package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Social")
@Data
@AllArgsConstructor
@SuperBuilder
public class SocialEntity extends BaseEntity<Long> {

	@Column(name = "name")
	private String name;

	@Column(name = "url")
	private String url;

	@Column(name = "icon")
	private String icon;
	
	@Column(name = "user_id")
	private long userId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private UserEntity user;
}
