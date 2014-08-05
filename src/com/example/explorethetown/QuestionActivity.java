package com.example.explorethetown;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

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
		
		
		//TODO �떎�쓬 臾몄젣濡� �꽆�뼱媛� �븣 �깉濡� �씠誘몄��뙆�씪�쓣 遺덈윭以섏빞 �븯�뒗�뜲 紐뉖쾲�쑝濡� �꽆�뼱媛붾뒗吏� keep track �븯�뒗 寃껋씠 �븘
		
		
		
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
			
			//moveToBack(); // �뮘濡쒓�湲�
			break;
		case R.id.imgBtn_D_Next:
			//PromptDialog("�젙留� �궘�젣�븯�떆寃좎뒿�땲源�?");
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
