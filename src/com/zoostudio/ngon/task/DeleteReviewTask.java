package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class DeleteReviewTask extends RestClientTask {
	
	private int	mReviewId;
	
	public DeleteReviewTask(int review_id) {
		mReviewId = review_id;
	}
	
	@Override public void doExecute() {
		restClient.addParam("review_id", mReviewId);
		restClient.delete("/review");
	}
	
}
