package com.example.explorethetown;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class QuestionHouseActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_house);
			
		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
	        
	        	        
	}

}
