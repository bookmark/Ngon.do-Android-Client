package com.zoostudio.ngon.ui;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import com.zoostudio.ngon.NgonActivity;
import com.zoostudio.ngon.R;

public class Home extends NgonActivity implements LocationListener {
	private TextView	tvLocation;
	
	/** Called when the activity is first created. */
	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 500.0f,
		        this);
		
		tvLocation = (TextView) findViewById(R.id.location);
		
		startActivity(new Intent(this, Register.class));
	}
	
	@Override public void onLocationChanged(Location location) {
		if (location != null) {
			double lat = location.getLatitude();
			double lng = location.getLongitude();
				
				tvLocation.setText(lat + " - " + lng);
		}
	}
	
	@Override public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	
	@Override public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}
	
	@Override public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}