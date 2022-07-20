package com.example.demo.model.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.domain.WorkEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class WorkDto extends BaseDto<Long> {

	private String company;

	private String title;

	private long yearStart;

	private Long yearEnd;

	private String description;

	private ResumeDto resume;

	public static WorkDto convertToDto(WorkEntity entity) {
		return WorkDto.builder().company(entity.getCompany()).title(entity.getTitle()).yearStart(entity.getYearStart())
				.yearEnd(entity.getYearEnd()).description(entity.getDescription()).build();
	}
	
	public static List<WorkDto> convertToDtos(List<WorkEntity> entity) {
		 List<WorkDto> workDtos = entity.stream().map(item -> WorkDto.convertToDto(item)).toList();
		return workDtos;
	}

}
