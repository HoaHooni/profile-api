package com.example.demo.controller;

import com.example.demo.model.dto.EducationDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/inventory-details")
public class ProfileController {

	@GetMapping
	public ResponseEntity getProfile(long id) {
		
		return null;
	}
}
