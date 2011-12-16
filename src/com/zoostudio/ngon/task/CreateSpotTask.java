package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class CreateSpotTask extends RestClientTask {
	
	private String	mName;
	private double	mLat;
	private double	mLong;
	
	public CreateSpotTask(String name, double latitude, double longitude) {
		mName = name;
		mLat = latitude;
		mLong = longitude;
	}
	
	@Override public void doExecute() {
		restClient.addParam("name", mName);
		restClient.addParam("lat", mLat);
		restClient.addParam("long", mLong);
		
		restClient.put("/spot");
	}
	
}
