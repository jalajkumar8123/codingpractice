package com.tyss.esslite.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlDisplayResponse {
	
	private boolean error;
	private String message;
	private String url;

}
