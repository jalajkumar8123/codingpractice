package com.tyss.esslite.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import static com.tyss.esslite.constants.ExperienceConstants.*;
import com.tyss.esslite.dto.EmployeeExperienceDetails;

/**
 * This is a Experience Repository which extends JpaRepository
 * to get the built in methods of Jpa Repository.
 */

public interface EmployeeExperienceRepository extends JpaRepository<EmployeeExperienceDetails, Integer>{

	/**
	 * This is a Query to fetch all the employee Education Details from the 
	 * Database
	 * @param employeeid = It is the Id of Employee
	 * @return = It returns the Employee Education Details of the partilcular 
	 * employeeid.
	 */

	@Query(EXPERIENCE_SELECT_QUERY)
	List<EmployeeExperienceDetails> findByEmployeeid(String employeeid);

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
	@Query(EXPERIENCE_DELETE_QUERY)
	void deleteRecord(@Param("employeeid") String employeeid);

	
}
