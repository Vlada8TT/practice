package com.example.demo.service;

import com.example.demo.dto.request.ImageRequestDto;
import com.example.demo.dto.response.ImageResponseDto;

import java.util.List;

public interface ImageService {
    ImageResponseDto createImage(ImageRequestDto image);

    ImageResponseDto getImageById(int id);

    List<ImageResponseDto> getAllImages();

    ImageResponseDto updateImage(int id, ImageRequestDto image);

    void deleteImage(int id);
}