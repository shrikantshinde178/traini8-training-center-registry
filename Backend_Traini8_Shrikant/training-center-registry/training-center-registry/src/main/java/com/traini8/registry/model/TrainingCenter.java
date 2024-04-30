package com.traini8.registry.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "training_centers")
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class TrainingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String centerName;

    @Column(unique = true)
    private String centerCode;

    @Embedded
    private AddressModel address;

    @Column
    private int studentCapacity;
    
    @Column(name = "course_offered")
    private List<String> coursesOffered;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(unique = true)
    private String contactEmail;

    @Column(unique = true)
    private String contactPhone;

}
