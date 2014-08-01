package com.example.explorethetown;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class QuestionActivity extends ActionBarActivity{
	int questionNumber;
	ImageView img_question;
	ImageView btn_yes;
	ImageView btn_no;
	ImageView btn_next;
	
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
		int qNum = 1;
		
		
		//question = new Question(qNum*10+1);

		img_question = (ImageView)findViewById(R.id.d_question_health);
		//btn_yes = (ImageView)findViewById(R.id.d_question_health_yes);
		//btn_no = (ImageView)findViewById(R.id.d_question_health_no);
		btn_next = (ImageView)findViewById(R.id.imgBtn_D_Next);
		
		
		// Set Image buttons click listener
		//initEvents();
		// set question view 
		//showQuestionView();
		
		
		//TODO 다음 문제로 넘어갈 때 새로 이미지파일을 불러줘야 하는데 몇번으로 넘어갔는지 keep track 하는 것이 필
		
		
		
	}
	
	/*
	private void initEvents() {
		btn_yes.setOnClickListener(this);
		btn_no.setOnClickListener(this);
		btn_next.setOnClickListener(this);
	} */
	/*
	public void onClick(View v) {
		switch (v.getId()) {
		//case R.id.d_question_health_yes:
			break;
		case R.id.d_question_health_no:
			
			//moveToBack(); // 뒤로가기
			break;
		case R.id.imgBtn_D_Next:
			//PromptDialog("정말 삭제하시겠습니까?");
			break;
		}
	}
	
*/
	
/*
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

	} */
	
}
