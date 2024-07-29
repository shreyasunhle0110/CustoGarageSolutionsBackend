package com.example.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "photos_car_job_card")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhotosCarJobCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_card_id", nullable = false)
    private JobCardDbEntity jobCard;

    @Enumerated(EnumType.STRING)
    @Column(name = "photo_type", nullable = false)
    private PhotoType photoType;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_extension", nullable = false)
    private String fileExtension;

    @Column(name = "file_size", nullable = false)
    private long fileSize;

    @Column(name = "file_data", nullable = false, columnDefinition = "BYTEA")
    private byte[] fileData;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    public enum PhotoType {
        SCRATCHES,
        DENTS,
        MISSING_PARTS,
        OTHER
    }
}

