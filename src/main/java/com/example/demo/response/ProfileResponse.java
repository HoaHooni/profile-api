package com.example.demo.response;

import java.util.List;

import com.example.demo.model.dto.ProjectDto;
import com.example.demo.model.dto.ResumeDto;
import com.example.demo.model.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
