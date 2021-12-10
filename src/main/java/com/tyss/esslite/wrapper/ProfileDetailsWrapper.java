package com.tyss.esslite.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDetailsWrapper {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String designation;
	private String batchName;
	private String employeeId;
	private String technology;
	
}
