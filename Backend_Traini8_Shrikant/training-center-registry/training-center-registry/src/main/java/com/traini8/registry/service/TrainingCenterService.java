package com.traini8.registry.service;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.traini8.registry.model.TrainingCenter;
import com.traini8.registry.pojo.TrainingCenterRequest;
import com.traini8.registry.pojo.TrainingCenterResponse;

@Configuration
public interface TrainingCenterService {

	TrainingCenterResponse save(TrainingCenterRequest trainingCenter, List<String> coursesOffered);
	
	List<TrainingCenter> getAllTrainingCenters();
	
}
