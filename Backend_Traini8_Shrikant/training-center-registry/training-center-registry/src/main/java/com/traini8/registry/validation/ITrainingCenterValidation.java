package com.traini8.registry.validation;

import com.traini8.registry.model.TrainingCenter;
import com.traini8.registry.pojo.TrainingCenterRequest;

public interface ITrainingCenterValidation {
	
	public boolean isTrainingCenterRequestValid(TrainingCenterRequest trainingCenterRequest);
	
	public void validateTrainingCenter(TrainingCenter trainingCenter);

	boolean existsByCenterNameIgnoreCaseOrCenterCodeIgnoreCaseOrContactEmailIgnoreCaseOrContactPhone(String centerName,
			String centerCode, String contactEmail, String contactPhone);
	
}
