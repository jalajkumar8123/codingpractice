package com.tyss.esslite.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDocuments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int docId;
	
	@Column
	private String fileName;
	
	@Column
	private String imageUrl;
	
	@Column
	private String employeeId;

}
