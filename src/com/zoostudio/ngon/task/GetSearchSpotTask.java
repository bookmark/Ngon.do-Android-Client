package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class GetSearchSpotTask extends RestClientTask {
	
	private String	mName;
	private int	   mLimit;
	private double	mLong;
	private double	mLat;
	
	public GetSearchSpotTask(String name, double latitude, double longitude) {
		this(name, latitude, longitude, 0);
	}
	
	public GetSearchSpotTask(String name, double latitude, double longitude, int limit) {
		mName = name;
		mLimit = limit;
		mLong = longitude;
		mLat = latitude;
	}
	
	@Override public void doExecute() {
		restClient.addParam("long", mLong);
		restClient.addParam("lat", mLat);
		restClient.addParam("name", mName);
		if (mLimit > 0) {
			restClient.addParam("limit", mLimit);
		}
		
		restClient.get("/spot/search");
	}
	
}
