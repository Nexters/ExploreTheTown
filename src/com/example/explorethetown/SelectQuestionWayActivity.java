package com.example.explorethetown;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;

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
				iIntent.putExtra("NUM", 1);
				startActivity(iIntent);
			}
		});
		ImageButton imageButton2 = (ImageButton)findViewById(R.id.imgBtn_Question2);
		
		imageButton2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){

				Intent iIntent = new Intent(SelectQuestionWayActivity.this, QuestionActivity.class);
				iIntent.putExtra("NUM", 2);
				startActivity(iIntent);
			}
		});
		ImageButton imageButton3 = (ImageButton)findViewById(R.id.imgBtn_Question3);
		
		imageButton3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){

				Intent iIntent = new Intent(SelectQuestionWayActivity.this, QuestionActivity.class);
				iIntent.putExtra("NUM", 3);
				startActivity(iIntent);
			}
		});
		ImageButton imageButton4 = (ImageButton)findViewById(R.id.imgBtn_Question4);
		
		imageButton4.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){

				Intent iIntent = new Intent(SelectQuestionWayActivity.this, QuestionActivity.class);
				iIntent.putExtra("NUM", 4);
				startActivity(iIntent);
			}
		});
		ImageButton imageButton5 = (ImageButton)findViewById(R.id.imgBtn_Question5);
		
		imageButton5.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){

				Intent iIntent = new Intent(SelectQuestionWayActivity.this, QuestionActivity.class);
				iIntent.putExtra("NUM", 5);
				startActivity(iIntent);
			}
		});
	}
}
