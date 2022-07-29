package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.domain.EducationEnity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EducationDto extends BaseDto<Long> {

	private String school;

	private String degree;

	private String graduated;

	private String description;

	public static EducationDto convertToDto(EducationEnity entity) {
		if (entity == null)
			return null;
		return EducationDto.builder().degree(entity.getDegree()).school(entity.getSchool())
				.graduated(entity.getGraduated()).description(entity.getDescription()).id(entity.getId())
				.createAt(entity.getCreateAt()).upateAt(entity.getUpateAt()).createBy(entity.getCreateBy())
				.updateBy(entity.getUpdateBy()).status(entity.getStatus()).build();
	}

	public static List<EducationDto> convertToDtos(List<EducationEnity> entity) {
		if (entity == null || entity.size() == 0)
			return null;
		return entity.stream().map(item -> EducationDto.convertToDto(item)).toList();
	}

	public static EducationEnity convertToEntity(EducationDto educationDto) {
		if (educationDto == null)
			return null;
		return EducationEnity.builder().degree(educationDto.getDegree()).school(educationDto.getSchool())
				.graduated(educationDto.getGraduated()).description(educationDto.getDescription())
				.id(educationDto.getId()).createAt(educationDto.getCreateAt()).upateAt(educationDto.getUpateAt())
				.createBy(educationDto.getCreateBy()).updateBy(educationDto.getUpdateBy())
				.status(educationDto.getStatus()).build();
	}

	public static List<EducationEnity> convertToEntities(List<EducationDto> educationDtos) {
		if (educationDtos == null || educationDtos.size() == 0)
			return null;
		return educationDtos.stream().map(item -> EducationDto.convertToEntity(item)).toList();
	}

}
