package com.infy.validator;

import com.infy.dto.TraineeDTO;
import com.infy.exception.InfyDASystemException;


public class Validator {


	public static void validate(TraineeDTO trainee) throws InfyDASystemException {
		String message=null;
		if(!trainee.getName().matches("^[a-zA-Z]+$")) {
			message="Invalid Name";
		}
		if(trainee.getId()/1000<0 || trainee.getId()/1000>=10) {
			message="Invalid Id";
		}
		if(!validateTraineePhoneNo(trainee.getPhoneNo())) {
			message="Invalid Phone Number";
		}
		if(message!=null) {
			throw new InfyDASystemException(message);
		}
	}

	public static Boolean validateTraineePhoneNo(String phoneNo) throws InfyDASystemException {
		if(phoneNo.matches("^\\d+$")) {
			return true;
		}
		return false;
	}
}

