package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infy.dto.TraineeDTO;
import com.infy.exception.InfyDASystemException;
import com.infy.repository.InfyDASystemRepository;
import com.infy.validator.Validator;


@Component
public class InfyDASystemServiceImpl implements InfyDASystemService {
	
	@Autowired
	private InfyDASystemRepository infyDASystemRepository;

	public TraineeDTO getAllocationDetails(Integer traineeId) throws InfyDASystemException {
		try {
			TraineeDTO trainee=infyDASystemRepository.getAllocationDetails(traineeId);
			if(trainee==null) {
				throw new InfyDASystemException("Service.NO_DETAILS_FOUND");
			}
			return trainee;
		}catch(InfyDASystemException e) {
			throw e;
		}
	}

	public Integer addNewTrainee(TraineeDTO trainee) throws InfyDASystemException {
		try {
			Validator.validate(trainee);
			return infyDASystemRepository.addNewTrainee(trainee);
		}catch(InfyDASystemException e){
			throw e;
		}
	}

	
}
