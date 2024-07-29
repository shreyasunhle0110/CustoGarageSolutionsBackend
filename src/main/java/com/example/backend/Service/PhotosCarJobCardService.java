package com.example.backend.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.backend.Entity.PhotosCarJobCard;

public interface PhotosCarJobCardService {

    public PhotosCarJobCard savePhoto(MultipartFile file, String photoType, Long jobCardId, String createdBy) throws IOException;
    
}