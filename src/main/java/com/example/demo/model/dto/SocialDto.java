package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.domain.SocialEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class SocialDto extends BaseDto<Long> {

	private String name;

	private String url;

	private String icon;

	public static SocialDto convertToDto(SocialEntity entity) {
		if (entity == null)
			return null;
		return SocialDto.builder().name(entity.getName()).url(entity.getUrl()).icon(entity.getIcon()).build();
	}

	public static List<SocialDto> convertToDtos(List<SocialEntity> entity) {
		if (entity == null || entity.size() == 0)
			return null;
		return entity.stream().map(item -> SocialDto.convertToDto(item)).toList();
	}
}
