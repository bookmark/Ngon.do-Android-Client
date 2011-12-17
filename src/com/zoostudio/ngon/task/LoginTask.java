package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class LoginTask extends RestClientTask {
	
	private String	mUsername;
	private String	mPassword;
	
	public LoginTask(String username, String password) {
		mUsername = username;
		mPassword = password;
	}
	
	@Override public void doExecute() {
		restClient.addParam("username", mUsername);
		restClient.addParam("password", mPassword);
		restClient.get("/user/login");
	}
	
}
