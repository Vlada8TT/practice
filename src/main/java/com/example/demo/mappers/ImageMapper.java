package com.example.demo.mappers;


import com.example.demo.persistence.entity.Image;
import com.example.demo.dto.ImageDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {
    ImageDto toDto (Image image);
    Image toEntity(ImageDto dto);
}
