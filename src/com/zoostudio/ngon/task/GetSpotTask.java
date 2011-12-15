package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class GetSpotTask extends RestClientTask {
	
	private int	mSpotId;
	
	public GetSpotTask(int spot_id) {
		mSpotId = spot_id;
	}
	
	@Override public void doExecute() {
		restClient.addParam("spot_id", mSpotId);
		restClient.get("/spot");
	}
	
}
