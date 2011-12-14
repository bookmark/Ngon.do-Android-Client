package com.zoostudio.restclient;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;

public abstract class RestClientTask extends
		AsyncTask<Context, Void, JSONObject> {

	public NgonRestClient restClient;
	private OnPostExecuteDelegate onPostExecuteDelegate;
	private OnPreExecuteDelegate onPreExecuteDelegate;

	public RestClientTask() {
		String username = "";
		String password = "";
		restClient = new NgonRestClient(username, password);
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		if (null != onPreExecuteDelegate) {
			onPreExecuteDelegate.action();
		}
	}

	@Override
	protected void onPostExecute(JSONObject result) {
		super.onPostExecute(result);
		if (null != onPostExecuteDelegate) {
			onPostExecuteDelegate.action(result);
		}
	}

	public JSONObject getResult() {
		if (null == restClient) {
			return null;
		}

		JSONObject data;
		try {
			data = new JSONObject(restClient.getResponse());
			return data;
		} catch (JSONException e) {
			return null;
		}
	}

	public void setOnPostExecuteDelegate(OnPostExecuteDelegate delegate) {
		onPostExecuteDelegate = delegate;
	}

	public void setOnPreExecuteDelegate(OnPreExecuteDelegate delegate) {
		onPreExecuteDelegate = delegate;
	}

	public interface OnPostExecuteDelegate {
		public void action(JSONObject result);
	}

	public interface OnPreExecuteDelegate {
		public void action();
	}
}
