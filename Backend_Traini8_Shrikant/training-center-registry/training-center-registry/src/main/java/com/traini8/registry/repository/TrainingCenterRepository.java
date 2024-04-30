package com.traini8.registry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traini8.registry.model.TrainingCenter;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {
	
	@SuppressWarnings("unchecked")
	TrainingCenter save(TrainingCenter trainingCenter);
	
	// Fetch Training Centers
    List<TrainingCenter> findAll();

    //Custom Method to check predefined attributes
	boolean existsByCenterNameIgnoreCaseOrCenterCodeIgnoreCaseOrContactEmailIgnoreCaseOrContactPhone(String centerName,
			String centerCode, String contactEmail, String contactPhone);


}
