package com.example.demo.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.request.AddProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.response.ProfileResponse;
import com.example.demo.model.dto.ProjectDto;
import com.example.demo.model.dto.ResumeDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.service.IProfileService;
import com.example.demo.service.IProjectService;
import com.example.demo.service.IResumeService;
import com.example.demo.service.IUserService;

@Service
public class ProfileServiceImp implements IProfileService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IResumeService resumeService;

    @Autowired
    private IProjectService projectService;

    @Override
    public ProfileResponse getProfile(Long id) {
        if (id == null)
            return null;
        UserDto userDto = userService.getById(id);

        ResumeDto resumeDto = resumeService.getById(id);

        List<ProjectDto> projectDtos = projectService.findByUserId(id);

        return ProfileResponse.builder().infor(userDto).resume(resumeDto).projects(projectDtos).build();
    }

    @Override
    public ProfileResponse addProfile(AddProfileRequest request) {
        if (request == null)
            return null;
        UserDto userDto = userService.add(request.getInfor());

        request.getResume().setUserId(userDto.getId());
        ResumeDto resumeDto = resumeService.add(request.getResume());

        request.getProjects().stream().forEach(item -> item.setUserId(userDto.getId()));
        List<ProjectDto> projectDtos = projectService.addList(request.getProjects());

        return ProfileResponse.builder().infor(userDto).resume(resumeDto).projects(projectDtos).build();
    }

}
