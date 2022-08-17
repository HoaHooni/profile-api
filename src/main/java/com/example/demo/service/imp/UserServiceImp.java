package com.example.demo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.common.EStatus;
import com.example.demo.domain.SocialEntity;
import com.example.demo.domain.UserEntity;
import com.example.demo.model.dto.SocialDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.repository.SocialRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;

public class UserServiceImp implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SocialRepository socialRepository;

	@Override
	public UserDto getById(Long id) {
		if (id == null)
			return null;
		return UserDto.convertToDto(userRepository.findById(id).orElseThrow());
	}

	@Override
	public List<UserDto> getAll() {
		return UserDto.convertToDtos(userRepository.findAll());
	}

	@Override
	public UserDto add(UserDto dto) {
		if (dto == null)
			return null;

		UserEntity userEntity = userRepository.save(UserDto.convertToEntity(dto));
		if (userEntity != null) {
			List<SocialDto> socialDtos = dto.getCreateSocials();
			List<SocialEntity> socialEntities = socialRepository
					.saveAll(SocialDto.convertToEntities(socialDtos, userEntity.getId()));
			if (socialEntities != null && socialEntities.size() != 0) {
				userEntity.setSocials(socialEntities);
				return UserDto.convertToDto(userEntity);
			}
		}
		return null;
	}

	@Override
	public List<UserDto> addList(List<UserDto> dtos) {
		if (dtos == null || dtos.size() == 0)
			return null;
		return dtos.stream().map(item -> add(item)).toList();
	}

	@Override
	public UserDto update(UserDto dto) {

		if (dto == null || !socialRepository.existsByUserId(dto.getId())) {
			return null;
		}
		List<SocialDto> createSocialDtos = dto.getCreateSocials();
		
		socialRepository.saveAll(SocialDto.convertToEntities(createSocialDtos, dto.getId()));
		
		List<SocialDto> updateSocialDtos = dto.getUpdateSocials();
		updateSocialDtos.forEach(item -> {
			if(socialRepository.existsById(item.getId())) {
				socialRepository.save(SocialDto.convertToEntity(item, dto.getId()));
			}
		});
		
		List<SocialDto> deleteSocialDtos = dto.getDeleteSocials();
		deleteSocialDtos.forEach(item -> {
			if(socialRepository.existsById(item.getId())) {
				socialRepository.deleteById(item.getId());
			}
		});
		
		return UserDto.convertToDto(userRepository.getById(dto.getId()));
	}

	@Override
	public List<UserDto> updateList(List<UserDto> dtos) {
		if(dtos == null || dtos.size() != 0)
		return null;
		return dtos.stream().map(item -> update(item)).toList();
	}

	@Override
	public void delete(UserDto dto) {
		if (dto != null) {
			List<SocialEntity> socialEntities = socialRepository.findByUserId(dto.getId());
			socialRepository.deleteAllById(socialEntities.stream().map(item -> item.getId()).toList());
			userRepository.delete(UserDto.convertToEntity(dto));
		}
	}

	@Override
	public void deleteList(List<UserDto> dtos) {
		if (dtos != null && dtos.size() != 0) {
			dtos.stream().filter(item -> userRepository.existsById(item.getId())).toList();
			userRepository.deleteAll(UserDto.convertToEntities(dtos));
		}
	}

	@Override
	public void delete(Long id) {
		if (id != null || userRepository.existsById(id)) {
			userRepository.deleteById(id);
		}
	}

	@Override
	public void deleteByIds(List<Long> ids) {
		if (ids != null && ids.size() != 0) {
			ids.stream().filter(item -> userRepository.existsById(item)).toList();
			userRepository.deleteAllById(ids);
		}
	}

}
