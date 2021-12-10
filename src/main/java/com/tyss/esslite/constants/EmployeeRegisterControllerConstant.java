package com.tyss.esslite.constants;

public class EmployeeRegisterControllerConstant {

	private EmployeeRegisterControllerConstant() {
	}
	
	public static final String EMPLOYEE_REGISTER_SUCCESS = "Employee registered successfully";
	public static final String EMPLOYEE_REGISTER_FAILURE = "Failed to register the employee";

	public static final String MAIL_SENT_SUCCESS = "Mail sent successfully";
	public static final String MAIL_NOT_SENT = "Failed to send the mail";

	public static final String FILE_UPLOADED = "File uploaded successfully";
	public static final String NOT_UPLOADED = "Failed to upload a file";

	public static final String LOGGED_IN = "Employee successfully logged in";
	public static final String FAIL_TO_LOGIN = "Employee login failed";

	public static final String PASSWORD_UPDATED = "Employee password updated successfully ";
	public static final String FAIL_TO_UPDAT_PASSWORD = "Failed to update the employee password";
	
	public static final String PROFILE_DETAILS_SUCCESS = "Employee profile details fetched successfully ";
	public static final String PROFILE_DETAILS_FAIL = "Failed to fetch the employee profile details";

	public static final String FILE_DOWNLOAD = "File downloaded successfully";
	public static final String DOWNLOAD_FAILED = "File downloaded successfully";
 
	public static final String SUCCESS = "success";

	public static final String EMPTY_FILE_MESSAGE = "Please upload a file";
	
	public static final String PROFILEID_NOT_FOUND = "Please check whether profileId is correct or file is attached and try again";
	
	public static final String EMPTY_PROFILEID =  "Please send the profile Id in the URL";

	public static final String USER_NOT_FOUND = "User not found";

	public static final String SET_PASSWORD_MESSAGE = "Please set the password and try to login";

	public static final String INVALID_CREDENTIALS = "Invalid credentials";
	
	public static final String INVALID_EMAIL = "Invalid email for the provided profile id";
	
	public static final String INVALID_PROFILE_ID_OR_EMAILID = "Please provide a valid profile id or email id";
	
	public static final String INVALID_PROFILE_ID = "EmployeeId not found";
	
	public static final String MAIL_NOT_FOUND ="MailId is already registered";
	
	public static final String ID_NOT_FOUND = "Id not found";
	
	public static final String USER_NOT_ONBOARDED = "User is not onboarded, please verify the user and try again !!";
	
	public static final String USER_NOT_REGISTERED =  "user not registered";
	
	public static final String ONBOARDED = "ONBOARDED";
	
    public static final String GET_URI_ONBOARD = "http://10.10.20.18:8096/api/v1/hiring/onboard-status?email=";
	
	public static final String POST_URI_PROFILEID = "http://10.10.20.18:8096/api/v1/hiring/set-profile";
	
	public static final String EMAIL = "email";
	
	public static final String SEND_MAIL = "Mail sent";
		
	public static final String PROFILE_ID = "profileId";
	
	public static final String OTP_MESSAGE = "Hi, This is your One Time Password ";
	public static final String OTP_TIME_MESSAGE = ". This will expire within 1 minute";
	
	public static final String OTP_NOT_SENT = "OTP not sent";
	public static final String INVALID_OTP = "Invalid OTP";
	
	public static final String ONE_TIME_PASSWORD = "ONE TIME PASSWORD";
	
	public static final String CONTACT_US = "contact@esslite.com";
	
	public static final String CONTACT_US_NAME = "esslite.com";
	
	public static final String FILE = "/file";
	
	public static final String IMAGE = "/image";
	
	public static final String VALID_OTP = "Valid OTP";
	
	public static final String FIRST_NAME_NOTEMPTY = "Name should not be empty";
	public static final String EMPLOYEE_FIRSTNAME_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*+$";
	public static final String EMPLOYEE_FIRSTNAME_REGEXP_MESSAGE = "Name filed should contain only characters,It should not contain special charactes or numbers";
	public static final String EMPLOYEE_FIRSTNAME_LENGTH = "Name length should more than 3 character and should not exceed 35 characters";
	
	
	public static final String LAST_NAME_NOTEMPTY = "Lastname should not be empty";
	public static final String EMPLOYEE_LASTNAME_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*+$";
	public static final String EMPLOYEE_LASTNAME_REGEXP_MESSAGE = "Last name filed should contain "
			+ "only characters,It should not contain special charactes or numbers";
	public static final String EMPLOYEE_LASTNAME_LENGTH = "Last name length should more than 3 character and should not exceed 35 characters";
	
	
	public static final String EMPLOYEE_EMAIL_NOTEMPTY = "Email field is required";
	public static final String EMPLOYEE_EMAIL_REGEXP="^(?=[^@]*[A-Za-z])([a-zA-Z0-9])(([\\._-])?([a-zA-Z0-9]))*+@(([a-zA-Z0-9\\-])+(\\.))*+([a-zA-Z]{2,4})*+$";
	public static final String EMPLOYEE_EMAIL_REGEXP_MESSAGE = "Please enter a valid email id";
	
	
	public static final String EMPLOYEE_MOBILENUMBER_NOTEMPTY = "Mobile number is required";
	public static final String EMPLOYEE_MOBILENUMBER_REGEXP_CODE = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
	public static final String EMPLOYEE_MOBILENUMBER_REGEXP_MESSAGE = "Mobile number is invalid, Mobile "
			+ "number should contain 10 digits numbers only";

