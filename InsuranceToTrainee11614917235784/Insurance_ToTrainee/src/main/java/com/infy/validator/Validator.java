package com.infy.validator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import com.infy.exception.InsuranceException;
import com.infy.model.PolicyDTO;

public class Validator {


	public static void validate(PolicyDTO policy) throws InsuranceException{
		String message=null;
		if(validatePolicyName(policy.getPolicyName())) {
			message="Validator.INVALID_POLICY_NAME";
		}
		if(validatePolicyType(policy.getPolicyType())) {
			message="Validator.INVALID_POLICY_TYPE";
		}
		if(validatePremium(policy.getPremium())) {
			message="Validator.INVALID_POLICY_TYPE";
		}
		if(validateTenure(policy.getTenureInMonths())) {
			message="Validator.INVALID_TENURE";
		}
		if(validateDateOfBirth(policy.getDateOfBirth())) {
			message="Validator.INVALID_DOB";
		}
		if(validatePolicyNumber(policy.getPolicyNumber(), policy.getPolicyType())) {
			message="Validator.INVALID_POLICY_NUMBER";
		}
		if(validatePolicyHolderName(policy.getPolicyHolderName())) {
			message="Validator.INVALID_HOLDER_NAME";
		}
		if(message!=null) {
			throw new InsuranceException(message);	
		}
	}

	
	public static Boolean validatePolicyName(String policyName){
		if(policyName==null || policyName.equals("")) {
			return true;
		}
		else if(policyName.matches("^[a-zA-Z]+$")) {
			return false;
		}
		return true;
	}
	
	public static Boolean validatePolicyType(String policyType){
		if(policyType.equals("Term Life Insurance") || policyType.equals("Whole Life Policy") || policyType.equals("Endowment Plans")) {
			return false;
		}
		return true;

	}
	
	public static Boolean validatePremium(Double premium){
		if(premium>100) {
			return false;
		}
		return true;

	}
	
	public static Boolean validateTenure(Integer tenureInMonths){
		if(tenureInMonths>24) {
			return false;
		}
		return true;

	}

	
	public static Boolean validateDateOfBirth(LocalDate dateOfBirth){
		if(LocalDate.now().compareTo(dateOfBirth)>0) {
			return false;
		}
		return true;

	}

	
	public static Boolean validatePolicyNumber(String policyNumber,String policyType){
		HashMap<String,String> map=new HashMap<>();
		map.put("TL","Term Life Insurance");
		map.put("WL", "Whole Life Policy");
		map.put("EP", "Endowment Plans");
		if(policyNumber.matches("^(TL|WL|EP)-\\d{6}$") && map.get(policyNumber.substring(0,2)).equals(policyType)) {
			return false;
		}
		return true;

	}

	
	public static Boolean validatePolicyHolderName(String policyHolderName){
		if(policyHolderName.matches("^(\\w{3,}(\\s\\w{3,})*)$")) {
			return false;
		}
		return true;

	}
}
