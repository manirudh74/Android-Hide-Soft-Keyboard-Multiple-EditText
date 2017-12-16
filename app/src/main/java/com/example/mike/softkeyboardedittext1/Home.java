package com.example.mike.softkeyboardedittext1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home extends AppCompatActivity {
	private static final String TAG = "Home";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		// Reference EditTexts
		EditText editText1 = findViewById(R.id.editText1);
		EditText editText2 = findViewById(R.id.editText2);
		EditText editText3 = findViewById(R.id.editText3);
		EditText editText4 = findViewById(R.id.editText4);
		EditText editText5 = findViewById(R.id.editText5);
		EditText editText6 = findViewById(R.id.editText6);
		
		// Add EditTexts to list
		final List<EditText> editTexts = new ArrayList<EditText>();
		editTexts.addAll(Arrays.asList(
				editText1, 
				editText2, 
				editText3, 
				editText4, 
				editText5, 
				editText6
		));
		
		// Add a focus change listener to each EditText
		for (final EditText editText : editTexts) {
			editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
				@Override
				public void onFocusChange(View v, boolean hasFocus) {
					// If focus is changed, only hide the keyboard if the focus wasn't changed to an EditText
					int focusCount = 0;
					// This is probably bad, but so is the Soft Keyboard in general.
					for (EditText editText : editTexts) {
						if (editText.hasFocus()) {
							focusCount++;
						}
						if (focusCount == 1) {
							hasFocus = true;
							break;
						}
					}
					if (!hasFocus) {
						hideKeyboard(v);
						Log.d(TAG, "onFocusChange: Keyboard Hidden");
					}
					
				}
			});
		}
		
	} // onCreate
	
	public void hideKeyboard(View view) {
		InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
		inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}
}
