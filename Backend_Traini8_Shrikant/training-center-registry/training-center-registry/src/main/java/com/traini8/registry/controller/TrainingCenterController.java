package com.traini8.registry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.traini8.registry.model.TrainingCenter;
import com.traini8.registry.pojo.TrainingCenterRequest;
import com.traini8.registry.pojo.TrainingCenterResponse;
import com.traini8.registry.service.TrainingCenterService;
import com.traini8.registry.validation.ITrainingCenterValidation;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(value = { "*", "http://localhost:4200" }, allowedHeaders = { "*" }, originPatterns = { "*",
			"http://localhost:4200" }, origins = { "*", "http://localhost:4200" })
@RequestMapping("/api/")
public class TrainingCenterController {

    @Autowired(required = true)
    public TrainingCenterService trainingCenterService;
    
    @Autowired(required = true)
    public ITrainingCenterValidation trainingCenterRequestValid;

    @PostMapping("/createCenter")
    public ResponseEntity<TrainingCenterResponse> createTrainingCenter(@RequestBody TrainingCenterRequest Request) {
        log.info("Create Training Center : Request Received {}", Request.toString());
        TrainingCenterResponse savedTrainingCenter;
        try {
            if (trainingCenterRequestValid.isTrainingCenterRequestValid(Request)) {
            	// Get the list of courses offered from the request
                List<String> coursesOffered = Request.getCoursesOffered();
                savedTrainingCenter = trainingCenterService.save(Request, coursesOffered);
                log.info("Create Training Center: SUCCESS. Response: {}", savedTrainingCenter.toString());
                return new ResponseEntity<TrainingCenterResponse>(savedTrainingCenter, HttpStatus.OK);
            } else {
                log.error("Create Training Center: Invalid input. Response: {}", HttpStatus.BAD_REQUEST);
                TrainingCenterResponse response = new TrainingCenterResponse();
                response.setMessage("Please Provide the valid input!");
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error("Create Training Center: Failed. Error: {}", e);
            return new ResponseEntity<TrainingCenterResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @GetMapping("/fetchCenters")
    public ResponseEntity<List<TrainingCenter>> fetchTrainingCenters() {
        log.info("Fetch All Training Centers : Request Received");
        try {
            List<TrainingCenter> trainingCenters = trainingCenterService.getAllTrainingCenters();
            if (trainingCenters.isEmpty()) {
                log.info("Fetch All Training Centers : No training centers found");
                return ResponseEntity.noContent().build();
            }
            log.info("Fetch All Training Centers : SUCCESS. | Response {}", trainingCenters.toString());
            return ResponseEntity.ok(trainingCenters);
        } catch (Exception e) {
            log.error("Fetch All Training Centers : FAILED | Error : {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
