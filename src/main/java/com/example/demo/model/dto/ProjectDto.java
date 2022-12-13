package com.example.demo.model.dto;

import com.example.demo.domain.ProjectEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProjectDto extends BaseDto<Long> {

    private String title;

    private String description;

    private String responsible;

    private String languages;

    private String other;

    private Timestamp fromDate;

    private Timestamp toDate;

    private Long userId;


    public static ProjectDto convertToDto(ProjectEntity entity) {
        if (entity == null)
            return null;
        return ProjectDto.builder().title(entity.getTitle()).description(entity.getDescription())
                .responsible(entity.getResponsible()).languages(entity.getLanguages()).other(entity.getOther())
                .fromDate(entity.getFromDate()).toDate(entity.getToDate()).id(entity.getId())
                .createAt(entity.getCreateAt()).upateAt(entity.getUpateAt()).createBy(entity.getCreateBy())
                .updateBy(entity.getUpdateBy()).status(entity.getStatus()).build();
    }

    public static List<ProjectDto> convertToDtos(List<ProjectEntity> entities) {
        if (entities == null || entities.size() == 0)
            return null;
        return entities.stream().map(ProjectDto::convertToDto).collect(Collectors.toList());
    }

    public static ProjectEntity convertToEntity(ProjectDto projectDto, Long userId) {
        if (projectDto == null)
            return null;
        return ProjectEntity.builder().title(projectDto.getTitle()).description(projectDto.getDescription())
                .responsible(projectDto.getResponsible()).languages(projectDto.getLanguages())
                .other(projectDto.getOther()).fromDate(projectDto.getFromDate()).toDate(projectDto.getToDate())
                .userId(userId != null ? userId : projectDto.getUserId())
                .id(projectDto.getId()).status(projectDto.getStatus())
                .build();
    }

    public static List<ProjectEntity> convertToEntities(List<ProjectDto> projectDtos, Long userId) {
        if (projectDtos == null || projectDtos.size() == 0)
            return null;
        return projectDtos.stream().map(item -> ProjectDto.convertToEntity(item, userId)).collect(Collectors.toList());
    }
}
