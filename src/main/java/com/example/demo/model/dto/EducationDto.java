package com.example.demo.model.dto;

import com.example.demo.domain.EducationEnity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;

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

    private ResumeDto resume;

    public static EducationDto convertToDto(EducationEnity entity) {
        if (entity == null)
            return null;
        return EducationDto.builder().degree(entity.getDegree()).school(entity.getSchool())
                .graduated(entity.getGraduated()).description(entity.getDescription()).id(entity.getId())
                .createAt(entity.getCreateAt()).updateAt(entity.getUpateAt()).createBy(entity.getCreateBy())
                .updateBy(entity.getUpdateBy()).status(entity.getStatus()).build();
    }

    public static List<EducationDto> convertToDtos(List<EducationEnity> entity) {
        if (entity == null || entity.size() == 0)
            return null;
        return entity.stream().map(EducationDto::convertToDto).collect(Collectors.toList());
    }

    public static EducationEnity convertToEntity(EducationDto educationDto, Long resumeId) {
        if (educationDto == null)
            return null;
        return EducationEnity.builder().degree(educationDto.getDegree()).school(educationDto.getSchool())
                .resumeId(resumeId != null ? resumeId : educationDto.getResume().getId())
                .graduated(educationDto.getGraduated()).description(educationDto.getDescription())
                .id(educationDto.getId())
                .createBy(educationDto.getCreateBy()).updateBy(educationDto.getUpdateBy())
                .status(educationDto.getStatus()).build();
    }

    public static List<EducationEnity> convertToEntities(List<EducationDto> educationDtos, Long resumeId) {
        if (educationDtos == null || educationDtos.size() == 0)
            return null;
        return educationDtos.stream().map(item -> EducationDto.convertToEntity(item, resumeId)).collect(Collectors.toList());
    }

}
