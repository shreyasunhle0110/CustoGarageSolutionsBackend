package com.example.backend.RequestFromUIDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobCardRequest {
    private String customerName;
    private String customerPhoneNo;
    private String customerAddress;
    private String carMake;
    private String carModel;
    private String carMileage;
    private String carVinNo;
    private String carRegistrationNo;
    private LocalDateTime expectedDeliveryDate;
    private List<WorkItem> workItems;
    private List<FileUpload> fileUploads;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WorkItem {
        private String workNeeded;
        private String workDescription;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FileUpload {
        private String type;
        private List<String> files;
    }
}
