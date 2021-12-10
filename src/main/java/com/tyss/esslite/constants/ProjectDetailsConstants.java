package com.tyss.esslite.constants;

public class ProjectDetailsConstants {
	private ProjectDetailsConstants() {
	}

	/* Repository constants starts here */
	public static final String PROJECT_DETAILS_SELECT_QUERY = "select u from EmployeeProjectDetails u where u.employeeId = ?1";

	public static final String PROJECT_DETAILS_DELETE_QUERY = "delete from EmployeeProjectDetails l where l.employeeId =?1 and l.projectId=?2";
	/* Repository constants ends here */

	/* Controller constants starts here */
	public static final String PROJECT_DETAILS_SUCCESS_MESSAGE = "Project Deatils updated Successfully. ";
	public static final String PROJECT_DETAILS_FAIL_MESSAGE = "Project Details not able to Update. ";

	public static final String PROJECT_DETAILS_GET_SUCCESS_MESSAGE = "Project Deatils fetched successfully. ";
	public static final String PROJECT_DETAILS_GET_FAIL_MESSAGE = "Project Deatils not available. ";
	/* Controller constants ends here */

	/* Service constants starts here */
	public static final String RECORDS_NOT_PRESENT = "Records not present for the employee id";

	public static final String DATA_CANT_UPDATED = "Data can't update";
	/* Service constants ends here */

	/* Entity constants starts here */
	public static final String PROJECT_NAME_REQUIRED_MESSAGE = "Project name cannot be empty, Please provide the project name. ";
	public static final String PROJECT_NAME_MINIMUM_MESSAGE = "Project name is too short, Provide a minimum of 3 characters. ";

	public static final String PROJECT_SUMMARY_REQUIRED_MESSAGE = "Project summary cannot be empty, Please provide the project summary. ";
	public static final String PROJECT_SUMMARY_MINIMUM_MESSAGE = "Project summary is too short, Provide a minimum of 3 characters. ";

	public static final String ROLES_AND_RESPONSIBILITIES_REQUIRED_MESSAGE = "Roles and responsibilities cannot be empty, Please provide the roles and responsibilities. ";
	public static final String ROLES_AND_RESPONSIBILITIES_MINIMUM_MESSAGE = "Roles and responsibilities is too short, Provide a minimum of 3 characters. ";
	/* Entity constants ends here */

}
