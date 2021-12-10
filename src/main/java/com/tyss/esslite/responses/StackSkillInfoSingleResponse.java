package com.tyss.esslite.responses;

import java.util.List;

import com.tyss.esslite.dto.TechnologyDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a response class for Technology page. Here you find all responses of
 * EmployeeTechnologyController for Technology page.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StackSkillInfoSingleResponse {

	private boolean error;
	private String message;

	private List<TechnologyDetails> data;


}
