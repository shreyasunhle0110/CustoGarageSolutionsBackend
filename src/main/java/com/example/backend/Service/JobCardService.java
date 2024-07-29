package com.example.backend.Service;

import java.util.List;

import com.example.backend.Entity.JobCardDbEntity;
import com.example.backend.RequestFromUIDTO.JobCardRequest;

public interface JobCardService {
    JobCardDbEntity createJobCard(JobCardRequest jobCard);
    JobCardDbEntity getJobCardById(Long id);
    List<JobCardDbEntity> getAllJobCards();
    JobCardDbEntity updateJobCard(Long id, JobCardDbEntity jobCard);
    void deleteJobCard(Long id);
}

