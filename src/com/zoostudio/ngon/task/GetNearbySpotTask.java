package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class GetNearbySpotTask extends RestClientTask {
	
	private int	   mLimit;
	private int	   mAccLvl;
	private double	mLong;
	private double	mLat;
	
	public GetNearbySpotTask() {
		this(0);
	}
	
	public GetNearbySpotTask(int limit) {
		this(limit, 2);
	}
	
	public GetNearbySpotTask(int limit, int accuracy_level) {
		mLimit = limit;
		mAccLvl = accuracy_level;
		mLong = (double) 0;
		mLat = (double) 0;
	}
	
	@Override public void doExecute() {
		restClient.addParam("long", mLong);
		restClient.addParam("lat", mLat);
		
		if (mLimit > 0) {
			restClient.addParam("limit", mLimit);
		}
		
		if(mAccLvl >0){
			restClient.addParam("max_distance", mAccLvl);
		}
		
		restClient.get("/spot/nearby");
	}
}
