package com.tyss.esslite.dao;

/**
 * This is a Employee Project Details Repository interface that extends JpaRepository to
 * get make use of built in methods of JpaRepository.
 */

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import static com.tyss.esslite.constants.ProjectDetailsConstants.*;
import com.tyss.esslite.dto.EmployeeProjectDetails;

/**
 * This is a Project Details Repository which extends JpaRepository
 * to get the built in methods of Jpa Repository.
 */

public interface EmployeeProjectDetailRepository extends JpaRepository<EmployeeProjectDetails, Integer>{

	/**
	 * This is a Query to fetch all the employee Project Details from the 
	 * Database
	 * @param employeeid = It is the Id of Employee
	 * @return = It returns the Employee Project Details of the partilcular 
	 * employeeid.
	 */
	
	@Query(PROJECT_DETAILS_SELECT_QUERY)
	List<EmployeeProjectDetails> findByEmployeeid(String employeeId);

	/**
	 * This is a Query to delete the employee Project Details from the 
	 * Database
	 * @param employeeid = It is the Id of Employee
	 * @param projectid = It deletes the record of the particular employee,
	 * whose projectid matches.
	 * @return = It returns the Employee Project Details whose data is 
	 * deleted.
	 */
		
	@Transactional
	@Modifying
	@Query(PROJECT_DETAILS_DELETE_QUERY)
	void deleteRecord(@Param("employeeId") String employeeId, int projectId);
	
}
