package com.example.demo.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ProjectDto;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.IProjectService;
@Service
public class ProjectServiceImp implements IProjectService {

	@Autowired
	private ProjectRepository repository;

	@Override
	public ProjectDto getById(Long id) {
		if (id == null)
			return null;
		return ProjectDto.convertToDto(repository.getById(id));
	}

	@Override
	public List<ProjectDto> getAll() {

		return ProjectDto.convertToDtos(repository.findAll());
	}

	@Override
	public ProjectDto add(ProjectDto dto) {
		if (dto == null)
			return null;
		return ProjectDto.convertToDto(repository.save(ProjectDto.convertToEntity(dto, null)));
	}

	@Override
	public List<ProjectDto> addList(List<ProjectDto> dtos) {
		if (dtos == null || dtos.size() == 0)
			return null;
		return ProjectDto.convertToDtos(repository.saveAll(ProjectDto.convertToEntities(dtos, null)));
	}

	@Override
	public ProjectDto update(ProjectDto dto) {
		if (dto == null || !repository.existsById(dto.getId()))
			return null;
		return ProjectDto.convertToDto(repository.save(ProjectDto.convertToEntity(dto, null)));
	}

	@Override
	public List<ProjectDto> updateList(List<ProjectDto> dtos) {
		if (dtos == null || dtos.size() == 0)
			return null;
		return dtos.stream().map(item -> update(item)).collect(Collectors.toList());
	}

	@Override
	public void delete(ProjectDto dto) {
		if (dto != null && repository.existsById(dto.getId())) {
			repository.deleteById(dto.getId());
		}

	}

	@Override
	public void delete(Long id) {
		if (id != null && repository.existsById(id)) {
			repository.deleteById(id);
		}
	}

	@Override
	public void deleteList(List<ProjectDto> dtos) {
		if (dtos != null && dtos.size() != 0) {
			repository.deleteAllByIdInBatch(dtos.stream().map(item -> item.getId()).collect(Collectors.toList()));
		}
	}

	@Override
	public void deleteByIds(List<Long> ids) {
		if (ids != null && ids.size() != 0) {
			repository.deleteAllByIdInBatch(ids);
		}

	}

	@Override
	public List<ProjectDto> findByUserId(Long userId) {
		if (userId == null)
			return null;
		return ProjectDto.convertToDtos(repository.findAllByUserId(userId));
	}

}
