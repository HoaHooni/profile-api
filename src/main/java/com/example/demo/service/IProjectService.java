package com.example.demo.service;

import com.example.demo.model.dto.ProjectDto;

import java.util.List;

public interface IProjectService extends IBaseService<ProjectDto> {
    List<ProjectDto> findByUserId(Long userId);
}
