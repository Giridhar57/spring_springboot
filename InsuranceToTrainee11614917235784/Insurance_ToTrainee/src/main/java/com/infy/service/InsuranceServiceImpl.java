package com.infy.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.exception.InsuranceException;
import com.infy.model.PolicyDTO;
import com.infy.model.PolicyReportDTO;
import com.infy.repository.InsuranceRepository;
import com.infy.validator.Validator;

public class InsuranceServiceImpl implements InsuranceService{
	@Autowired
	private InsuranceRepository insuranceRespository;

	public String buyPolicy(PolicyDTO policy) throws InsuranceException {
		try {
			Validator.validate(policy);
			return policy.getPolicyNumber();
		}catch(InsuranceException e) {
			System.out.println(e);
			throw e;
		}
	}

	public Long calculateAge(LocalDate dateOfBirth) throws InsuranceException {
		Long res=(long) LocalDate.now().compareTo(dateOfBirth);
		return res;
	}

	public List<PolicyReportDTO> getReport(String policyType) throws InsuranceException {
//		try {
//			List<PolicyDTO> all_details=insuranceRespository.getAllPolicyDetails();
//			List<PolicyDTO> filter_details=new ArrayList<PolicyDTO>();
//			for(PolicyDTO p:all_details) {
//				if(p.getPolicyType().equals(policyType)) {
//					filter_details.add(p);
//				}
//			}
//			List<PolicyReportDTO> report=new ArrayList<PolicyReportDTO>();
//			for(PolicyDTO p:filter_details) {
//				PolicyReportDTO temp=new PolicyReportDTO();
//				temp.setPolicyHolderAge(1.0*calculateAge(p.getDateOfBirth()));
//				temp.setPolicyHolderName(p.getPolicyHolderName());
//				temp.setPolicyNumber(p.getPolicyNumber());
//				temp.setTenureInMonths(p.getTenureInMonths());
//				report.add(temp);
//			}
//			if (filter_details.isEmpty()) {
//                throw new InsuranceException("Service.NO_RECORD");
//            }
//			return report;
//		}
//		catch (InsuranceException ex) {
//            throw ex;
//		}
		List<PolicyDTO> all_details=insuranceRespository.getAllPolicyDetails();
		List<PolicyDTO> filter_details=new ArrayList<PolicyDTO>();
		for(PolicyDTO p:all_details) {
			if(p.getPolicyType().equals(policyType)) {
				filter_details.add(p);
			}
		}
		List<PolicyReportDTO> report=new ArrayList<PolicyReportDTO>();
		for(PolicyDTO p:filter_details) {
			PolicyReportDTO temp=new PolicyReportDTO();
			temp.setPolicyHolderAge(1.0*calculateAge(p.getDateOfBirth()));
			temp.setPolicyHolderName(p.getPolicyHolderName());
			temp.setPolicyNumber(p.getPolicyNumber());
			temp.setTenureInMonths(p.getTenureInMonths());
			report.add(temp);
		}
		if (filter_details.isEmpty()) {
			System.out.println("Service.NO_RECORD");
            throw new InsuranceException("Service.NO_RECORD");
        }
		return report;
	}

		
	
	
}
