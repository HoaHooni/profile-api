package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.domain.SkillEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class SkillDto extends BaseDto<Long> {

	private String name;

	private int level;

	private String description;

	public static SkillDto convertToDto(SkillEntity entity) {
		if (entity == null)
			return null;
		return SkillDto.builder().name(entity.getName()).level(entity.getLevel()).description(entity.getDescription())
				.id(entity.getId()).createAt(entity.getCreateAt()).upateAt(entity.getUpateAt())
				.createBy(entity.getCreateBy()).updateBy(entity.getUpdateBy()).status(entity.getStatus()).build();
	}

	public static List<SkillDto> convertToDto(List<SkillEntity> entity) {
		if (entity == null || entity.size() == 0)
			return null;
		return entity.stream().map(item -> SkillDto.convertToDto(item)).toList();
	}

	public static SkillEntity convertToEntity(SkillDto skillDto) {
		if (skillDto == null)
			return null;
		return SkillEntity.builder().name(skillDto.getName()).level(skillDto.getLevel())
				.description(skillDto.getDescription()).id(skillDto.getId()).createAt(skillDto.getCreateAt())
				.upateAt(skillDto.getUpateAt()).createBy(skillDto.getCreateBy()).updateBy(skillDto.getUpdateBy())
				.status(skillDto.getStatus()).build();
	}

	public static List<SkillEntity> convertToEntities(List<SkillDto> skillDtos) {
		if (skillDtos == null || skillDtos.size() == 0)
			return null;
		return skillDtos.stream().map(item -> SkillDto.convertToEntity(item)).toList();
	}
}
