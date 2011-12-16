package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class GetNearbySpotTask extends RestClientTask {
	
	private int	   mLimit;
	private int	   mAccLvl;
	private double	mLong;
	private double	mLat;
	
	public GetNearbySpotTask(double latitude, double longitude) {
		this(latitude, longitude, 0);
	}
	
	public GetNearbySpotTask(double latitude, double longitude, int limit) {
		this(latitude, longitude, limit, 2);
	}
	
	public GetNearbySpotTask(double latitude, double longitude, int limit, int accuracy_level) {
		mLimit = limit;
		mAccLvl = accuracy_level;
		mLong = longitude;
		mLat = latitude;
	}
	
	@Override public void doExecute() {
		restClient.addParam("long", mLong);
		restClient.addParam("lat", mLat);
		
		if (mLimit > 0) {
			restClient.addParam("limit", mLimit);
		}
		
		if (mAccLvl > 0) {
			restClient.addParam("max_distance", mAccLvl);
		}
		
		restClient.get("/spot/nearby");
	}
}
