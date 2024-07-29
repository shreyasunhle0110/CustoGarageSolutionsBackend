package com.example.backend.Entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import com.example.backend.Enum.JobStatusEnum;
import com.example.backend.Utility.HashMapConverter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobCardDbEntity {

    public JobCardDbEntity(Long jobCardId) {
        //TODO Auto-generated constructor stub
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_card_id", nullable = false)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime carReceivedDate;
    private String carMake;
    private String carModel;
    private String customerName;
    private String customerAddress;
    private String customerPhoneNo;
    private String carRegistrationNo;
    private int carMileage;
    private String carVinNo;
    private String jobNumber; // Auto-generated
    private LocalDateTime requiredDateTime;
    @Enumerated(EnumType.STRING)
    private JobStatusEnum status;

    @OneToMany(mappedBy = "jobCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkItemEntity> workItems;

    @OneToMany(mappedBy = "jobCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotosCarJobCard> photosCarJobCards;


    
}
