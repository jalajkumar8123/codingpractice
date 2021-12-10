package com.tyss.esslite.responses;

import com.tyss.esslite.wrapper.ProfileImageUploadWrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilePictureUploadResponse {
	
	private boolean error;
	private String message;
	private ProfileImageUploadWrapper data;

}
