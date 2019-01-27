package com.intelli8.error;

import java.util.Date;

public class CustomError {

	private int statusCode;
	private String message;
	private Date timeStamp;
	
	public CustomError(){
		
	}

	public CustomError(int statusCode, String message, Date timeStamp) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
