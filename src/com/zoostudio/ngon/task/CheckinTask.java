package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class CheckinTask extends RestClientTask {
	
	private int	  mSpotId;
	private int[]	mDishesId;
	
	public CheckinTask(int spot_id) {
		this(spot_id, new int[] {});
	}
	
	public CheckinTask(int spot_id, int[] dishes_id) {
		mSpotId = spot_id;
		mDishesId = dishes_id;
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
		
		restClient.put("/spot/checkin");
	}
	
}
