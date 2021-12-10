package com.tyss.esslite.dto;

import java.io.Serializable;

import lombok.NoArgsConstructor;

/**
 * This is a JwtRequest class which acts a wrapper for jwt request
 * 
 * @author TYSS
 *
 */
@NoArgsConstructor
public class JwtRequest implements Serializable {

	private static final long serialVersionUID = -3759536745845996071L;

	private String userName;

	private String password;

	private boolean isActive;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}// end of class
