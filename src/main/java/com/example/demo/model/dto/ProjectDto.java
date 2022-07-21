package com.example.demo.model.dto;

import java.security.PublicKey;
import java.util.List;

import com.example.demo.domain.ProjectEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProjectDto extends BaseDto<Long> {

	private String title;

	private String description;

	private String responisble;

	private String langages;

	private String other;

	private long dateFrom;

	private Long dateTo;

	public static ProjectDto convertToDto(ProjectEntity entity) {
		if (entity == null)
			return null;
		return ProjectDto.builder().title(entity.getTitle()).description(entity.getDescription())
				.responisble(entity.getResponisble()).langages(entity.getLangages()).other(entity.getOther())
				.dateFrom(entity.getDateFrom()).dateTo(entity.getDateTo()).build();
	}

	public static List<ProjectDto> convertToDtos(List<ProjectEntity> entitys) {
		if (entitys == null || entitys.size() == 0)
			return null;
		List<ProjectDto> projectDtos = entitys.stream().map(item -> ProjectDto.convertToDto(item)).toList();
		return projectDtos;
	}
}
