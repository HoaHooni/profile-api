package com.example.demo.model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.domain.ProjectEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDto extends BaseDto<Long> {

	private String title;

	private String description;

	private String responisble;

	private String langages;

	private String other;

	private long dateFrom;

	private Long dateTo;

	private UserDto user;

	public static ProjectDto convertToDto(ProjectEntity entity) {
		return ProjectDto.builder().title(entity.getTitle()).description(entity.getDescription())
				.responisble(entity.getResponisble()).langages(entity.getLangages()).other(entity.getOther())
				.dateFrom(entity.getDateFrom()).dateTo(entity.getDateTo()).build();
	}
}
