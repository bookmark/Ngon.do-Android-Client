package com.zoostudio.ngon.ui;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.zoostudio.ngon.NgonActivity;
import com.zoostudio.ngon.R;
import com.zoostudio.ngon.utils.NgonLocation;
import com.zoostudio.ngon.utils.NgonLocation.LocationResult;
import com.zoostudio.restclient.NgonRestClient;

public class CreateSpot extends NgonActivity implements OnClickListener {
	
	private EditText	 etSpotName;
	private EditText	 etSpotAddress;
	private EditText	 etLocation;
	private Button	     btnCreateSpot;
	private NgonLocation	loc;
	private double	     lng;
	private double	     lat;
	
	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_create_spot);
		
		initControls();
		initVariables();
	}
	
	void initControls() {
		etSpotName = (EditText) findViewById(R.id.spot_name);
		etSpotAddress = (EditText) findViewById(R.id.spot_address);
		etLocation = (EditText) findViewById(R.id.spot_location);
		btnCreateSpot = (Button) findViewById(R.id.create_spot);
	}
	
	void initVariables() {
		loc = new NgonLocation();
		loc.getLocation(this, new LocationResult() {
			
			@Override public void gotLocation(Location location) {
				btnCreateSpot.setOnClickListener(CreateSpot.this);
				lng = location.getLongitude();
				lat = location.getLatitude();
				
//				etLocation.setText(lng + " - " + lat);
			}
		});
	}
	
	@Override public void onClick(View v) {
		switch (v.getId()) {
			case R.id.create_spot:
				final NgonRestClient client = new NgonRestClient("", "");
				client.addParam("name", etSpotName.getText().toString());
				client.addParam("address", etSpotAddress.getText().toString());
				client.addParam("long", lng + "");
				client.addParam("lat", lat + "");
				client.put("/spot");
				
				try {
					JSONObject data = new JSONObject(client.getResponse());
					int spot_id = Integer.parseInt(data.get("spot_id").toString());
					
					Intent checkinIntent = new Intent(this, Checkin.class);
					checkinIntent.putExtra("spot_id", spot_id);
					
					startActivity(checkinIntent);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
				break;
		}
	}
}
