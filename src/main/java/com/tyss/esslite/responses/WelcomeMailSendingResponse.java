package com.tyss.esslite.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WelcomeMailSendingResponse {
	
	private boolean error;
	private String message;
	private String data;
	

}
