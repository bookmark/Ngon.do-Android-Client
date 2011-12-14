package com.zoostudio.ngon.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zoostudio.ngon.NgonActivity;
import com.zoostudio.ngon.R;

public class Index extends NgonActivity implements OnClickListener {

	private Button btnRegister;
	private Button btnCreateSpot;
	private Button btnCheckin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_index);

		initControls();
		initVariables();
	}

	void initControls() {
		btnRegister = (Button) findViewById(R.id.register);
		btnCreateSpot = (Button) findViewById(R.id.create_spot);
		btnCheckin = (Button) findViewById(R.id.checkin);
	}

	void initVariables() {
		btnRegister.setOnClickListener(this);
		btnCreateSpot.setOnClickListener(this);
		btnCheckin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.create_spot:
			startActivity(new Intent(this, CreateSpot.class));
			break;
		case R.id.register:
			startActivity(new Intent(this, Register.class));
			break;
		case R.id.checkin:
			intent = new Intent(this, Checkin.class);
			intent.putExtra("spot_id", 1);
			startActivity(intent);
			break;
		}
	}
}
