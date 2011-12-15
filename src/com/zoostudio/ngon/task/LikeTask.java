package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class LikeTask extends RestClientTask {
	
	private int	mSpotId;
	
	public LikeTask(int spot_id) {
		mSpotId = spot_id;
	}
	
	@Override public void doExecute() {
		restClient.addParam("spot_id", mSpotId);
		restClient.put("/spot/like");
	}
	
}
