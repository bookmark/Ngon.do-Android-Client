package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class EditReviewTask extends RestClientTask {
	
	private int	   mReviewId;
	private String	mContent;
	
	public EditReviewTask(int review_id, String content) {
		mReviewId = review_id;
		mContent = content;
	}
	
	@Override public void doExecute() {
		restClient.addParam("review_id", mReviewId);
		restClient.addParam("content", mContent);
		restClient.post("/review");
	}
	
}
