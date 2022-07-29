package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.domain.SocialEntity;

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
public class SocialDto extends BaseDto<Long> {

	private String name;

	private String url;

	private String icon;

	public static SocialDto convertToDto(SocialEntity entity) {
		if (entity == null)
			return null;
		return SocialDto.builder().name(entity.getName()).url(entity.getUrl()).icon(entity.getIcon()).id(entity.getId())
				.createAt(entity.getCreateAt()).upateAt(entity.getUpateAt()).createBy(entity.getCreateBy())
				.updateBy(entity.getUpdateBy()).status(entity.getStatus()).build();
	}

	public static List<SocialDto> convertToDtos(List<SocialEntity> entity) {
		if (entity == null || entity.size() == 0)
			return null;
		return entity.stream().map(item -> SocialDto.convertToDto(item)).toList();
	}

	public static SocialEntity convertToEntity(SocialDto socialDto) {
		if (socialDto == null)
			return null;
		return SocialEntity.builder().name(socialDto.getName()).url(socialDto.getUrl()).icon(socialDto.getIcon())
				.id(socialDto.getId()).createAt(socialDto.getCreateAt()).upateAt(socialDto.getUpateAt())
				.createBy(socialDto.getCreateBy()).updateBy(socialDto.getUpdateBy()).status(socialDto.getStatus())
				.build();
	}

	public static List<SocialEntity> convertToEntities(List<SocialDto> socialDtos) {
		if (socialDtos == null || socialDtos.size() == 0)
			return null;
		return socialDtos.stream().map(item -> SocialDto.convertToEntity(item)).toList();
	}
}
