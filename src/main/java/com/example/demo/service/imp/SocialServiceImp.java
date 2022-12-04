package com.example.demo.service.imp;

import com.example.demo.model.dto.SocialDto;
import com.example.demo.repository.SocialRepository;
import com.example.demo.service.ISocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialServiceImp implements ISocialService {

    @Autowired
    private SocialRepository socialRepository;

    @Override
    public SocialDto getById(Long id) {
        if (id == null)
            return null;

        return SocialDto.convertToDto(socialRepository.findById(id).get());
    }

    @Override
    public List<SocialDto> getAll() {
        return SocialDto.convertToDtos(socialRepository.findAll());
    }

    @Override
    public SocialDto add(SocialDto dto) {
        if (dto == null || socialRepository.existsById(dto.getId()))
            return null;

        return SocialDto.convertToDto(socialRepository.save(SocialDto.convertToEntity(dto, dto.getUserId())));
    }

    @Override
    public List<SocialDto> addList(List<SocialDto> dtos) {
        if (dtos == null || dtos.size() == 0)
            return null;
        dtos.stream().filter(item -> !socialRepository.existsById(item.getId()));
        return SocialDto.convertToDtos(socialRepository.saveAll(SocialDto.convertToEntities(dtos, null)));
    }

    @Override
    public List<SocialDto> addList(List<SocialDto> dtos, Long userId) {
        if (dtos == null || dtos.size() == 0)
            return null;

        return SocialDto.convertToDtos(socialRepository.saveAll(SocialDto.convertToEntities(dtos, userId)));
    }

    @Override
    public SocialDto update(SocialDto dto) {
        if (dto == null)
            return null;
        if (!socialRepository.existsById(dto.getId()))
            return null;
        return SocialDto.convertToDto(socialRepository.save(SocialDto.convertToEntity(dto, dto.getUserId())));
    }

    @Override
    public List<SocialDto> updateList(List<SocialDto> dtos) {
        if (dtos == null || dtos.size() == 0)
            return null;
        List<SocialDto> result = SocialDto
                .convertToDtos(socialRepository.saveAll(SocialDto.convertToEntities(dtos, null)));
        return result;
    }

    @Override
    public void delete(SocialDto dto) {
        if (dto != null || socialRepository.existsById(dto.getId())) {
            socialRepository.deleteById(dto.getId());
        }

    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            socialRepository.deleteById(id);
        }
    }

    @Override
    public void deleteList(List<SocialDto> dtos) {
        if (dtos != null && dtos.size() != 0) {
            dtos.stream().filter(item -> socialRepository.existsById(item.getId()));
            socialRepository.deleteAll(SocialDto.convertToEntities(dtos, null));
        }

    }

    @Override
    public void deleteByIds(List<Long> ids) {
        if (ids != null && ids.size() != 0) {
            ids.stream().filter(item -> socialRepository.existsById(item));
            socialRepository.deleteAllById(ids);
        }

    }

}
