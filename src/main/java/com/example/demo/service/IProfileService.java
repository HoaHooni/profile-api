package com.example.demo.service;

import com.example.demo.request.AddProfileRequest;
import com.example.demo.response.ProfileResponse;

public interface IProfileService {
    public ProfileResponse getProfile(Long id);

    public ProfileResponse addProfile(AddProfileRequest request);
}
