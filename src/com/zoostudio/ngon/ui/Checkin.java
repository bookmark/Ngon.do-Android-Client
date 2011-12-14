package com.zoostudio.ngon.ui;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zoostudio.ngon.NgonActivity;
import com.zoostudio.ngon.R;
import com.zoostudio.ngon.task.WriteReviewTask;
import com.zoostudio.restclient.NgonRestClient;
import com.zoostudio.restclient.RestClientTask.OnPostExecuteDelegate;

public class Checkin extends NgonActivity implements OnClickListener {

	private EditText etWriteReview;
	private Button btnUploadPhoto;
	private Button btnCheckin;

	private int spot_id = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_checkin);

		Bundle extras = getIntent().getExtras();

		if (extras != null) {
			spot_id = extras.getInt("spot_id");

			Toast.makeText(this, "Spot: " + spot_id, Toast.LENGTH_LONG).show();
		}

		initControls();
		initVariables();
	}

	void initControls() {
		etWriteReview = (EditText) findViewById(R.id.write_review);
		btnUploadPhoto = (Button) findViewById(R.id.upload_photo);
		btnCheckin = (Button) findViewById(R.id.checkin);
	}

	void initVariables() {
		btnUploadPhoto.setOnClickListener(this);
		btnCheckin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.upload_photo:

			break;
		case R.id.checkin:

			if (etWriteReview.getText().length() > 0) {
				String review = etWriteReview.getText().toString();
			}

			final NgonRestClient client = new NgonRestClient("", "");
			client.addParam("spot_id", spot_id);
			client.put("/spot/checkin");

			if (etWriteReview.getText().length() > 0) {
				String review = etWriteReview.getText().toString();

				WriteReviewTask reviewTask = new WriteReviewTask(spot_id,
						review);

				reviewTask
						.setOnPostExecuteDelegate(new OnPostExecuteDelegate() {

							@Override
							public void action(JSONObject result) {
								try {
									Toast.makeText(
											Checkin.this,
											result.getBoolean("status") ? "true"
													: "false",
											Toast.LENGTH_LONG).show();
								} catch (JSONException e) {
									e.printStackTrace();
								}
							}
						});

				reviewTask.execute();
			}

			break;
		}
	}
}
