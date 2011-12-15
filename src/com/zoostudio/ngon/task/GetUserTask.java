package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class GetUserTask extends RestClientTask {
	
	private int	mUserId;
	
	public GetUserTask(int user_id) {
		mUserId = user_id;
	}
	
	@Override public void doExecute() {
		restClient.addParam("user_id", mUserId);
		restClient.get("/user");
	}
	
}
