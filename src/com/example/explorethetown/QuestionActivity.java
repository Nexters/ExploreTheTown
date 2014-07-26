package com.example.explorethetown;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class QuestionActivity extends ActionBarActivity{
	int questionNumber;
	ImageButton imgBtnYES;
	ImageButton imgBtnNO;
	ImageButton imgBtnNext;
	
	TextView questionText;
	
	Question question;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		
		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		// get Intent 
		Intent intent = getIntent();
		int qNum = intent.getExtras().getInt("NUM");
		
		
		question = new Question(qNum*10+1);

		imgBtnYES = (ImageButton)findViewById(R.id.imgBtnQ_YES);
		imgBtnNO = (ImageButton)findViewById(R.id.imgBtnQ_NO);
		imgBtnNext = (ImageButton)findViewById(R.id.imgBtnQ_Next);
		
		questionText = (TextView)findViewById(R.id.questionText);
		
		// Set Image buttons click listener
		setOnClickListener();
		// set question view 
		showQuestionView();
	}
	
	
	public void setOnClickListener(){
		
		imgBtnYES.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(question.isEndQuestion()){
					Intent iIntent = new Intent(QuestionActivity.this, AnswerMapActivity.class);
					startActivity(iIntent);
				}else{
					question.nextQuestion();
					showQuestionView();
				}
			}
		});
		
		imgBtnNO.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(question.isEndQuestion()){
					Intent iIntent = new Intent(QuestionActivity.this, AnswerMapActivity.class);
					startActivity(iIntent);
					
				}else{
					question.nextQuestion();
					showQuestionView();
				}
			}
		});
		imgBtnNext.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(question.isEndQuestion()){
					Intent iIntent = new Intent(QuestionActivity.this, AnswerMapActivity.class);
					startActivity(iIntent);
				}else{
					question.nextQuestion();
					showQuestionView();
				}
			}
		});
	}
	
	// show question view 
	public void showQuestionView(){
		questionText.setText(question.getQuestion());
		
		if(question.getQuestionType() == 0){
			// YES OR NO 
			setYesOrNoQuestionView();
		}else if(question.getQuestionType() == 1){
			setCheckBoxQuestionView();
		}
		
	}
	
	// if question view is Yes or NO then do this function
	public void setYesOrNoQuestionView(){
		imgBtnYES.setVisibility(View.VISIBLE);
		imgBtnNO.setVisibility(View.VISIBLE);
		imgBtnNext.setVisibility(View.INVISIBLE);
		
	}
	// if question view is Check Box then do this function
	public void setCheckBoxQuestionView(){
		imgBtnYES.setVisibility(View.INVISIBLE);
		imgBtnNO.setVisibility(View.INVISIBLE);
		imgBtnNext.setVisibility(View.VISIBLE);

	}
	
}
