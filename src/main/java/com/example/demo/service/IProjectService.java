package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.ProjectDto;

public interface IProjectService extends IBaseService<ProjectDto>{
	List<ProjectDto> findByUserId(Long userId);
}
