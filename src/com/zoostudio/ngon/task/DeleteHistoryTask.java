package com.zoostudio.ngon.task;

import com.zoostudio.restclient.RestClientTask;

public class DeleteHistoryTask extends RestClientTask {
	
	private int mHistoryId;

	public DeleteHistoryTask(int history_id){
		mHistoryId = history_id;
	}
	
	@Override public void doExecute() {
		restClient.addParam("history_id", mHistoryId);
		restClient.delete("/history");
	}
	
}
