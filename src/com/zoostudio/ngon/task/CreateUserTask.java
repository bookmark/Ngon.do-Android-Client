package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class CreateUserTask extends RestClientTask {
	
	private String	mUsername;
	private String	mPassword;
	private String	mPhone;
	private String	mEmail;
	
	public CreateUserTask(String username, String password) {
		this(username, password, "");
	}
	
	public CreateUserTask(String username, String password, String email) {
		mUsername = username;
		mPassword = password;
		mEmail = email;
	}
	
	@Override public void doExecute() {
		restClient.addParam("username", mUsername);
		restClient.addParam("password", mPassword);
		restClient.addParam("phone", mPhone);
		if (false == mEmail.equals("")) {
			restClient.addParam("email", mEmail);
		}
		
		restClient.put("/user");
	}
	
}
