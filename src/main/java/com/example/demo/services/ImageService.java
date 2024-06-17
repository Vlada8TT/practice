package com.example.demo.services;



import com.example.demo.dto.requests.ImageRequestDto;
import com.example.demo.dto.responses.ImageResponseDto;
import com.example.demo.persistence.entity.Image;

import java.util.List;

public interface ImageService {
    ImageResponseDto createImage(ImageRequestDto image);
    ImageResponseDto getImageById(int id);
    List<ImageResponseDto> getAllImages();
    ImageResponseDto updateImage(int id, ImageRequestDto image);
    void deleteImage(int id);
}