package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class CreateDishTask extends RestClientTask {
	
	private String	mDishName;
	
	public CreateDishTask(String dish_name) {
		mDishName = dish_name;
	}
	
	@Override public void doExecute() {
		restClient.addParam("name", mDishName);
		restClient.put("/dish");
	}
	
}
