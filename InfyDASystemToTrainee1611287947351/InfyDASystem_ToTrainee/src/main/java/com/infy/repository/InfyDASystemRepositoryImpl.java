package com.infy.repository;

import org.springframework.stereotype.Component;

import com.infy.dto.DesktopDTO;
import com.infy.dto.TraineeDTO;
import com.infy.exception.InfyDASystemException;

@Component
public class InfyDASystemRepositoryImpl implements InfyDASystemRepository {

	public TraineeDTO getAllocationDetails(Integer traineeId) throws InfyDASystemException {
		TraineeDTO trainee = null;

		if (traineeId == 1001) {
			trainee = new TraineeDTO();
			trainee.setId(traineeId);
			trainee.setName("Adam");
			trainee.setPhoneNo("9658014355");
			DesktopDTO desktop = new DesktopDTO();
			desktop.setMachineName("MYSGEC111111D");
			desktop.setMake("Acer");
			trainee.setDesktop(desktop);
		}
		return trainee;
	}

	public Integer addNewTrainee(TraineeDTO trainee) throws InfyDASystemException {
		return trainee.getId();

	}

}
