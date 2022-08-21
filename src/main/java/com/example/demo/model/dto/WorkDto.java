package com.example.demo.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.domain.WorkEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
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
				.yearEnd(entity.getYearEnd()).description(entity.getDescription()).id(entity.getId())
				.createAt(entity.getCreateAt()).upateAt(entity.getUpateAt()).createBy(entity.getCreateBy())
				.updateBy(entity.getUpdateBy()).status(entity.getStatus()).build();
	}

	public static List<WorkDto> convertToDtos(List<WorkEntity> entity) {
		if (entity == null || entity.size() == 0)
			return null;
		return entity.stream().map(item -> WorkDto.convertToDto(item)).collect(Collectors.toList());
	}

	public static WorkEntity convertToEntity(WorkDto workDto, Long resumeId) {
		if (workDto == null)
			return null;
		return WorkEntity.builder().company(workDto.getCompany()).title(workDto.getTitle())
				.yearStart(workDto.getYearStart()).yearEnd(workDto.getYearEnd()).description(workDto.getDescription())
				.resumeId(resumeId != null ? resumeId : workDto.getResume().getId()).id(workDto.getId())
				.createAt(workDto.getCreateAt()).upateAt(workDto.getUpateAt()).createBy(workDto.getCreateBy())
				.updateBy(workDto.getUpdateBy()).status(workDto.getStatus()).build();
	}

	public static List<WorkEntity> convertToEnities(List<WorkDto> workDtos, Long resumeId) {
		if (workDtos == null || workDtos.size() == 0)
			return null;
		return workDtos.stream().map(item -> WorkDto.convertToEntity(item, resumeId)).collect(Collectors.toList());
	}
}
