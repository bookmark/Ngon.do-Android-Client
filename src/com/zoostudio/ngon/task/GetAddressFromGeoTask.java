package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class GetAddressFromGeoTask extends RestClientTask {
	
	private double	mLong;
	private double	mLat;
	
	public GetAddressFromGeoTask(double latitude, double longitude) {
		mLong = longitude;
		mLat = latitude;
	}
	
	@Override public void doExecute() {
		restClient.addParam("long", mLong);
		restClient.addParam("lat", mLat);
		
		restClient.get("/spot/geodecode");
	}
	
}
