package com.example.explorethetown;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SelectQuestionWayActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_way);
		
		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		setOnClickListener();
	}
	
	public void setOnClickListener(){
		ImageButton imageButton1 = (ImageButton)findViewById(R.id.imgBtn_Question1);
		
		imageButton1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){

				Intent iIntent = new Intent(SelectQuestionWayActivity.this, QuestionActivity.class);
				startActivity(iIntent);
				finish();
			}
		});
	}
}
