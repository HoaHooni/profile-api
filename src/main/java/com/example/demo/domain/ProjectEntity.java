package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "Project")
@Data
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
	private String langages;

	@Column(name = "other")
	private String other;

	@Column(name = "date_from")
	private long dateFrom;

	@Column(name = "date_to")
	private Long dateTo;

	@Column(name = "user_id")
	private long userId;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private UserEntity user;
}
