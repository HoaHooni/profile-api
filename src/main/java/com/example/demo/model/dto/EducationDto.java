package com.example.demo.model.dto;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.common.EStatus;
import com.example.demo.domain.EducationEnity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EducationDto extends BaseDto<Long> {

	private String school;

	private String degree;

	private String graduated;

	private String description;

	private ResumeDto resume;

	public static EducationDto convertToDto(EducationEnity entity) {

		return EducationDto.builder().degree(entity.getDegree()).school(entity.getSchool())
				.graduated(entity.getGraduated()).description(entity.getDescription()).build();
	}

	public static List<EducationDto> convertToDtos(List<EducationEnity> entity) {

		List<EducationDto> educationDtos = entity.stream().map(item -> EducationDto.convertToDto(item)).toList();

		return educationDtos;
	}

}
