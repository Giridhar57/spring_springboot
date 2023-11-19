package com.infy.validator;

import com.infy.model.TeamMember;

public class Validator {

	public static void validate(TeamMember teamMember) throws Exception {
		if(!validateEmployeeId(teamMember.getEmployeeId())) {
			throw new Exception("VALIDTOR.INVALID_EMPLOYEEID");
		}
	}

	public static Boolean validateEmployeeId(Integer employeeId) throws Exception {
		if(employeeId/100000>0 && employeeId/100000<10) {
			return true;
		}
		return false;
	}

}
