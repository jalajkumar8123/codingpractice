package com.tyss.esslite.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tyss.esslite.idgenerator.ProfilePrefIxedSequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeId")
	@GenericGenerator(name = "employeeId", strategy = "com.tyss.esslite.idgenerator.ProfilePrefIxedSequenceGenerator", parameters = {
			@Parameter(name = SequenceStyleGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = ProfilePrefIxedSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "PRO"),
			@Parameter(name = ProfilePrefIxedSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d") })
	@Column
	private String employeeId;

	@Column(length=35)
	private String firstName;
	
	@Column(length=35)
	private String lastName;
	
	@Column(length=35)
	private String email;
	
	@Column(length=15)
	private String primaryContactNo;
	
	@Column(length=150)
	@JsonIgnore
	private String password;
	
	@Column(length=35)
	private String profileId;
	
	@Column(length=35)
	private String education;
	
	@Column(length=35)
	private String batchName;
	
	@Column(length=50)
	private String technology;
	
	@Column(length=35)
	private String jspidersBranch;
	
	@Column(length=35)
	private String businessUnit;
	
	@Column
	private String designation;
	
	
	
}
