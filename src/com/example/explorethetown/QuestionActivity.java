package com.example.explorethetown;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class QuestionActivity extends ActionBarActivity{
	int questionNumber;
	Question question;
	ImageView titleImg;
	ImageView bodyImg;
	ImageButton[] answerImgBtn;
	ImageButton nextBtn;
	
	int townState;
	
	boolean townClicked[] = new boolean[6];
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);

		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		// get Intent 
		Intent intent = getIntent();
		townClicked = intent.getBooleanArrayExtra("CLICKEDQUESTION");
		System.out.println(townClicked);
		
		question = new Question(41);
	
		answerImgBtn = new ImageButton[4];
		titleImg = (ImageView)findViewById(R.id.img_question_title);
		bodyImg = (ImageView)findViewById(R.id.img_question_body);
		answerImgBtn[0] = (ImageButton)findViewById(R.id.img_question_answer1);
		answerImgBtn[1] = (ImageButton)findViewById(R.id.img_question_answer2);
		answerImgBtn[2] = (ImageButton)findViewById(R.id.img_question_answer3);
		answerImgBtn[3] = (ImageButton)findViewById(R.id.img_question_answer4);
		nextBtn = (ImageButton)findViewById(R.id.img_question_next);
		
		setOnClickListener();
		showImgs();
	}
	
	public void setOnClickListener(){
		answerImgBtn[0].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!question.isEndQuestion()){
					question.nextQuestion();
					showImgs();
				}
			}
		});
		
		answerImgBtn[1].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		answerImgBtn[2].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		answerImgBtn[3].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		nextBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(question.isEndQuestion()){
					Intent iIntent = new Intent(QuestionActivity.this,AnswerMapActivity.class);
					startActivity(iIntent);
				}else{
					question.nextQuestion();
					showImgs();
				}
			}
		});
		
	}
	// show images
	private void showImgs(){
		int[] answerImgs = question.getAnswerImgs();
		
		for (int i = 0 ; i < 4 ; i++){
			if(answerImgs[i] == 0){
				answerImgBtn[i].setVisibility(View.INVISIBLE);
			}else{
				answerImgBtn[i].setVisibility(View.VISIBLE);
				answerImgBtn[i].setImageResource(answerImgs[i]);
			}
		}
		
		titleImg.setImageResource(question.getTitleImg());
		bodyImg.setImageResource(question.getBodyImg());
		
	}
	

	
	
	
	
	
	
}
