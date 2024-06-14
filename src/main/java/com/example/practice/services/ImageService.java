package com.example.practice.services;

import com.example.practice.models.Image;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ImageService {
    Image createImage(Image image);
    Image getImageById(int id);
    List<Image> getAllImages();
    Image updateImage(int id, Image image);
    void deleteImage(int id);
}