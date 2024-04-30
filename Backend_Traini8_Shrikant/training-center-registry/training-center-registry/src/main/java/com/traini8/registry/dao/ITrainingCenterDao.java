package com.traini8.registry.dao;

import java.util.List;

import com.traini8.registry.model.TrainingCenter;
import com.traini8.registry.pojo.TrainingCenterRequest;
import com.traini8.registry.pojo.TrainingCenterResponse;

public interface ITrainingCenterDao {

	TrainingCenterResponse save(TrainingCenterRequest trainingCenter);

	 List<TrainingCenter> findAll();
}
