package com.zoostudio.ngon.task;

import org.json.JSONObject;

import android.content.Context;

import com.zoostudio.restclient.RestClientTask;

public class WriteReviewTask extends RestClientTask {
	private String mContent;
	private int mSpotId;

	public WriteReviewTask(int spot_id, String content) {
		mContent = content;
		mSpotId = spot_id;
	}

	@Override
	protected JSONObject doInBackground(Context... params) {
		restClient.addParam("content", mContent);
		restClient.addParam("spot_id", mSpotId);

		restClient.put("/review");
		return getResult();
	}
}
