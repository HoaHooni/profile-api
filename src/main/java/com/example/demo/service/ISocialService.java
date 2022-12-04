package com.example.demo.service;

import com.example.demo.model.dto.SocialDto;

import java.util.List;

public interface ISocialService extends IBaseService<SocialDto> {

    List<SocialDto> addList(List<SocialDto> dtos, Long userId);

}
