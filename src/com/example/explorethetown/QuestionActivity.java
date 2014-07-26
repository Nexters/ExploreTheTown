package com.example.explorethetown;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;

public class QuestionActivity extends ActionBarActivity{
	int questionNumber;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		
		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		questionNumber = 0;
		
		setOnClickListenerQ1();
	}
	
	public void setOnClickListenerQ1(){
		ImageButton imgBtnYES = (ImageButton)findViewById(R.id.imgBtnQ1_1_YES);
		ImageButton imgBtnNO = (ImageButton)findViewById(R.id.imgBtnQ1_1_NO);
		
		imgBtnYES.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
			}
		});
		
		imgBtnNO.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
			}
		});
	}

}
