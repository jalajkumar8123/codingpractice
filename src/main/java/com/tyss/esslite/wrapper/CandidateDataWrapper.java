package com.tyss.esslite.wrapper;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDataWrapper {
	
	private int candidateId;

	private String name;

	private String emailId;

	private String contactNumber;

	private String stream;

	private int tenthPercentage;

	private int twelfthPercentage;

	private String degree;

	private int degreePercentage;

	private String jspiderBranch;

	private int masterDegreeAggregate;

	private int yop;

	private String status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime lastUpdatedAt;

	private String lastUpdatedBy;

	private int driveId;

	
}
