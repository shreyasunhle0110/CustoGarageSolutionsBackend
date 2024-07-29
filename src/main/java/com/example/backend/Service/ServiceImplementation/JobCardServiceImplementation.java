package com.example.backend.Service.ServiceImplementation;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.Entity.JobCardDbEntity;
import com.example.backend.Enum.JobStatusEnum;
import com.example.backend.Repository.JobCardRepository;
import com.example.backend.RequestFromUIDTO.JobCardRequest;
import com.example.backend.Service.JobCardService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JobCardServiceImplementation implements JobCardService {

    @Autowired
    private JobCardRepository jobCardRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public JobCardDbEntity createJobCard(JobCardRequest jobCard) {
        JobCardDbEntity data = new JobCardDbEntity();
        data = mapper.convertValue(jobCard, JobCardDbEntity.class);
        data.setStatus(JobStatusEnum.JobCreated);
        return jobCardRepository.save(data);
    }

    @Override
    public JobCardDbEntity getJobCardById(Long id) {
        Optional<JobCardDbEntity> jobCard = jobCardRepository.findById(id);
        return jobCard.orElse(null);
    }

    @Override
    public List<JobCardDbEntity> getAllJobCards() {
        return jobCardRepository.findAll();
    }

    @Override
    public JobCardDbEntity updateJobCard(Long id, JobCardDbEntity jobCard) {
        Optional<JobCardDbEntity> existingJobCard = jobCardRepository.findById(id);
        if (existingJobCard.isPresent()) {
            jobCard.setId(id);
            return jobCardRepository.save(jobCard);
        } else {
            return null;
        }
    }

    @Override
    public void deleteJobCard(Long id) {
        jobCardRepository.deleteById(id);
    }
}
