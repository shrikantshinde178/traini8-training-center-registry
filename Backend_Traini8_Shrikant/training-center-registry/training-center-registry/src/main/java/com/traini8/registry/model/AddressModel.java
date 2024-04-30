package com.traini8.registry.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {

    private String detailedAddress;

    private String city;

    private String state;

    private String pincode;
    
    
    
}
