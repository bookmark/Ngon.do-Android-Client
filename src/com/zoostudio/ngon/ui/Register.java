package com.zoostudio.ngon.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zoostudio.ngon.NgonActivity;
import com.zoostudio.ngon.R;
import com.zoostudio.restclient.NgonRestClient;

public class Register extends NgonActivity {
	
	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_register);
		final NgonRestClient client = new NgonRestClient("", "");
		
		Button btnRegister = (Button) findViewById(R.id.register);
		btnRegister.setOnClickListener(new OnClickListener() {
			@Override public void onClick(View v) {
				client.addParam("username", ((EditText) findViewById(R.id.username)).getText().toString());
				client.addParam("password", ((EditText) findViewById(R.id.password)).getText().toString());
				client.put("/user");
				Toast.makeText(Register.this, client.getResponse(), Toast.LENGTH_LONG).show();
			}
		});
		
	}
}
