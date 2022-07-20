package com.example.demo.model.dto;

import java.util.List;
import java.util.Set;

import com.example.demo.domain.EducationEnity;
import com.example.demo.domain.ResumeEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResumeDto extends BaseDto<Long> {

	private List<EducationDto> educations;

	private List<WorkDto> works;

	private List<SkillDto> skills;

	private UserDto user;

	public static ResumeDto convertToDto(ResumeEntity entity) {

		return ResumeDto.builder().educations(EducationDto.convertToDtos(entity.getEducations().stream().toList()))
				.works(WorkDto.convertToDtos(entity.getWorks().stream().toList()))
				.skills(SkillDto.convertToDto(entity.getSkills().stream().toList()))
				.build();
	}

	public static List<ResumeDto> convertToDtos(List<ResumeEntity> entity) {

		List<ResumeDto> resumeDtos = entity.stream().map(item -> ResumeDto.convertToDto(item)).toList();
		return resumeDtos;
	}

}
