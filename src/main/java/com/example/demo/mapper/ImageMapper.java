package com.example.demo.mapper;


import com.example.demo.dto.response.ImageResponseDto;
import com.example.demo.persistence.entity.Image;
import com.example.demo.dto.request.ImageRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {
    ImageResponseDto toDto(Image image);

    List<ImageResponseDto> toDto(List<Image> image);

    Image toEntity(ImageRequestDto dto);
}