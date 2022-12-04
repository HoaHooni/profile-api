package com.example.demo.model.dto;

import com.example.demo.domain.SocialEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class SocialDto extends BaseDto<Long> {

    private String name;

    private String url;

    private String icon;

    private Long userId;

    public static SocialDto convertToDto(SocialEntity entity) {
        if (entity == null)
            return null;
        return SocialDto.builder().name(entity.getName()).url(entity.getUrl()).icon(entity.getIcon()).id(entity.getId())
                .createAt(entity.getCreateAt()).upateAt(entity.getUpateAt()).createBy(entity.getCreateBy())
                .updateBy(entity.getUpdateBy()).status(entity.getStatus()).userId(entity.getUserId()).build();
    }

    public static List<SocialDto> convertToDtos(List<SocialEntity> entity) {
        if (Objects.isNull(entity) || entity.size() == 0)
            return null;
        return entity.stream().map(SocialDto::convertToDto).collect(Collectors.toList());
    }

    public static SocialEntity convertToEntity(SocialDto socialDto, Long userId) {
        if (socialDto == null)
            return null;
        return SocialEntity.builder().name(socialDto.getName()).url(socialDto.getUrl()).icon(socialDto.getIcon())
                .id(socialDto.getId()).createAt(socialDto.getCreateAt()).upateAt(socialDto.getUpateAt())
                .createBy(socialDto.getCreateBy()).updateBy(socialDto.getUpdateBy()).status(socialDto.getStatus())
                .userId(userId != null ? userId : socialDto.getUserId()).build();
    }

    public static List<SocialEntity> convertToEntities(List<SocialDto> socialDtos, Long userId) {
        if (socialDtos == null || socialDtos.size() == 0)
            return null;
        return socialDtos.stream().map(item -> SocialDto.convertToEntity(item, userId)).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        SocialDto other = (SocialDto) obj;
        return Objects.equals(icon, other.icon) && Objects.equals(name, other.name) && Objects.equals(url, other.url);
    }

}
