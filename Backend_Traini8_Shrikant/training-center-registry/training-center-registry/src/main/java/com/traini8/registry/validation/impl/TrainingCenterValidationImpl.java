package com.traini8.registry.validation.impl;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traini8.registry.model.TrainingCenter;
import com.traini8.registry.pojo.AddressRequest;
import com.traini8.registry.pojo.TrainingCenterRequest;
import com.traini8.registry.repository.TrainingCenterRepository;
import com.traini8.registry.validation.ITrainingCenterValidation;

@Service
public class TrainingCenterValidationImpl implements ITrainingCenterValidation {

    @Autowired
    TrainingCenterRepository trainingCenterRepository;

    @Override
    public boolean isTrainingCenterRequestValid(TrainingCenterRequest trainingCenterRequest) {
        if (trainingCenterRequest == null) {
            return false;
        }

        String centerName = trainingCenterRequest.getCenterName();
        String centerCode = trainingCenterRequest.getCenterCode();
        AddressRequest address = trainingCenterRequest.getAddress();
        String contactEmail = trainingCenterRequest.getContactEmail();
        String contactPhone = trainingCenterRequest.getContactPhone();

        // Regular expressions for pattern matching
        String centerNamePt = "^[A-Za-z'\\s-]{1,40}$";
        String centerCodePt = "^[a-zA-Z0-9]{12}$";
        String contactEmailPt = "^[A-Za-z0-9+_.-]+@(.+)$";
        String contactPhonePt = "^[0-9]{10}$";

        boolean addressValid = isValidAddress(address);

        // Patterns matching and existence in the repository
        return centerName != null && Pattern.matches(centerNamePt, centerName) &&
                centerCode != null && Pattern.matches(centerCodePt, centerCode) &&
                (contactEmail == null || Pattern.matches(contactEmailPt, contactEmail)) &&
                contactPhone != null && Pattern.matches(contactPhonePt, contactPhone) &&
                !existsByCenterNameIgnoreCaseOrCenterCodeIgnoreCaseOrContactEmailIgnoreCaseOrContactPhone(
                        centerName, centerCode, contactEmail, contactPhone) &&
                addressValid;
    }


    private boolean isValidAddress(AddressRequest address) {
        if (address == null) {
            return false;
        }
        String city = address.getCity();
        String state = address.getState();
        String pincode = address.getPincode();
        String detailedAddress = address.getDetailedAddress();

        // Address fields are validate
        return city != null && isValidCity(city) &&
                state != null && isValidState(state) &&
                pincode != null && isValidPincode(pincode) &&
                !detailedAddress.isEmpty();
    }

    @Override
    public void validateTrainingCenter(TrainingCenter trainingCenter) {
        if (trainingCenter == null) {
            throw new IllegalArgumentException("Training center object cannot be null");
        }
    }

    // Checks if a training center with the given attributes already exists
    @Override
    public boolean existsByCenterNameIgnoreCaseOrCenterCodeIgnoreCaseOrContactEmailIgnoreCaseOrContactPhone(
            String centerName, String centerCode, String contactEmail, String contactPhone) {
        return trainingCenterRepository.existsByCenterNameIgnoreCaseOrCenterCodeIgnoreCaseOrContactEmailIgnoreCaseOrContactPhone(
                centerName, centerCode, contactEmail, contactPhone);
    }

    private boolean isValidCity(String city) {
        return city.matches("^[A-Za-z]+$");
    }

    private boolean isValidState(String state) {
        return !state.isEmpty();
    }

    private boolean isValidPincode(String pincode) {
        return pincode.matches("^[0-9]{6}$");
    }
}
