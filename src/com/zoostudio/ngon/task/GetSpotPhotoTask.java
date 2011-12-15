package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class GetSpotPhotoTask extends RestClientTask {
	
	private int	mSpotId;
	private int	mLimit;
	
	public GetSpotPhotoTask(int spot_id) {
		this(spot_id, 0);
	}
	
	public GetSpotPhotoTask(int spot_id, int limit) {
		mSpotId = spot_id;
		mLimit = limit;
	}
	
	@Override public void doExecute() {
		restClient.addParam("spot_id", mSpotId);
		if (mLimit > 0) restClient.addParam("limit", mLimit);
		
		restClient.get("/spot/photo");
	}
	
}
