package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class GetMeTask extends RestClientTask {
	
	@Override public void doExecute() {
		restClient.get("/user/me");
	}
	
}
