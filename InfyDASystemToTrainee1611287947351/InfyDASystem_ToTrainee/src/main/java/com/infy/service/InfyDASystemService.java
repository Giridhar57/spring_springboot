package com.infy.service;

import com.infy.dto.TraineeDTO;
import com.infy.exception.InfyDASystemException;

public interface InfyDASystemService {

	public TraineeDTO getAllocationDetails(Integer traineeId) throws InfyDASystemException ;
	public Integer addNewTrainee(TraineeDTO trainee) throws InfyDASystemException;

}
