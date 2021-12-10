package com.tyss.esslite.responses;

import com.tyss.esslite.wrapper.ProfileDetailsWrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDetailsResponse {
	
	private boolean error;
	private String message;
	private ProfileDetailsWrapper data;

}
