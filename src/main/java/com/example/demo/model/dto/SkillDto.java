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
				.build();
	}

	public static List<SkillDto> convertToDto(List<SkillEntity> entity) {
		if (entity == null || entity.size() == 0)
			return null;
		List<SkillDto> skillDtos = entity.stream().map(item -> SkillDto.convertToDto(item)).toList();
		return skillDtos;
	}
}
