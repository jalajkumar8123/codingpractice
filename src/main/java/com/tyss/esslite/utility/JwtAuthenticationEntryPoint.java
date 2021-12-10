package com.tyss.esslite.utility;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * This class is the entry point of our JWT authentication process. If the Login
 * credentials are wrong then the error is handled here as Unauthorized.
 *
 */

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = 4105973981685506639L;

	/**
	 * SC_UNAUTHORIZED - Status code (401) indicating that the request requires HTTP
	 * authentication.
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");

	}// end of commence()

}// end of class
