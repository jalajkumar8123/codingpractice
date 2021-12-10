package com.tyss.esslite.constants;

public class EducationConstants {

	private EducationConstants() {
	}

	public static final String EDUCATION_SELECT_QUERY = "select u from EmployeeEducationalDetails u where u.employeeId = ?1";

	public static final String EDUCATION_DELETE_QUERY = "delete from EmployeeEducationalDetails l where l.employeeId =?1";

	public static final String EDUCATION_SUCCESS_MESSAGE = "Employee education details found successfully";
	public static final String EDUCATION_FAIL_MESSAGE = "Employee education details not found for the respective employee id";

	public static final String EDUCATION_INSERT_SUCCESS_MESSAGE = "Employee education details added successfully";
	public static final String EDUCATION_INSERT_FAIL_MESSAGE = "Failed to add employee education details";

	public static final String EDUCATION_UPDATE_SUCCESS_MESSAGE = "Employee education details updated successfully";
	public static final String EDUCATION_UPDATE_FAIL_MESSAGE = "Failed to update employee education updated details";

	public static final String EDUCATION_DELETE_SUCCESS_MESSAGE = "Employee education details deleted successfully";
	public static final String EDUCATION_DELETE_FAIL_MESSAGE = "Failed to delete employee education details";

	public static final String QUALIFICATION_INFO_REQUIRED_MESSAGE = "Qualification details cannot be empty, Please provide the qualification details";
	public static final String QUALIFICATION_INFO_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*$";
	public static final String QUALIFICATION_INFO_MINIMUM_SIZE_MESSAGE = "Qualification is too short, Provide a minimum of 3 characters";
	public static final String QUALIFICATION_INFO_REGEXP_MESSAGE = "Please proivide a valid qualification details";

	public static final String COURSE_INFO_REQUIRED_MESSAGE = "Course details cannot be empty, Please provide the course details";
	public static final String COURSE_INFO_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*$";
	public static final String COURSE_INFO_MINIMUM_SIZE_MESSAGE = "Course details is too short, Provide a minimum of 3 characters";
	public static final String COURSE_INFO_REGEXP_MESSAGE = "Please proivide a valid course details";

	public static final String SPECIALIZATION_REQUIRED_MESSAGE = "Specialization details cannot be empty, Please provide the specialization details";
	public static final String SPECIALIZATION_INFO_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*$";
	public static final String SPECIALIZATION_MINIMUM_SIZE_MESSAGE = "Specialization details is too short, Provide a minimum of 3 characters";
	public static final String SPECIALIZATION_REGEXP_MESSAGE = "Please proivide a valid specialization details";

	public static final String INSTITUTION_REQUIRED_MESSAGE = "Institution details cannot be empty, Please provide the institution details";
	public static final String INSTITUTION_INFO_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*$";
	public static final String INSTITUTION_MINIMUM_SIZE_MESSAGE = "Institution details is too short, Provide a minimum of 3 characters";
	public static final String INSTITUTION_REGEXP_MESSAGE = "Please proivide a valid institution details";

	public static final String PASSOUT_YEAR_REQUIRED_MESSAGE = "Passout year cannot be empty, Please provide the passout year";
	public static final String PASSOUT_YEAR_INVALID_MESSAGE = "Please provide a valid passout year";

	public static final String UNIVERSITY_REQUIRED_MESSAGE = "University details cannot be empty, Please provide the university details";
	public static final String UNIVERSITY_INFO_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*$";
	public static final String UNIVERSITY_MINIMUM_SIZE_MESSAGE = "University details is too short, Provide a minimum of 3 characters";
	public static final String UNIVERSITY_REGEXP_MESSAGE = "Please proivide valid university details";

	public static final String PASSOUT_YEAR_ERROR_MESSAGE = "Passout year cannot be future date";

	public static final String PERCENTAGE_ERROR_MESSAGE = "Percentage cannot exceed 100";
	public static final String PERCENTAGE_INVALID_MESSAGE = "Please provide valid percentage details";
	public static final String PERCENTAGE_YEAR_REQUIRED_MESSAGE = "Percentage cannot be empty, Please provide the percentage";

}
