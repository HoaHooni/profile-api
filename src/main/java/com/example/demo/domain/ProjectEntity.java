package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@Entity
@Table(name = "Project")
@Setter
@Getter
@AllArgsConstructor
@SuperBuilder
public class ProjectEntity extends BaseEntity<Long> {

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "responsible")
	private String responisble;

	@Column(name = "languages")
	private String languages;

	@Column(name = "other")
	private String other;

	@Column(name = "from_date")
	private Timestamp fromDate;

	@Column(name = "to_date")
	private Timestamp toDate;

	@Column(name = "user_id")
	private Long userId;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private UserEntity user;
}
