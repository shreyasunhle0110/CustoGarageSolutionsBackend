package com.example.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.Entity.WorkItemEntity;

public interface WorkItemRepopsitory extends JpaRepository<WorkItemEntity, Long> {

    
}