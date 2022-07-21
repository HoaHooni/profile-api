package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.domain.EducationEnity;

import lombok.AllArgsConstructor;
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

	public static EducationDto convertToDto(EducationEnity entity) {
		if(entity == null) return null;
		return EducationDto.builder().degree(entity.getDegree()).school(entity.getSchool())
				.graduated(entity.getGraduated()).description(entity.getDescription()).build();
	}

	public static List<EducationDto> convertToDtos(List<EducationEnity> entity) {
		if(entity == null || entity.size() == 0) return null;
		List<EducationDto> educationDtos = entity.stream().map(item -> EducationDto.convertToDto(item)).toList();

		return educationDtos;
	}

}
