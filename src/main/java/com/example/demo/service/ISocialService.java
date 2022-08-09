package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.SocialDto;

public interface ISocialService extends IBaseService<SocialDto> {

	List<SocialDto> addList(List<SocialDto> dtos, Long userId);

}
