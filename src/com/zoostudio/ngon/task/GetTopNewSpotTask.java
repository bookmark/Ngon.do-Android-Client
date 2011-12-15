package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class GetTopNewSpotTask extends RestClientTask {
	
	private int	mSpotId;
	private int	mLimit;
	
	public GetTopNewSpotTask(int spot_id) {
		this(spot_id, 0);
	}
	
	public GetTopNewSpotTask(int spot_id, int limit) {
		mSpotId = spot_id;
		mLimit = limit;
	}
	
	@Override public void doExecute() {
		restClient.addParam("spot_id", mSpotId);
		if (mLimit > 0) restClient.addParam("limit", mLimit);
		
		restClient.get("/spot/topnew");
	}
		
}
