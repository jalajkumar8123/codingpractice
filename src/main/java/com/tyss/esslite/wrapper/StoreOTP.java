package com.tyss.esslite.wrapper;

public class StoreOTP {
	

	private StoreOTP() {
		super();
	}

	private static int otp;

	public static int getOtp() {
		return otp;
	}

	public static void setOtp(int otp) {
		StoreOTP.otp = otp;
	}

	

}
