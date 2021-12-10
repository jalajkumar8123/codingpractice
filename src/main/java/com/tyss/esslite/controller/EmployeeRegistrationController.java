package com.tyss.esslite.controller;

import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.*;
import static com.tyss.esslite.constants.PersonalConstants.DEBUG;

import java.io.IOException;
import java.net.URL;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.esslite.dto.EmployeeRegistration;
import com.tyss.esslite.dto.ForgotPassword;
import com.tyss.esslite.dto.JwtRequest;
import com.tyss.esslite.dto.JwtResponse;
import com.tyss.esslite.exception.CandidateStatusOnboardingNotFoundException;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.exception.InvalidCredentailException;
import com.tyss.esslite.exception.MultipartFileIsEmptyException;
import com.tyss.esslite.exception.UnauthorizedException;
import com.tyss.esslite.responses.EmployeeFileUploadResponse;
import com.tyss.esslite.responses.EmployeeRegistrationResponse;
import com.tyss.esslite.responses.FileDownloadResponse;
import com.tyss.esslite.responses.ForgortPasswordResponse;
import com.tyss.esslite.responses.ProfileDetailsResponse;
import com.tyss.esslite.responses.SendingOTPResponse;
import com.tyss.esslite.responses.VerifyOtpResponse;
import com.tyss.esslite.services.EmployeeRegistrationService;
import com.tyss.esslite.wrapper.AuthenticationFunctionWrapper;
import com.tyss.esslite.wrapper.EmployeeRegistrationWrapper;
import com.tyss.esslite.wrapper.FileDownloadWrapper;
import com.tyss.esslite.wrapper.ProfileDetailsWrapper;
import com.tyss.esslite.wrapper.SendOtp;
import com.tyss.esslite.wrapper.TempOtp;

