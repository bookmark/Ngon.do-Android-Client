package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class UnlikeTask extends RestClientTask {
	
	private int	mSpotId;
	
	public UnlikeTask(int spot_id) {
		mSpotId = spot_id;
	}
	
	@Override public void doExecute() {
		restClient.addParam("spot_id", mSpotId);
		restClient.delete("/spot/like");
	}
	
}
