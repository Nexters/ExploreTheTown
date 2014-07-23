package com.example.explorethetown;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;

public class Question1Activity extends ActionBarActivity{
	int questionNumber;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question1_1);
		
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
				setContentView(R.layout.activity_question1_2);
				setOnClickListenerQ2();
			}
		});
		
		imgBtnNO.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				setContentView(R.layout.activity_question1_2);
				setOnClickListenerQ2();
			}
		});
	}

	
	public void setOnClickListenerQ2(){
		ImageButton imgBtnYES = (ImageButton)findViewById(R.id.imgBtnQ1_2_YES);
		ImageButton imgBtnNO = (ImageButton)findViewById(R.id.imgBtnQ1_2_NO);
		
		imgBtnYES.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				setContentView(R.layout.activity_question1_3);
				setOnClickListenerQ3();
			}
		});
		
		imgBtnNO.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				setContentView(R.layout.activity_question1_3);
				setOnClickListenerQ3();
			}
		});
	}
	
	public void setOnClickListenerQ3(){
		ImageButton imgBtnYES = (ImageButton)findViewById(R.id.imgBtnQ1_3_YES);
		ImageButton imgBtnNO = (ImageButton)findViewById(R.id.imgBtnQ1_3_NO);
		
		imgBtnYES.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				setContentView(R.layout.activity_question1_4);
				setOnClickListenerQ4();
			}
		});
		
		imgBtnNO.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				setContentView(R.layout.activity_question1_4);
				setOnClickListenerQ4();
			}
		});
	}
	
	public void setOnClickListenerQ4(){
		ImageButton imgBtnYES = (ImageButton)findViewById(R.id.imgBtnQ1_4_YES);
		ImageButton imgBtnNO = (ImageButton)findViewById(R.id.imgBtnQ1_4_NO);
		
		imgBtnYES.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				setContentView(R.layout.activity_question1_5);
				setOnClickListenerQ5();
			}
		});
		
		imgBtnNO.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				setContentView(R.layout.activity_question1_5);
				setOnClickListenerQ5();
			}
		});
	}
	
	public void setOnClickListenerQ5(){
		ImageButton imgBtnYES = (ImageButton)findViewById(R.id.imgBtnQ1_5_YES);
		ImageButton imgBtnNO = (ImageButton)findViewById(R.id.imgBtnQ1_5_NO);
		
		imgBtnYES.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				Intent iIntent = new Intent(Question1Activity.this, AnswerMapActivity.class);
				startActivity(iIntent);
				finish();

			}
		});
		
		imgBtnNO.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				Intent iIntent = new Intent(Question1Activity.this, AnswerMapActivity.class);
				startActivity(iIntent);
				finish();
			}
		});
	}
}
