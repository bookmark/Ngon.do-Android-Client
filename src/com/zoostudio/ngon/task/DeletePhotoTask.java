package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class DeletePhotoTask extends RestClientTask {
	
	private int	mPhotoId;
	
	public DeletePhotoTask(int photo_id) {
		mPhotoId = photo_id;
	}
	
	@Override public void doExecute() {
		restClient.addParam("photo_id", mPhotoId);
		restClient.delete("/photo");
	}
	
}
