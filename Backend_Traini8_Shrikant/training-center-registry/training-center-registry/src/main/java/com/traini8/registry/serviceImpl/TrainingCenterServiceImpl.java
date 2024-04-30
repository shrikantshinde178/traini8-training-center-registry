package com.traini8.registry.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traini8.registry.dao.ITrainingCenterDao;
import com.traini8.registry.model.TrainingCenter;
import com.traini8.registry.pojo.TrainingCenterRequest;
import com.traini8.registry.pojo.TrainingCenterResponse;
import com.traini8.registry.service.TrainingCenterService;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {

    @Autowired
    private ITrainingCenterDao trainingCenterDao;


	@Override
	public TrainingCenterResponse save(TrainingCenterRequest trainingCenter, List<String> coursesOffered) {
		return trainingCenterDao.save(trainingCenter);
	}


	@Override
	public List<TrainingCenter> getAllTrainingCenters() {
		return trainingCenterDao.findAll();
	}
	
}
