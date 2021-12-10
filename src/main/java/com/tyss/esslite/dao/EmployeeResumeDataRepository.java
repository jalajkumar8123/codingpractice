package com.tyss.esslite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.esslite.dto.EmployeeResumeData;

/**
* This is a Resume Data Repository which extends JpaRepository
* to get the built in methods of Jpa Repository.
*/
public interface EmployeeResumeDataRepository extends JpaRepository<EmployeeResumeData, String> {

}
