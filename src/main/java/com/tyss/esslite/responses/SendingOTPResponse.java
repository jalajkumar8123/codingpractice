package com.tyss.esslite.responses;

import com.tyss.esslite.wrapper.SendOtp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendingOTPResponse {

	private boolean error;
	private String message;
	private SendOtp data;
	
}
