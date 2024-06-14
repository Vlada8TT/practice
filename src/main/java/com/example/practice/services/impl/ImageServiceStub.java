package com.example.practice.services.impl;

import com.example.practice.persistence.entities.Image;
import com.example.practice.services.ImageService;

import java.util.List;

public class ImageServiceStub implements ImageService {

    @Override
    public Image createImage(Image image) {
        return null;
    }

    @Override
    public Image getImageById(int id) {
        return null;
    }

    @Override
    public List<Image> getAllImages() {
        return null;
    }

    @Override
    public Image updateImage(int id, Image image) {
        return null;
    }

    @Override
    public void deleteImage(int id) {

    }
}
