package com.example.demo.service.impl;

import com.example.demo.dto.request.ImageRequestDto;
import com.example.demo.dto.response.ImageResponseDto;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.mapper.ImageMapper;
import com.example.demo.persistence.entity.Image;
import com.example.demo.repositories.ImageRepository;
import com.example.demo.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;

    @Override
    @Transactional
    public ImageResponseDto createImage(ImageRequestDto imageRequestDto) {

        Image image = imageMapper.toEntity(imageRequestDto);
        if(imageRepository.findByPath(imageRequestDto.path()).isPresent()){
            throw new IllegalStateException("image");
        }
        imageRepository.save(image);
        return imageMapper.toDto(image);
    }

    @Override
    @Transactional(readOnly = true)
    public ImageResponseDto getImageById(int id) {

        return imageMapper.toDto(imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("image", id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ImageResponseDto> getAllImages() {

        return imageMapper.toDto(imageRepository.findAll());
    }

    @Override
    @Transactional
    public ImageResponseDto updateImage(int id, ImageRequestDto imageRequestDto) {

        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("image", id));
        if(imageRepository.findByPath(imageRequestDto.path()).isPresent()){
            throw new IllegalStateException("image");
        }
        updateImageFields(image, imageRequestDto);
        imageRepository.save(image);
        return imageMapper.toDto(image);
    }

    @Override
    @Transactional
    public void deleteImage(int id) {

        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("image", id));
        imageRepository.delete(image);
    }

    private void updateImageFields(Image image, ImageRequestDto imageRequestDto){

        image.setPath(imageRequestDto.path());
    }
}