package com.tyss.esslite.services;

import static com.tyss.esslite.constants.EmployeeRegisterControllerConstant.*;
import static com.tyss.esslite.constants.PersonalConstants.ERROR;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.NotAcceptableStatusException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.tyss.esslite.dao.EmployeeDocumentsRepo;
import com.tyss.esslite.dao.EmployeeRegistrationRepository;
import com.tyss.esslite.dto.EmployeeDocuments;
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
import com.tyss.esslite.wrapper.CandidateDataWrapper;
import com.tyss.esslite.wrapper.EmployeeRegistrationWrapper;
import com.tyss.esslite.wrapper.FileDownloadWrapper;
import com.tyss.esslite.wrapper.ProfileDetailsWrapper;
import com.tyss.esslite.wrapper.SendOtp;
import com.tyss.esslite.wrapper.StoreProfileIdWrapper;
import com.tyss.esslite.wrapper.TempOtp;

@Service
public class EmployeeRegistrationServiceImpl implements EmployeeRegistrationService, UserDetailsService {

	Logger logger = LoggerFactory.getLogger(EmployeeRegistrationServiceImpl.class);
	
	@Value("${server.folder.path}")
	private String fileUploadPath;
	
	
	@Autowired
	private EmployeeRegistrationRepository employeeRegistrationRepository;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EmployeeDocumentsRepo employeeDocumentsRepo;
	
	private static final Integer EXPIRE_MINS = 1;

	private LoadingCache<String, Integer> otpCache;