/**
 * This controller is used to Register the user, authenticate the user, to send
 * the mail to the user and updated the password.
 * 
 * @author TYSS
 *
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class EmployeeRegistrationController {

	Logger logger = LoggerFactory.getLogger(EmployeeRegistrationController.class);
	
	@Autowired
	private EmployeeRegistrationService employeeRegistrationService;

	/**
	 * This post service is used to register the employees and that data is stored
	 * in the database.
	 * 
	 * @param employeeRegistration
	 * @return
	 * @throws EmployeeCustomException
	 * @throws EmployeeInsertNotFoundException
	 * @throws CandidateStatusOnboardingNotFoundException
	 */
	@PostMapping("esslite/user/user-register")
	public ResponseEntity<EmployeeRegistrationResponse> employeeRegister(
			@Valid @RequestBody EmployeeRegistrationWrapper employeeRegistrationWrapper) throws EmployeeCustomException,
			EmployeeInsertNotFoundException, CandidateStatusOnboardingNotFoundException {

		EmployeeRegistration register = employeeRegistrationService.register(employeeRegistrationWrapper);

		logger.debug(DEBUG);
		
		if (register != null) {
			return new ResponseEntity<>(new EmployeeRegistrationResponse(false, EMPLOYEE_REGISTER_SUCCESS, register),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EmployeeRegistrationResponse(true, EMPLOYEE_REGISTER_FAILURE, null),
					HttpStatus.BAD_REQUEST);
		}

	}


	/**
	 * This method is used to upload the file and that file is store in the local
	 * server directory called testyantra/technoelevate/profileId Here the profileID
	 * and fileName is dynamically sent by the user.
	 * 
	 * @param file
	 * @param profileId
	 * @return
	 * @throws IOException
	 * @throws MultipartFileIsEmptyException
	 * @throws EmployeeCustomException
	 */
	@PostMapping("esslite/user/file-upload")
	public ResponseEntity<EmployeeFileUploadResponse> fileUpload(@RequestParam("files") MultipartFile[] files,
			String profileId) throws IOException, MultipartFileIsEmptyException, EmployeeCustomException {
		String fileUpload = employeeRegistrationService.fileUpload(files, profileId);
		
		logger.debug(DEBUG);
		
		if (fileUpload != null) {
			return new ResponseEntity<>(new EmployeeFileUploadResponse(false, FILE_UPLOADED), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new EmployeeFileUploadResponse(true, NOT_UPLOADED), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This method is used to download the files from the local storage and retruns
	 * the url of the path
	 * 
	 * @param fileDownloadwrapper
	 * @return URL - url of the path
	 * @throws IOException
	 * @throws EmployeeCustomException
	 */
	@PostMapping("esslite/user/file-download")
	public ResponseEntity<FileDownloadResponse> fileDownload(
			@Valid @RequestBody FileDownloadWrapper fileDownloadwrapper) throws IOException, EmployeeCustomException {
		URL fileDownload = employeeRegistrationService.fileDownload(fileDownloadwrapper);
		
		logger.debug(DEBUG);
		
		if (fileDownload != null) {
			return new ResponseEntity<>(new FileDownloadResponse(false, FILE_DOWNLOAD, fileDownload), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new FileDownloadResponse(true, DOWNLOAD_FAILED, null), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This method is used to authenticate the user using the login credentails.
	 * 
	 * @param authenticationRequest
	 * @return
	 * @throws DisabledException
	 * @throws BadCredentialsException
	 * @throws UnauthorizedException
	 * @throws InvalidCredentailException
	 */
	@PostMapping("esslite/user/authenticate")
	public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws DisabledException, BadCredentialsException, UnauthorizedException, InvalidCredentailException {
		AuthenticationFunctionWrapper authentication = employeeRegistrationService
				.authentication(authenticationRequest);
		
		logger.debug(DEBUG);
		
		if (authentication != null) {
			return new ResponseEntity<>(new JwtResponse(false, LOGGED_IN, authentication.getEmployeeId()),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new JwtResponse(true, FAIL_TO_LOGIN, null), HttpStatus.BAD_REQUEST);
		}

	}// end of createAuthenticationToken()

	/**
	 * This method is used to updated the password in the case of password is
	 * forgotten. Here we store the password by encrypt using passwordEncrypt
	 * 
	 * @param forgotPassword
	 * @return
	 * @throws EmployeeCustomException
	 */
	@PostMapping("esslite/user/forgot-password")
	public ResponseEntity<ForgortPasswordResponse> userPasswordUpdate(@Valid @RequestBody ForgotPassword forgotPassword)
			throws EmployeeCustomException {
		EmployeeRegistration updatePassword = employeeRegistrationService.updatePassword(forgotPassword);
		
		logger.debug(DEBUG);
		
		if (updatePassword != null) {
			return new ResponseEntity<>(new ForgortPasswordResponse(false, PASSWORD_UPDATED, forgotPassword.getEmail()),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ForgortPasswordResponse(true, FAIL_TO_UPDAT_PASSWORD, null),
					HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 
	 * @param employeeId
	 * @return
	 * @throws EmployeeCustomException
	 */
	@GetMapping("esslite/user/profile-details")
	public ResponseEntity<ProfileDetailsResponse> getProfileDetails(String employeeid) throws EmployeeCustomException {
		ProfileDetailsWrapper updatePassword = employeeRegistrationService.getProfileDetails(employeeid);
		
		logger.debug(DEBUG);
		
		if (updatePassword != null) {
			return new ResponseEntity<>(new ProfileDetailsResponse(false, PROFILE_DETAILS_SUCCESS, updatePassword),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new ProfileDetailsResponse(true, PROFILE_DETAILS_FAIL, null),
					HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("esslite/user/send-otp")
	public ResponseEntity<SendingOTPResponse> sendOtpToMail(@RequestBody SendOtp otp) throws EmployeeCustomException{
		SendOtp otpSent = employeeRegistrationService.getOtp(otp);
		
		logger.debug(DEBUG);
		
		SendingOTPResponse sendingOTPResponse = new SendingOTPResponse();
		
		if(otpSent != null) {
			sendingOTPResponse.setError(false);
			sendingOTPResponse.setMessage(PROFILE_DETAILS_SUCCESS);
			sendingOTPResponse.setData(otpSent);
			return new ResponseEntity<>(sendingOTPResponse, HttpStatus.OK);
		}else {
			sendingOTPResponse.setError(false);
			sendingOTPResponse.setMessage(PROFILE_DETAILS_SUCCESS);
			sendingOTPResponse.setData(otpSent);
			return new ResponseEntity<>(sendingOTPResponse, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("esslite/user/verify-otp")
	public ResponseEntity<VerifyOtpResponse> verifyOtp(@RequestBody TempOtp otp) throws EmployeeCustomException{
		boolean otpSent = employeeRegistrationService.verifyOtp(otp);
		
		logger.debug(DEBUG);
		
		VerifyOtpResponse verifyOtpResponse = new VerifyOtpResponse();
		
		if(otpSent) {
			verifyOtpResponse.setError(false);
			verifyOtpResponse.setMessage(VALID_OTP);
			verifyOtpResponse.setData(otp.getMailId());
			return new ResponseEntity<>(verifyOtpResponse, HttpStatus.OK);
		}else {
			verifyOtpResponse.setError(false);
			verifyOtpResponse.setMessage(INVALID_OTP);
			verifyOtpResponse.setData(otp.getMailId());
			return new ResponseEntity<>(verifyOtpResponse, HttpStatus.OK);
		}
		
	}

}// end of authenticate()
