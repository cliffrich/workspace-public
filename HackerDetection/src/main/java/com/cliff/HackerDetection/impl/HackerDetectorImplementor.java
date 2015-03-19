package com.cliff.HackerDetection.impl;

import com.cliff.HackerDetection.HackerDetector;

/**
 * Implementation for HackerDetector interface
 *
 */
public class HackerDetectorImplementor implements HackerDetector{
	enum SignInStatus {SIGNIN_SUCCESS, SIGNIN_FAILURE};
	private static final int NUMBER_OF_FAILED_LOGINS = 5;
	
	public String parseLine(String line) {
		LoginLog loginLog = parseLogLine(line);
		if(loginLog.getSignInStatus().equals(SignInStatus.SIGNIN_SUCCESS))
			return null;
		if(findNumberOfFailedAttemptsInLast5Minutes(loginLog.getUserName()) == NUMBER_OF_FAILED_LOGINS)
			return 
		
		return null;
	}
	private int findNumberOfFailedAttemptsInLast5Minutes(String userName){
		// Remove user data
		return 1;
	}
	private LoginLog parseLogLine(String line){
		
		return new LoginLog();
	}
	
	class LoginLog{
		private String ipAddress, dateSignin, userName;
		private SignInStatus signInStatus;
		
		public LoginLog(){
		}
		public LoginLog(String ipAddress, String dateSignin, String userName, SignInStatus signInStatus) {
			this.ipAddress = ipAddress;
			this.dateSignin = dateSignin;
			this.userName = userName;
			this.signInStatus = signInStatus;
		}

		public String getIpAddress() {
			return ipAddress;
		}

		public String getDateSignin() {
			return dateSignin;
		}

		public String getUserName() {
			return userName;
		}

		public SignInStatus getSignInStatus() {
			return signInStatus;
		}
	}
}
