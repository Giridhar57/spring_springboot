package com.infy.repository;

import com.infy.dto.TraineeDTO;
import com.infy.exception.InfyDASystemException;


public interface InfyDASystemRepository {

	public TraineeDTO getAllocationDetails(Integer traineeId) throws InfyDASystemException ;
	public Integer addNewTrainee(TraineeDTO trainee) throws InfyDASystemException;

}
