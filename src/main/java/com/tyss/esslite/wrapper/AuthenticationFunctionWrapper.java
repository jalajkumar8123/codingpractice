package com.tyss.esslite.wrapper;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationFunctionWrapper {
	
	
	private UserDetails userDetails;
	private String employeeId;

}
