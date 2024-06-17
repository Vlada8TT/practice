package com.example.demo.mappers;


import com.example.demo.dto.requests.AddressRequestDto;
import com.example.demo.dto.responses.AddressResponseDto;
import com.example.demo.dto.responses.ImageResponseDto;
import com.example.demo.persistence.entity.Image;
import com.example.demo.dto.requests.ImageRequestDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageResponseDto toDto (Image image);
    List<ImageResponseDto> toDto (List<Image> image);
    Image toEntity(ImageRequestDto dto);
}
