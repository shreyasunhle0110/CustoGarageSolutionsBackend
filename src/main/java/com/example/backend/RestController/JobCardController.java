package com.example.backend.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.Entity.JobCardDbEntity;
import com.example.backend.RequestFromUIDTO.JobCardRequest;
import com.example.backend.Service.JobCardService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/job-cards")
public class JobCardController {

    private final JobCardService jobCardService;

    @Autowired
    public JobCardController(JobCardService jobCardService) {
        this.jobCardService = jobCardService;
    }

    @PostMapping
    public JobCardDbEntity createJobCard(@RequestBody JobCardRequest jobCard) {
        return jobCardService.createJobCard(jobCard);
    }

    @GetMapping
    public List<JobCardDbEntity> getAllJobCards() {
        return jobCardService.getAllJobCards();
    }

    @GetMapping("/{id}")
    public JobCardDbEntity getJobCardById(@PathVariable Long id) {
        return jobCardService.getJobCardById(id);
    }

    // Add other CRUD operations as needed
}
