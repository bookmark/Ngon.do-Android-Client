package org.bookmark.helper;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class ViewCore {
	public static void setShowHidePassword(final EditText input, final CheckBox button) {
		button.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override public void onCheckedChanged(final CompoundButton buttonView, final boolean isChecked) {
				if (!isChecked) input.setTransformationMethod(PasswordTransformationMethod
				        .getInstance());
				else input.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
			}
		});
	}
}
