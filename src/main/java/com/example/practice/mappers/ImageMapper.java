package com.example.practice.mappers;


import com.example.practice.dto.ImageDto;
import com.example.practice.persistence.entities.Image;

public interface ImageMapper {
    ImageDto toDto (Image image);
    Image toEntity(ImageDto dto);
}
