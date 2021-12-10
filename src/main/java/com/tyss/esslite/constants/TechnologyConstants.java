package com.tyss.esslite.constants;

public class TechnologyConstants {
	private TechnologyConstants() {
	}

	public static final String TECHNOLOGY_SUCCESS_MESSAGE = "Fetch Successful";
	public static final String TECHNOLOGY_FAIL_MESSAGE = "Record Fetch Unsuccessful";

	public static final String TECHNOLOGY_INSERT_SUCCESS_MESSAGE = "Inserted Successfully";
	public static final String TECHNOLOGY_INSERT_FAIL_MESSAGE = "Inserted  Unsuccessfull";

	public static final String TECHNOLOGY_UPDATE_SUCCESS_MESSAGE = "Update Successful";
	public static final String TECHNOLOGY_UPDATE_FAIL_MESSAGE = "Record update Unsuccessful";

	public static final String TECHNOLOGY_DELETE_SUCCESS_MESSAGE = "Deleted Successfully";
	public static final String TECHNOLOGY_DELETE_FAIL_MESSAGE = "Delete  Unsuccessfull";

	public static final String TECHNOLOGY_GET_EMPLOYEEID_QUERY = "Select td from TechnologyDetails td where td.employeeId=?1";

	public static final String TECHNOLOGY_DELETE_SKILLID_QUERY = "delete from TechnologySkills td where td.skillId=?1";

	public static final String TECHNOLOGY_TYPE_REQUIRED_MESSAGE = "Technology type cannot be empty, Please provide the technology type. ";
	public static final String TECHNOLOGY_TYPE_MINIMUM_MESSAGE = "Technology type is too short, Provide a minimum of 3 characters. ";

	public static final String TECHNOLOGY_SKILLS_REQUIRED_MESSAGE = "Technology skills cannot be empty, Please provide the technology skills. ";
	public static final String TECHNOLOGY_SKILLS_MINIMUM_MESSAGE = "Technology skill is too short, Provide a minimum of 3 characters. ";

	public static final String SKILLS_RATINGS_REQUIRED_MESSAGE = "Skill ratings cannot be empty, Please provide the skill ratings. ";
	public static final String SKILLS_RATINGS_MINIMUM_MESSAGE = "Skill ratings should be atleast 1.";
	public static final String SKILLS_RATINGS_MAXIMUM_MESSAGE = "Skill ratings should not exceed 5.";

}
