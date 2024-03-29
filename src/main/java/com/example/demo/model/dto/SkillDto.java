package com.example.demo.model.dto;

import com.example.demo.domain.SkillEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class SkillDto extends BaseDto<Long> {

    private String name;

    private int level;

    private String description;

    private ResumeDto resume;

    public static SkillDto convertToDto(SkillEntity entity) {
        if (entity == null)
            return null;
        return SkillDto.builder().name(entity.getName()).level(entity.getLevel()).description(entity.getDescription())
                .id(entity.getId()).createAt(entity.getCreateAt()).updateAt(entity.getUpateAt())
                .createBy(entity.getCreateBy()).updateBy(entity.getUpdateBy()).status(entity.getStatus()).build();
    }

    public static List<SkillDto> convertToDtos(List<SkillEntity> entity) {
        if (entity == null || entity.size() == 0)
            return null;
        return entity.stream().map(SkillDto::convertToDto).collect(Collectors.toList());
    }

    public static SkillEntity convertToEntity(SkillDto skillDto, Long resumeId) {
        if (skillDto == null)
            return null;
        return SkillEntity.builder().name(skillDto.getName()).level(skillDto.getLevel())
                .resumeId(resumeId != null ? resumeId : skillDto.getResume().getId())
                .description(skillDto.getDescription()).id(skillDto.getId())
                .createBy(skillDto.getCreateBy()).updateBy(skillDto.getUpdateBy())
                .status(skillDto.getStatus()).build();
    }

    public static List<SkillEntity> convertToEntities(List<SkillDto> skillDtos, Long resumeId) {
        if (skillDtos == null || skillDtos.size() == 0)
            return null;
        return skillDtos.stream().map(item -> SkillDto.convertToEntity(item, resumeId)).collect(Collectors.toList());
    }
}
