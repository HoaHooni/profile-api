package com.example.demo.controller;

import com.example.demo.request.AddProfileRequest;
import com.example.demo.response.ProfileResponse;
import com.example.demo.service.IProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	@Autowired
	private IProfileService profileService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProfileResponse> getProfile(@PathVariable Long id) {
		return new ResponseEntity<ProfileResponse>(profileService.getProfile(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ProfileResponse> addProfile(@RequestBody AddProfileRequest request) {
		return new ResponseEntity<ProfileResponse>(profileService.addProfile(request), HttpStatus.OK);
	}

	@GetMapping(value = "/check")
	public ResponseEntity<String> check() {
		return new ResponseEntity<String>("living", HttpStatus.OK);
	}


}
