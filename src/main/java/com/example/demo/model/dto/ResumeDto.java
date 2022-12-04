package com.example.demo.model.dto;

import com.example.demo.domain.ResumeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ResumeDto extends BaseDto<Long> {

    private String skillMessage;

    private Long userId;

    private List<EducationDto> educations;

    private List<WorkDto> works;

    private List<SkillDto> skills;

    private List<EducationDto> addEducations;

    private List<WorkDto> addWorks;

    private List<SkillDto> addSkills;

    private List<EducationDto> updateEducations;

    private List<WorkDto> updateWorks;

    private List<SkillDto> updateSkills;

    private List<EducationDto> deleteEducations;

    private List<WorkDto> deleteWorks;

    private List<SkillDto> deleteSkills;

    public static ResumeDto convertToDto(ResumeEntity entity) {
        if (entity == null)
            return null;
        return ResumeDto.builder().educations(EducationDto.convertToDtos(entity.getEducations()))
                .works(WorkDto.convertToDtos(entity.getWorks()))
                .skills(SkillDto.convertToDtos(entity.getSkills()))
                .skillMessage(entity.getSkillMessage()).id(entity.getId()).createAt(entity.getCreateAt())
                .upateAt(entity.getUpateAt()).createBy(entity.getCreateBy()).updateBy(entity.getUpdateBy())
                .status(entity.getStatus()).build();
    }

    public static List<ResumeDto> convertToDtos(List<ResumeEntity> entity) {
        if (entity == null || entity.size() == 0)
            return null;
        return entity.stream().map(ResumeDto::convertToDto).collect(Collectors.toList());
    }

    public static ResumeEntity convertToEntity(ResumeDto resumeDto) {
        if (resumeDto == null)
            return null;
        return ResumeEntity.builder()
                .skillMessage(resumeDto.getSkillMessage()).id(resumeDto.getId()).createAt(resumeDto.getCreateAt())
                .upateAt(resumeDto.getUpateAt()).createBy(resumeDto.getCreateBy()).updateBy(resumeDto.getUpdateBy())
                .status(resumeDto.getStatus()).build();
    }

    public static List<ResumeEntity> convertToEntities(List<ResumeDto> resumeDtos) {
        if (resumeDtos == null || resumeDtos.size() == 0)
            return null;
        return resumeDtos.stream().map(ResumeDto::convertToEntity).collect(Collectors.toList());
    }

}
