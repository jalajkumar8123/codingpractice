package com.tyss.esslite.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeFileUploadResponse {
	
	private boolean error;
	private String message;
	

}
