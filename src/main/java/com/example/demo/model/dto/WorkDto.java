package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.domain.WorkEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class WorkDto extends BaseDto<Long> {

	private String company;

	private String title;

	private long yearStart;

	private Long yearEnd;

	private String description;

	private ResumeDto resume;

	public static WorkDto convertToDto(WorkEntity entity) {
		if (entity == null)
			return null;
		return WorkDto.builder().company(entity.getCompany()).title(entity.getTitle()).yearStart(entity.getYearStart())
				.yearEnd(entity.getYearEnd()).description(entity.getDescription()).build();
	}

	public static List<WorkDto> convertToDtos(List<WorkEntity> entity) {
		if (entity == null || entity.size() == 0)
			return null;
		List<WorkDto> workDtos = entity.stream().map(item -> WorkDto.convertToDto(item)).toList();
		return workDtos;
	}

}
