package com.tyss.esslite.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.mail.MessagingException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.multipart.MultipartFile;

import com.tyss.esslite.dto.EmployeeRegistration;
import com.tyss.esslite.dto.ForgotPassword;
import com.tyss.esslite.dto.JwtRequest;
import com.tyss.esslite.exception.CandidateStatusOnboardingNotFoundException;
import com.tyss.esslite.exception.EmployeeCustomException;
import com.tyss.esslite.exception.EmployeeInsertNotFoundException;
import com.tyss.esslite.exception.InvalidCredentailException;
import com.tyss.esslite.exception.MultipartFileIsEmptyException;
import com.tyss.esslite.exception.UnauthorizedException;
import com.tyss.esslite.wrapper.AuthenticationFunctionWrapper;
import com.tyss.esslite.wrapper.EmployeeRegistrationWrapper;
import com.tyss.esslite.wrapper.FileDownloadWrapper;
import com.tyss.esslite.wrapper.ProfileDetailsWrapper;
import com.tyss.esslite.wrapper.SendOtp;
import com.tyss.esslite.wrapper.TempOtp;

public interface EmployeeRegistrationService {

	public EmployeeRegistration register(EmployeeRegistrationWrapper employeeRegistrationWrapper) throws EmployeeCustomException, EmployeeInsertNotFoundException, CandidateStatusOnboardingNotFoundException;

	public String sendEmail(String recipientEmail) throws MessagingException, UnsupportedEncodingException;

	public String fileUpload(MultipartFile[] file,String profileId) throws IOException, MultipartFileIsEmptyException, EmployeeCustomException;

	public URL fileDownload(FileDownloadWrapper downloadWrapper) throws IOException, EmployeeCustomException;

	public AuthenticationFunctionWrapper authentication(JwtRequest authenticationRequest)
			throws DisabledException, BadCredentialsException, UnauthorizedException, InvalidCredentailException;

	public EmployeeRegistration updatePassword(ForgotPassword forgotPassword) throws EmployeeCustomException;

	public ProfileDetailsWrapper getProfileDetails(String employeeId) throws EmployeeCustomException;

	public SendOtp getOtp(SendOtp Otp) throws EmployeeCustomException;

	public boolean verifyOtp(TempOtp sms) throws EmployeeCustomException;

}
