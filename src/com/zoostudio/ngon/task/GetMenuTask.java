package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class GetMenuTask extends RestClientTask {
	
	private int	mSpotId;
	
	public GetMenuTask(int spot_id) {
		mSpotId = spot_id;
	}
	
	@Override public void doExecute() {
		restClient.addParam("spot_id", mSpotId);
		restClient.get("/spot/menu");
	}
	
}
