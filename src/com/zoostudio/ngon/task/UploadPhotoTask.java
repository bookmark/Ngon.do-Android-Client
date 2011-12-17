package com.zoostudio.ngon.task;

import java.io.File;

import com.zoostudio.restclient.RestClientTask;

public class UploadPhotoTask extends RestClientTask {
	
	private int	  mSpotId;
	private int[]	mDishesId;
	private File	mPhoto;
	
	public UploadPhotoTask(int spot_id, File photo) {
		this(spot_id, photo, new int[] {});
	}
	
	public UploadPhotoTask(int spot_id, File photo, int[] dishes) {
		mSpotId = spot_id;
		mPhoto = photo;
		mDishesId = dishes;
	}
	
	@Override public void doExecute() {
		restClient.addParam("spot_id", mSpotId);
		if (mDishesId.length > 0) {
			String dishes = "";
			
			for (int dish : mDishesId) {
				dishes += dish + ",";
			}
			
			dishes = dishes.substring(0, dishes.length() - 1);
			
			restClient.addParam("dishes", dishes);
		}
		
		restClient.postMultiPart("/photo", "photo", mPhoto);
	}
	
}
