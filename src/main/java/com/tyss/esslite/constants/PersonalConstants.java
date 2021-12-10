package com.tyss.esslite.constants;

public class PersonalConstants {
	
	private PersonalConstants() {
	}	
	
	
	public static final String DEBUG = "DEBUG";
	public static final String ERROR = "error";
	
	public static final String EXPERIENCE_SUCCESS_MESSAGE = "Employee personal details found successfully";
	public static final String EXPERIENCE_FAIL_MESSAGE = "Employee personal details not found for the respective employee id";

	public static final String EXPERIENCE_INSERT_SUCCESS_MESSAGE = "Employee personal details added successfully";
	public static final String EXPERIENCE_INSERT_FAIL_MESSAGE = "Failed to add employee personal details";
	
	public static final String PROFILE_PIC_UPLOADED = "profile picture uploaded successfully";
	public static final String PROFILE_PIC_NOT_UPLOADED ="profile picture not uploaded";
	
	public static final String PROFILE_PIC_DISPLAY ="profile picture displayed successfully";
	public static final String PROFILE_PIC_NOT_DISPLAY ="profile picture not displayed";
	
	public static final String JOIN_IMAGE_URL_HOST = "http://10.10.20.18:8095";
	public static final String SPLIT_FILE = "file:/";
	
	
	public static final String GENDER_NOTEMPTY = "Gender should not be empty";
	public static final String GENDER_REGEXP_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*+$";
	public static final String GENDER_REGEXP_MESSAGE = "Gender filed should contain only characters,It should not contain special charactes or numbers";
	public static final String GENDER_LENGTH = "Gender length should more than 3 character and should not exceed 10 characters";
	
	
	public static final String JOINING_DATE ="Joining date should not be future";
	
	public static final String DESIGNATION_NOTEMPTY = "Designation should not be empty";
	public static final String DESIGNATION_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*+$";
	public static final String DESIGNATION_MESSAGE = "Designation filed should contain only characters,It should not contain special charactes or numbers";
	public static final String DESIGNATION_LENGTH = "Designation length should more than 3 character and should not exceed 50 characters";
	
	public static final String ADDRESS_NOTEMPTY = "Address should not be empty";
	public static final String ADDRESS_CODE = "^[a-z|A-Z]+(?: [a-z|A-Z]+)*+$";
	public static final String ADDRESS_MESSAGE = "Address filed should contain only characters,It should not contain special charactes or numbers";
	public static final String ADDRESS_LENGTH = "Address length should more than 3 character and should not exceed 100 characters";
	
	
}
