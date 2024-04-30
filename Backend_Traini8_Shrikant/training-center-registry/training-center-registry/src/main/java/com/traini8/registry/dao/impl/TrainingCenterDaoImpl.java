package com.traini8.registry.dao.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traini8.registry.dao.ITrainingCenterDao;
import com.traini8.registry.model.AddressModel;
import com.traini8.registry.model.TrainingCenter;
import com.traini8.registry.pojo.AddressRequest;
import com.traini8.registry.pojo.TrainingCenterRequest;
import com.traini8.registry.pojo.TrainingCenterResponse;
import com.traini8.registry.repository.TrainingCenterRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TrainingCenterDaoImpl implements ITrainingCenterDao {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @Override
    public TrainingCenterResponse save(TrainingCenterRequest trainingCenter) {
        log.debug("Create Training Center :: DAO Layer");
        TrainingCenterResponse response = new TrainingCenterResponse();
        try {
        	// Create object to store center
            TrainingCenter savedTrainingCenter = new TrainingCenter();
            savedTrainingCenter.setCenterName(trainingCenter.getCenterName());
            savedTrainingCenter.setCenterCode(trainingCenter.getCenterCode());
            savedTrainingCenter.setCoursesOffered(trainingCenter.getCoursesOffered());

            // Set address details from the request
            AddressModel address = new AddressModel();
            address.setDetailedAddress(trainingCenter.getAddress().getDetailedAddress());
            address.setCity(trainingCenter.getAddress().getCity());
            address.setState(trainingCenter.getAddress().getState());
            address.setPincode(trainingCenter.getAddress().getPincode());
            savedTrainingCenter.setAddress(address);
            savedTrainingCenter.setStudentCapacity(trainingCenter.getStudentCapacity());
            savedTrainingCenter.setCreatedOn(LocalDateTime.now());
            savedTrainingCenter.setContactEmail(trainingCenter.getContactEmail());
            savedTrainingCenter.setContactPhone(trainingCenter.getContactPhone());
            
            TrainingCenter modelResponseCenter = trainingCenterRepository.save(savedTrainingCenter);
            
            response.setId(modelResponseCenter.getId());
            response.setCreatedOn(modelResponseCenter.getCreatedOn());
            response.setCenterName(modelResponseCenter.getCenterName());
            response.setCenterCode(modelResponseCenter.getCenterCode());
            response.setStudentCapacity(modelResponseCenter.getStudentCapacity());
            response.setCoursesOffered(modelResponseCenter.getCoursesOffered());
            response.setContactEmail(modelResponseCenter.getContactEmail());
            response.setContactPhone(modelResponseCenter.getContactPhone());
            response.setAddress(trainingCenter.getAddress());
            log.debug("Training Center added :: SUCCESS");

        } catch (Exception e) {
            log.error("FAILED : Add Training Center Failed. | Error {} ", e);
            return response;
        }
        return response;
    }

    
    @Override
    public List<TrainingCenter> findAll() {
        log.debug("Fetch All Training Centers :: DAO Layer");
        try {
            List<TrainingCenter> trainingCenters = trainingCenterRepository.findAll();
            if (trainingCenters.isEmpty()) {
                log.debug("No training centers found");
                
             // Returning an empty center list
                return Collections.emptyList(); 
            }
            log.debug("Fetch All Training Centers :: SUCCESS");
            return trainingCenters;
            
        } catch (Exception e) {
            log.error("Fetch All Training Centers :: FAILED | Error {} ", e);
            return null;
        }
    }
}
