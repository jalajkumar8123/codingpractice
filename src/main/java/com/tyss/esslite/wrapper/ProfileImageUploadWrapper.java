package com.tyss.esslite.wrapper;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileImageUploadWrapper {
	
	private String firstName;
	private String lastName;
	private String education;
	private String technology;
	private String phoneNo;
	private String email;
	private String imageUrl;
	private String designation;

}
