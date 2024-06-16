package com.example.demo.services;



import com.example.demo.persistence.entity.Image;

import java.util.List;

public interface ImageService {
    Image createImage(Image image);
    Image getImageById(int id);
    List<Image> getAllImages();
    Image updateImage(int id, Image image);
    void deleteImage(int id);
}