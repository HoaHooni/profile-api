package com.example.demo.response;

import com.example.demo.model.dto.ProjectDto;
import com.example.demo.model.dto.ResumeDto;
import com.example.demo.model.dto.UserDto;
import lombok.*;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileResponse {
    private UserDto infor;
    private ResumeDto resume;
    private List<ProjectDto> projects;
}
