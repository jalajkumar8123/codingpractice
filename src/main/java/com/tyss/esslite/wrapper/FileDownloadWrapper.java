package com.tyss.esslite.wrapper;

import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDownloadWrapper {

	@NotBlank(message = EMPLOYEE_PRIMARY_NOTEMPTY)
	@Pattern(regexp = EMPLOYEE_PROFILEID_REGEXP_CODE, message = EMPLOYEE_PROFILEID_REGEXP_MESSAGE)
	@Size(min = 3, max = 25, message = EMPLOYEE_PROFILEID_NAME_LENGTH)
	private String profileId;
	
	@NotBlank(message = EMPLOYEE_FILENAME_NOTEMPTY)
	private String fileName;

}