	public EmployeeRegistrationServiceImpl() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					public Integer load(String key) {
						return 0;
					}
				});
	}

	/**
	 * This enables automatic dependency injection of AuthenticationManager
	 * interface. This object is used by methods in the JwtAuthenticationController
	 * to call the respective methods.
	 */
	@Autowired
	private AuthenticationManager authenticationManager;

	@Transactional
	@Override
	public EmployeeRegistration register(EmployeeRegistrationWrapper employeeRegistrationWrapper)
			throws EmployeeCustomException, EmployeeInsertNotFoundException,
			CandidateStatusOnboardingNotFoundException {
		EmployeeRegistration register = new EmployeeRegistration();
		try {
			EmployeeRegistration findByEmail = employeeRegistrationRepository
					.findByEmail(employeeRegistrationWrapper.getEmail());
			if (findByEmail != null) {
				throw new EmployeeInsertNotFoundException(MAIL_NOT_FOUND);
			}

			CandidateDataWrapper restCallFromHiringOnboardStatus = restCallFromHiringOnboardStatus(
					employeeRegistrationWrapper.getEmail());
			if (!restCallFromHiringOnboardStatus.getStatus().equals(ONBOARDED)) {
				throw new CandidateStatusOnboardingNotFoundException(USER_NOT_ONBOARDED);
			}
			register.setBatchName(employeeRegistrationWrapper.getBatchName());
			register.setPassword(bcryptEncoder.encode(employeeRegistrationWrapper.getPassword()));
			register.setEmail(employeeRegistrationWrapper.getEmail());
			register.setFirstName(employeeRegistrationWrapper.getFirstName());
			register.setLastName(employeeRegistrationWrapper.getLastName());
			register.setPrimaryContactNo(employeeRegistrationWrapper.getPrimaryContactNo());
			register.setEducation(employeeRegistrationWrapper.getEducation());
			register.setBusinessUnit(employeeRegistrationWrapper.getBusinessUnit());
			register.setJspidersBranch(employeeRegistrationWrapper.getJspidersBranch());
			register = employeeRegistrationRepository.save(register);
			
			
		    sendEmail(register.getEmail());
			

			register.setProfileId(register.getEmployeeId());
			register = employeeRegistrationRepository.save(register);

			StoreProfileIdWrapper storeProfileIdWrapper = new StoreProfileIdWrapper();
			storeProfileIdWrapper.setEmail(register.getEmail());
			storeProfileIdWrapper.setProfileId(register.getProfileId());
			storeProfileId(storeProfileIdWrapper);

		} catch (CandidateStatusOnboardingNotFoundException | EmployeeInsertNotFoundException status) {
			logger.error(ERROR);
			throw status;
		}  catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(USER_NOT_REGISTERED);
		}
		return register;
	}

	public CandidateDataWrapper restCallFromHiringOnboardStatus(String email) {
		String uri = GET_URI_ONBOARD + email;
		return restTemplate.getForObject(uri, CandidateDataWrapper.class);
	}

	public StoreProfileIdWrapper storeProfileId(StoreProfileIdWrapper storeProfileIdWrapper) throws URISyntaxException {
		String uri = POST_URI_PROFILEID;
		URI url = new URI(uri);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		Map<String, String> map = new HashMap<>();
		map.put(EMAIL, storeProfileIdWrapper.getEmail());
		map.put(PROFILE_ID, storeProfileIdWrapper.getProfileId());
		@SuppressWarnings("rawtypes")
		HttpEntity<Map> requestEntity = new HttpEntity<>(map, headers);
		ResponseEntity<StoreProfileIdWrapper> exchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity,
				StoreProfileIdWrapper.class);
		return exchange.getBody();
	}

	/**
	 * sendEmailId method is used when the admin approves the login credentials are
	 * email to the supplier by using those credentials the supplier can login into
	 * the application
	 * 
	 * @return login credentials
	 */
	@Override
	public String sendEmail(String recipientEmail) throws MessagingException, UnsupportedEncodingException {
		try {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setFrom("contact@esslite.com", "esslite.com");
			helper.setTo(recipientEmail);
			String subject = "Greetings";
			String content = "Welcome to TechnoElevate";
			helper.setSubject(subject);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (Exception e) {
			logger.error(ERROR);
			throw new SendFailedException(MAIL_NOT_SENT);
		}
		return MAIL_SENT_SUCCESS;
	}// end of sendEmailId()

	/**
	 * This service is used to upload a file and store that file into the folder.
	 * And that path will be stored in the database in the form of String. The name
	 * of the Entity which used to store is EmployeeRegistration
	 * 
	 * @throws IOException
	 * @throws MultipartFileIsEmptyException
	 * @throws EmployeeCustomException
	 */
	@Override
	public String fileUpload(MultipartFile[] multipartfile, String profileId)
			throws IOException, MultipartFileIsEmptyException, EmployeeCustomException {
		FileOutputStream fileWriter = null;
		try {
           
			for (MultipartFile multipartFile2 : multipartfile) {

				EmployeeRegistration findByProfileId = employeeRegistrationRepository.findByEmployeeId(profileId);

				if (findByProfileId == null) {
					throw new EmployeeCustomException(PROFILEID_NOT_FOUND);
				}

				if (multipartFile2.isEmpty()) {
					throw new MultipartFileIsEmptyException(EMPTY_FILE_MESSAGE);
				}

				File path = new File(fileUploadPath+profileId+FILE);
				if (!path.exists()) {
					path.mkdirs();
				}
				String inDir = fileUploadPath + profileId + FILE + "/"
						+ multipartFile2.getOriginalFilename();
				fileWriter = new FileOutputStream(new File(inDir));
				fileWriter.write(multipartFile2.getBytes());

				EmployeeDocuments employeeDocuments = new EmployeeDocuments();
				employeeDocuments.setFileName(multipartFile2.getOriginalFilename());
				employeeDocuments.setImageUrl("http://10.10.20.18:8095"+inDir);
				employeeDocuments.setEmployeeId(profileId);
			    employeeDocumentsRepo.save(employeeDocuments);
			}

		} catch (EmployeeCustomException | MultipartFileIsEmptyException e) {
			logger.error(ERROR);
			throw e;
		}finally {
			if(fileWriter != null) {
			try {
				fileWriter.close();
			} catch (IOException e) {
				logger.error(ERROR);
				e.printStackTrace();
			}
			}
		}
		return SUCCESS;
	}

	@Override
	public URL fileDownload(FileDownloadWrapper fileDownload) throws IOException, EmployeeCustomException {
		URL url = null;
		try {
			EmployeeRegistration findByProfileId = employeeRegistrationRepository
					.findByEmployeeId(fileDownload.getProfileId());

			if (findByProfileId == null) {
				throw new EmployeeCustomException(PROFILEID_NOT_FOUND);
			}

			String path = fileUploadPath + fileDownload.getProfileId() + FILE
					+ fileDownload.getFileName();
			File folder = new File(path);
			url = folder.toURI().toURL();
		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(PROFILEID_NOT_FOUND);
		}
		return url;
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		EmployeeRegistration employeeLogin = null;
		try {
			String value = ".";
			if (userName.contains(value)) {
				employeeLogin = employeeRegistrationRepository.findByEmail(userName);
			} else {
				employeeLogin = employeeRegistrationRepository.findByEmployeeId(userName);
			}

			if (employeeLogin == null) {
				throw new UsernameNotFoundException(USER_NOT_FOUND + " :" + userName);
			}

			if (employeeLogin.getPassword() == null) {
				throw new NotAcceptableStatusException(SET_PASSWORD_MESSAGE);
			}

		} catch (NotAcceptableStatusException ex) {
			logger.error(ERROR);
			throw ex;
		} catch (Exception e) {
			logger.error(ERROR);
			throw new UsernameNotFoundException(USER_NOT_FOUND + " :" + userName);
		}
		return new org.springframework.security.core.userdetails.User(employeeLogin.getEmail(),
				employeeLogin.getPassword(), getAuthority());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Set getAuthority() {
		Set authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_"));
		return authorities;
	}// end of getAuthority()

	@Override
	public AuthenticationFunctionWrapper authentication(JwtRequest authenticationRequest)
			throws DisabledException, BadCredentialsException, UnauthorizedException, InvalidCredentailException {
		AuthenticationFunctionWrapper authFunctionWrapper = new AuthenticationFunctionWrapper();
		EmployeeRegistration findByEmail = null;
		try {
			authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
			UserDetails loadUserByUsername = loadUserByUsername(authenticationRequest.getUserName());

			authFunctionWrapper.setUserDetails(loadUserByUsername);

			String value = ".";
			if (authenticationRequest.getUserName().contains(value)) {
				findByEmail = employeeRegistrationRepository.findByEmail(authenticationRequest.getUserName());
				authFunctionWrapper.setEmployeeId(findByEmail.getProfileId());
			} else {
				findByEmail = employeeRegistrationRepository.findByEmployeeId(authenticationRequest.getUserName());
				authFunctionWrapper.setEmployeeId(findByEmail.getProfileId());
			}

		} catch (InvalidCredentailException e) {
			logger.error(ERROR);
			throw new InvalidCredentailException(INVALID_CREDENTIALS);
		}
		return authFunctionWrapper;
	}

	private void authenticate(String userName, String password)
			throws DisabledException, BadCredentialsException, UnauthorizedException, InvalidCredentailException {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		} catch (DisabledException e) {
			throw new UnauthorizedException(USER_NOT_FOUND);
		} catch (BadCredentialsException e) {
			throw new InvalidCredentailException(INVALID_CREDENTIALS);
		}
	}

	@Override
	public EmployeeRegistration updatePassword(ForgotPassword forgotPassword) throws EmployeeCustomException {
		EmployeeRegistration findByEmail = null;
		try {
			findByEmail = employeeRegistrationRepository.findByEmployeeId(forgotPassword.getEmployeeId());
			if (!findByEmail.getEmail().equals(forgotPassword.getEmail())) {
				throw new EmployeeCustomException(INVALID_EMAIL);
			} else {
				findByEmail.setPassword(bcryptEncoder.encode(forgotPassword.getPassword()));
				findByEmail = employeeRegistrationRepository.save(findByEmail);
			}

		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(INVALID_PROFILE_ID_OR_EMAILID);
		}
		return findByEmail;
	}

	@Override
	public ProfileDetailsWrapper getProfileDetails(String employeeId) throws EmployeeCustomException {
	    ProfileDetailsWrapper profileDetailsWrapper = new ProfileDetailsWrapper();
		try {
			EmployeeRegistration findByEmployeeid = employeeRegistrationRepository.findByEmployeeId(employeeId);
			
            if(findByEmployeeid != null) {
            	profileDetailsWrapper.setFirstName(findByEmployeeid.getFirstName());
            	profileDetailsWrapper.setLastName(findByEmployeeid.getLastName());
            	profileDetailsWrapper.setEmail(findByEmployeeid.getEmail());
            	profileDetailsWrapper.setPhoneNumber(findByEmployeeid.getPrimaryContactNo());
            	profileDetailsWrapper.setDesignation(findByEmployeeid.getDesignation());
            	profileDetailsWrapper.setEmployeeId(employeeId);
            	profileDetailsWrapper.setTechnology(findByEmployeeid.getTechnology());
            }
		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(INVALID_PROFILE_ID);
		}
		return profileDetailsWrapper;
	}
	
	/*
	 * sendOtpToMail method is used to send otp to the user mail. otpGenerate() is
	 * use to generate random 4 digit number as otp.
	 * 
	 * @return login credentials
	 */
	public String sendOtpToMail(String recipientEmail) throws MessagingException, UnsupportedEncodingException {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setFrom(CONTACT_US, CONTACT_US_NAME);
			helper.setTo(recipientEmail);
			String subject = ONE_TIME_PASSWORD;
			String content = "<p>Hello,</p>" + "<p>You requested for the otp </p>" + "<br>" + "otp: " + otpGenerate(recipientEmail);
			helper.setSubject(subject);

			helper.setText(content, true);

			mailSender.send(message);
		} catch (Exception e) {
			logger.error(ERROR);
			throw new SendFailedException(MAIL_NOT_SENT);
		}
		return SEND_MAIL;
	}// end of sendEmailId()

	/**
	 * otpGenerate method help us to generate the otp and send it to the registered
	 * mobile number through message It generates the 4 character random otp
	 * 
	 * @return msg i.e otp
	 * @throws NoSuchAlgorithmException
	 */
	public String otpGenerate(String key) {

		SecureRandom rand = new SecureRandom();
		int otp = rand.nextInt(10000);
		otpCache.put(key, otp);
		return  OTP_MESSAGE + otp + OTP_TIME_MESSAGE;

	}// end of otpGenerate()

	/**
	 * This method will send the otp to mail and mobile number
	 * 
	 * @param getOtp
	 * @return
	 * @throws EmployeeCustomException 
	 * @throws OtpNotSentException
	 */
	@Override
	public SendOtp getOtp(SendOtp otp) throws EmployeeCustomException{
	   SendOtp sendOtp = new SendOtp();
		try {	
			sendOtpToMail(otp.getMailId());
			sendOtp.setMailId(otp.getMailId());
		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(OTP_NOT_SENT);
		}
		return sendOtp;

	}

	@Override
	public boolean verifyOtp(TempOtp sms) throws EmployeeCustomException  {
		boolean result = true;
		try {
			Integer ifPresent = otpCache.getIfPresent(sms.getMailId());
			if (ifPresent == sms.getOtp()) {
				return result;
			} else {
				return !result;
			}
		} catch (Exception e) {
			logger.error(ERROR);
			throw new EmployeeCustomException(INVALID_OTP);
		}
	}
	
	
	
	
	
	

}
