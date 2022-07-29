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

	public static ResumeDto convertToDto(ResumeEntity entity) {
		if (entity == null)
			return null;
		return ResumeDto.builder().educations(EducationDto.convertToDtos(entity.getEducations().stream().toList()))
				.works(WorkDto.convertToDtos(entity.getWorks().stream().toList()))
				.skills(SkillDto.convertToDto(entity.getSkills().stream().toList())).id(entity.getId())
				.createAt(entity.getCreateAt()).upateAt(entity.getUpateAt()).createBy(entity.getCreateBy())
				.updateBy(entity.getUpdateBy()).status(entity.getStatus()).build();
	}

	public static List<ResumeDto> convertToDtos(List<ResumeEntity> entity) {
		if (entity == null || entity.size() == 0)
			return null;
		return entity.stream().map(item -> ResumeDto.convertToDto(item)).toList();
	}

	public static ResumeEntity convertToEntity(ResumeDto resumeDto) {
		if (resumeDto == null)
			return null;
		return ResumeEntity.builder()
				.educations(EducationDto.convertToEntities(resumeDto.getEducations().stream().toList()))
				.works(WorkDto.convertToEnities(resumeDto.getWorks().stream().toList()))
				.skills(SkillDto.convertToEntities(resumeDto.getSkills().stream().toList())).id(resumeDto.getId())
				.createAt(resumeDto.getCreateAt()).upateAt(resumeDto.getUpateAt()).createBy(resumeDto.getCreateBy())
				.updateBy(resumeDto.getUpdateBy()).status(resumeDto.getStatus()).build();
	}

	public static List<ResumeEntity> convertToEntities(List<ResumeDto> resumeDtos) {
		if (resumeDtos == null || resumeDtos.size() == 0)
			return null;
		return resumeDtos.stream().map(item -> ResumeDto.convertToEntity(item)).toList();
	}

}
