package com.example.backend.Service.ServiceImplementation;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend.Entity.JobCardDbEntity;
import com.example.backend.Entity.PhotosCarJobCard;
import com.example.backend.Repository.PhotosCarJobCardRepository;
import com.example.backend.Service.PhotosCarJobCardService;

@Service
public class PhotosCarJobCardServiceImplementation implements PhotosCarJobCardService {

     @Autowired
    private PhotosCarJobCardRepository photosCarJobCardRepository;

    public PhotosCarJobCard savePhoto(MultipartFile file, String photoType, Long jobCardId, String createdBy) throws IOException {
        PhotosCarJobCard photo = new PhotosCarJobCard();
        photo.setJobCard(new JobCardDbEntity(jobCardId)); // Assuming a constructor to set jobCardId
        photo.setPhotoType(PhotosCarJobCard.PhotoType.valueOf(photoType.toUpperCase()));
        photo.setFileName(file.getOriginalFilename());
        photo.setFileExtension(getFileExtension(file.getOriginalFilename()));
        photo.setFileSize(file.getSize());
        photo.setFileData(file.getBytes());
        photo.setCreatedBy(createdBy);
        photo.setCreatedOn(LocalDateTime.now());
        
        return photosCarJobCardRepository.save(photo);
    }

    private String getFileExtension(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return "";
    }


    
}
