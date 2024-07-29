package com.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.Entity.JobCardDbEntity;

public interface JobCardRepository extends JpaRepository<JobCardDbEntity, Long> {
    // Add custom queries if needed
}
