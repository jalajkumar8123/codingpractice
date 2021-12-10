package com.tyss.esslite.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import static com.tyss.esslite.constants.TechnologyConstants.*;
import com.tyss.esslite.dto.TechnologyDetails;

public interface TechnologyDetailsRepo extends JpaRepository<TechnologyDetails, Integer> {

	@Query(TECHNOLOGY_GET_EMPLOYEEID_QUERY)
	public List<TechnologyDetails> getTechsByEmployeeId(String employeeId);

//	@Transactional
//	@Modifying
//	void deleteByEmployeeid(String employeeId);

}
