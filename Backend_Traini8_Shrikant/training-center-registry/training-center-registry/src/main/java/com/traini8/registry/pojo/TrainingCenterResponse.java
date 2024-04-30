package com.traini8.registry.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCenterResponse {

    private Long id;
    
    private String centerName;
    
    private String centerCode;
    
    private AddressRequest address;

    private int studentCapacity;
    
    private List<String> coursesOffered;
    
    private LocalDateTime createdOn;
    
    private String contactEmail;
    
    private String contactPhone;

    private String message;    
        
    public void setMessage(String message) {
        this.message = message;
    }
    
}
