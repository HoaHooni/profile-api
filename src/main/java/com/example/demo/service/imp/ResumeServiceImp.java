package com.example.demo.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.EducationDto;
import com.example.demo.model.dto.ResumeDto;
import com.example.demo.model.dto.SkillDto;
import com.example.demo.model.dto.WorkDto;
import com.example.demo.repository.EducationRepository;
import com.example.demo.repository.ResumeRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.WorkRepository;
import com.example.demo.service.IResumeService;
@Service
public class ResumeServiceImp implements IResumeService {

	@Autowired
	private ResumeRepository repository;

	@Autowired
	private WorkRepository workRepository;

	@Autowired
	private EducationRepository educationRepository;

	@Autowired
	private SkillRepository skillRepository;

	@Override
	public ResumeDto getById(Long id) {
		if (id == null)
			return null;
		return ResumeDto.convertToDto(repository.findById(id).orElse(null));
	}

	@Override
	public List<ResumeDto> getAll() {
		return ResumeDto.convertToDtos(repository.findAll());
	}

	@Override
	public ResumeDto add(ResumeDto dto) {
		if (dto == null)
			return null;

		ResumeDto resumeDto = ResumeDto.convertToDto(repository.save(ResumeDto.convertToEntity(dto)));
		if (dto.getAddWorks() != null && dto.getAddWorks().size() != 0) {
			List<WorkDto> workDtos = WorkDto.convertToDtos(
					workRepository.saveAll(WorkDto.convertToEnities(dto.getAddWorks(), resumeDto.getId())));
			resumeDto.setWorks(workDtos);
		}

		if (dto.getAddSkills() != null && dto.getAddSkills().size() != 0) {
			List<SkillDto> skillDtos = SkillDto.convertToDtos(
					skillRepository.saveAll(SkillDto.convertToEntities(dto.getAddSkills(), resumeDto.getId())));
			resumeDto.setSkills(skillDtos);
		}

		if (dto.getAddEducations() != null && dto.getAddEducations().size() != 0) {
			List<EducationDto> educationDtos = EducationDto.convertToDtos(educationRepository
					.saveAll(EducationDto.convertToEntities(dto.getAddEducations(), resumeDto.getId())));
			resumeDto.setEducations(educationDtos);
		}

		return resumeDto;
	}

	@Override
	public List<ResumeDto> addList(List<ResumeDto> dtos) {
		if (dtos == null || dtos.size() == 0)
			return null;
		return dtos.stream().map(item -> add(item)).collect(Collectors.toList());
	}

	@Override
	public ResumeDto update(ResumeDto dto) {
		if (dto == null)
			return null;

		ResumeDto resumeDto = ResumeDto.convertToDto(repository.save(ResumeDto.convertToEntity(dto)));
		// insert
		if (dto.getAddWorks() != null && dto.getAddWorks().size() != 0) {
			WorkDto.convertToDtos(
					workRepository.saveAll(WorkDto.convertToEnities(dto.getAddWorks(), resumeDto.getId())));
		}

		if (dto.getAddSkills() != null && dto.getAddSkills().size() != 0) {
			SkillDto.convertToDtos(
					skillRepository.saveAll(SkillDto.convertToEntities(dto.getAddSkills(), resumeDto.getId())));
		}

		if (dto.getAddEducations() != null && dto.getAddEducations().size() != 0) {
			EducationDto.convertToDtos(educationRepository
					.saveAll(EducationDto.convertToEntities(dto.getAddEducations(), resumeDto.getId())));
		}
		// update
		if (dto.getUpdateWorks() != null && dto.getUpdateWorks().size() != 0) {
			WorkDto.convertToDtos(
					workRepository.saveAll(WorkDto.convertToEnities(dto.getUpdateWorks(), resumeDto.getId())));
		}

		if (dto.getUpdateSkills() != null && dto.getUpdateSkills().size() != 0) {
			SkillDto.convertToDtos(
					skillRepository.saveAll(SkillDto.convertToEntities(dto.getUpdateSkills(), resumeDto.getId())));
		}

		if (dto.getUpdateEducations() != null && dto.getUpdateEducations().size() != 0) {
			EducationDto.convertToDtos(educationRepository
					.saveAll(EducationDto.convertToEntities(dto.getUpdateEducations(), resumeDto.getId())));
		}
		// delete
		if (dto.getDeleteWorks() != null && dto.getDeleteWorks().size() != 0) {
			workRepository.deleteAllByIdInBatch(dto.getDeleteWorks().stream().map(item -> item.getId()).collect(Collectors.toList()));
		}

		if (dto.getDeleteSkills() != null && dto.getDeleteSkills().size() != 0) {
			skillRepository.deleteAllByIdInBatch(dto.getDeleteSkills().stream().map(item -> item.getId()).collect(Collectors.toList()));
		}

		if (dto.getDeleteEducations() != null && dto.getDeleteEducations().size() != 0) {
			educationRepository
					.deleteAllByIdInBatch(dto.getDeleteEducations().stream().map(item -> item.getId()).collect(Collectors.toList()));
		}

		resumeDto.setWorks(WorkDto.convertToDtos(workRepository.findAllByResumeId(resumeDto.getId())));
		resumeDto.setEducations(EducationDto.convertToDtos(educationRepository.findAllByResumeId(resumeDto.getId())));
		resumeDto.setSkills(SkillDto.convertToDtos(skillRepository.findAllByResumeId(resumeDto.getId())));

		return resumeDto;
	}

	@Override
	public List<ResumeDto> updateList(List<ResumeDto> dtos) {
		if (dtos == null || dtos.size() == 0)
			return null;
		return dtos.stream().map(item -> update(item)).collect(Collectors.toList());
	}

	@Override
	public void delete(ResumeDto dto) {
		if (dto != null && dto.getId() != null) {

			repository.deleteById(dto.getId());
		}
	}

	@Override
	public void delete(Long id) {
		if (id != null) {
			repository.deleteById(id);
		}
	}

	@Override
	public void deleteList(List<ResumeDto> dtos) {
		if (dtos != null && dtos.size() != 0) {
			repository.deleteAllById(dtos.stream().map(item -> item.getId()).collect(Collectors.toList()));
		}
	}

	@Override
	public void deleteByIds(List<Long> ids) {
		if (ids != null && ids.size() != 0) {
			repository.deleteAllById(ids);
		}
	}

}
