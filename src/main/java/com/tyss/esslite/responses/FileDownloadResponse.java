package com.tyss.esslite.responses;

import java.net.URL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDownloadResponse {
	
	private boolean error;
	private String message;
	private URL url;

}
