package com.example.demo.request;

import com.example.demo.model.dto.ProjectDto;
import com.example.demo.model.dto.ResumeDto;
import com.example.demo.model.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddProfileRequest {
    private UserDto infor;
    private ResumeDto resume;
    private List<ProjectDto> projects;
}
