package com.example.demo.model.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.domain.SkillEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SkillDto extends BaseDto<Long>{

	private String name;
	
	private int level;
	
	private String description;
	
	private ResumeDto resume;
	
	public static SkillDto convertToDto(SkillEntity entity) {
		return SkillDto.builder().name(entity.getName()).level(entity.getLevel()).description(entity.getDescription()).build();
	}
	
	public static List<SkillDto> convertToDto(List<SkillEntity> entity) {
		List<SkillDto> skillDtos = entity.stream().map(item -> SkillDto.convertToDto(item)).toList();
		return skillDtos;
	}
}
