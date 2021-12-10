package com.tyss.esslite.constants;

public class ExperienceConstants {
	private ExperienceConstants() {
	}

	public static final String EXPERIENCE_SELECT_QUERY = "select u from EmployeeExperienceDetails u where u.employeeId = ?1";

	public static final String EXPERIENCE_DELETE_QUERY = "delete from EmployeeExperienceDetails l where l.employeeId =?1";

	public static final String EXPERIENCE_SUCCESS_MESSAGE = "Employee experience details found successfully";
	public static final String EXPERIENCE_FAIL_MESSAGE = "Employee experience details not found for the respective employee id";

	public static final String EXPERIENCE_INSERT_SUCCESS_MESSAGE = "Employee experience details added successfully";
	public static final String EXPERIENCE_INSERT_FAIL_MESSAGE = "Failed to add employee experience details";

	public static final String EXPERIENCE_UPDATE_SUCCESS_MESSAGE = "Employee experience details updated successfully";
	public static final String EXPERIENCE_UPDATE_FAIL_MESSAGE = "Failed to update employee experience details";

	public static final String EXPERIENCE_DELETE_SUCCESS_MESSAGE = "Employee experience details deleted successfully";
	public static final String EXPERIENCE_DELETE_FAIL_MESSAGE = "Failed to delete employee experience details";

	public static final String DESIGNATION_REQUIRED_MESSAGE = "Designation details cannot be empty, Please provide the designation details";
	public static final String DESIGNATION_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*$";
	public static final String DESIGNATION_MINIMUM_SIZE_MESSAGE = "Designation is too short, Provide a minimum of 3 characters";
	public static final String DESIGNATION_REGEXP_MESSAGE = "Please proivide a valid designation details";

	public static final String COMPANY_REQUIRED_MESSAGE = "Company details cannot be empty, Please provide the company details";
	public static final String COMPANY_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*$";
	public static final String COMPANY_MINIMUM_SIZE_MESSAGE = "Company is too short, Provide a minimum of 3 characters";
	public static final String COMPANY_REGEXP_MESSAGE = "Please proivide a valid company details";

	public static final String CITY_REQUIRED_MESSAGE = "City name cannot be empty, Please provide the city name";
	public static final String CITY_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*$";
	public static final String CITY_MINIMUM_SIZE_MESSAGE = "City name is too short, Provide a minimum of 3 characters";
	public static final String CITY_REGEXP_MESSAGE = "Please proivide a valid city name";

	public static final String TOTAL_EXPERIENCE_REQUIRED_MESSAGE = "Total experience cannot be empty, Please provide the total experience";
	public static final String TOTAL_EXPERIENCE_REGEX = "[0-9+/.()-]+";
	public static final String TOTAL_EXPERIENCE_REGEX_MESSAGE = "Total experience should be in a proper format. ";
	
	
	public static final String RELEVANT_EXPERIENCE_REQUIRED_MESSAGE = "Relevant experience cannot be empty, Please provide the relevant experience. ";
	public static final String RELEVENT_EXPERIENCE_REGEX = "[0-9+/.()-]+";
	public static final String RELEVENT_EXPERIENCE_REGEX_MESSAGE = "Relevant Experience should be in a proper format. ";
	
	public static final String WORKING_FROM_VALIDITY_MESSAGE = "Working from should be past. ";
	
	public static final String WORKING_TILL_VALIDITY_MESSAGE = "Working till should be past or present. ";
	
	
	public static final String WRONG_TOTAL_EXPERIENCE = "Total experience should be more than relevent experience. ";
	public static final String WRONG_MONTH = "Month should be less than equal to 12. ";
	public static final String EXPERINCE_NOT_STORED = "Failed to store the employee record";
}