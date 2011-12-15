package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class CreateReviewTask extends RestClientTask {
	private String	mContent;
	private int	   mSpotId;
	
	public CreateReviewTask(int spot_id, String content) {
		mContent = content;
		mSpotId = spot_id;
	}
	
	@Override public void doExecute() {
		restClient.addParam("content", mContent);
		restClient.addParam("spot_id", mSpotId);
		
		restClient.put("/review");
	}
}
