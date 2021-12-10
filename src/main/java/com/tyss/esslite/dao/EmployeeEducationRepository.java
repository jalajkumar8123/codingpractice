package com.tyss.esslite.dao;

/**
 * This is a Education Repository which extends JpaRepository
 * to get the built in methods of Jpa Repository.
 */

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import static com.tyss.esslite.constants.EducationConstants.*;
import com.tyss.esslite.dto.EmployeeEducationalDetails;



public interface EmployeeEducationRepository extends JpaRepository<EmployeeEducationalDetails, Integer> {

	/**
	 * This is a Query to fetch all the employee Education Details from the 
	 * Database
	 * @param employeeid = It is the Id of Employee
	 * @return = It returns the Employee Education Details of the partilcular 
	 * employeeid.
	 */

	@Query(EDUCATION_SELECT_QUERY)
	List<EmployeeEducationalDetails> findByEmployeeid(String employeeid);

	/**
	 * This is a Query to delete the employee Education Details from the 
	 * Database
	 * @param employeeid = It is the Id of Employee
	 * @param educationalid = It deletes the record of the particular employee,
	 * whose educationalid matches.
	 * @return = It returns the Employee Education Details whose data is 
	 * deleted.
	 */
		
	@Transactional
	@Modifying
	@Query(EDUCATION_DELETE_QUERY)
	void deleteRecord(@Param("employeeId") String employeeId);


}
