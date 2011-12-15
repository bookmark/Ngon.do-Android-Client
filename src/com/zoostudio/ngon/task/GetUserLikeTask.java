package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class GetUserLikeTask extends RestClientTask {
	
	private int	mUserId;
	private int	mLimit;
	
	public GetUserLikeTask(int user_id) {
		this(user_id, 0);
	}
	
	public GetUserLikeTask(int user_id, int limit) {
		mUserId = user_id;
		mLimit = limit;
	}
	
	@Override public void doExecute() {
		restClient.addParam("user_id", mUserId);
		if (mLimit > 0) {
			restClient.addParam("limit", mLimit);
		}
		
		restClient.get("/user/like");
	}
	
}