	public static final String FORGOTPASSWORD_PASSWORD_REQUIRED = "Password field is required";
	public static final String FORGOT_PASSWORD_REGEXP ="(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}";
	public static final String FORGOTPASSWORD_PASSWORD_REGEXP_MESSAGE = "Please enter a valid password it should contain "
			+ "atleast one uppercase one lower case one special character and one number";
	public static final String FORGOTPASSWORD_PASSWORD_LENTGH = "Password must contain minimum 8 characters maximum 10 characters";

	public static final String EMPLOYEEID_MESSAGE = "Employee Id should not contain special characters";
	public static final String EMPLOYEEID_REGEXP ="^[a-zA-Z0-9]*$";
	public static final String EMPLOYEEID_LENGTH = "Employee Id length should not exceed 18 characters";
	
	public static final String EMPLOYEE_BATCHNAME_REGEXP_MESSAGE = "Batchname should not contain special characters";
	public static final String EMPLOYEE_BATCHNAME_REGEXP ="^[a-zA-Z0-9]*$";
	public static final String EMPLOYEE_BATCHNAME_LENGTH = "Batchname length should more than 3 and should not exceed 18 characters";
	
	public static final String EMPLOYEE_JSPIDERS_NAME_MESSAGE = "Jspider Name should not contain special characters";
	public static final String EMPLOYEE_JSPIDERS_NAME_REGEXP ="^[a-zA-Z0-9]*$";
	public static final String EMPLOYEE_JSPIDERS_NAME_LENGTH = "Jspiders name length should more than 3 and should not exceed 25 characters";
	
	public static final String EMPLOYEE_BUSINESS_UNIT_MESSAGE = "Business unit should not contain special characters";
	public static final String EMPLOYEE_BUSINESS_UNIT_REGEXP ="^[a-zA-Z0-9]*$";
	public static final String EMPLOYEE_BUSINESS_UNIT_LENGTH = "Business unit length should more than 3 and should not exceed 25 characters";
	
	public static final String EMPLOYEE_EDUCATION_NOTEMPTY = "Education should not be empty";
	public static final String EMPLOYEE_EDUCATION_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*+$";
	public static final String EMPLOYEE_EDUCATION_REGEXP_MESSAGE = "Education filed should contain "
			+ "only characters,It should not contain special characters or numbers";
	public static final String EMPLOYEE_EDUCATION_UNIT_LENGTH = "Education length should be morethan 2 and lessthan 35 characters";
	
	public static final String EMPLOYEE_PRIMARY_NOTEMPTY = "ProfileId should not be empty";
	public static final String EMPLOYEE_PROFILEID_REGEXP_CODE = "^[a-zA-Z0-9]+$";
	public static final String EMPLOYEE_PROFILEID_REGEXP_MESSAGE = "ProfileId should not contain special characters";
	public static final String EMPLOYEE_PROFILEID_NAME_LENGTH = "ProfileId length should more than 3 and should not exceed 25 characters";
	
	public static final String EMPLOYEE_FILENAME_NOTEMPTY = "File name should not be empty";
	
	public static final String EMPLOYEE_TECHNOLOGY_NOTEMPTY = "Technology should not be empty";
	public static final String EMPLOYEE_TECHNOLOGY_LENGTH = "Technology length should  not exceed 35 characters";
	
	
	
	public static final String EMPLOYEE_DESIGNATION_NOTEMPTY = "Designation should not be empty";
	public static final String EMPLOYEE_DESIGNATION_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*+$";
	public static final String EMPLOYEE_DESIGNATION_REGEXP_MESSAGE = "Designation filed should contain "
			+ "only characters,It should not contain special characters or numbers";
	public static final String EMPLOYEE_DESIGNATION_UNIT_LENGTH = "Designation length should be morethan 2 and lessthan 35 characters";
	
}
