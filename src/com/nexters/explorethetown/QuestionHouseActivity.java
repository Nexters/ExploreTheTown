package com.nexters.explorethetown;

import com.nexters.explorethetown.R;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class QuestionHouseActivity extends ActionBarActivity {

	
	int questionNumber;
	boolean[] answerchk;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        answerchk = new boolean[9];
        
        
		questionNumber = 0;
		setImgsDefault();
			
		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
	        	        
	}
	
	public void setImgsDefault(){
		
		for(int i = 0 ; i < 9 ; i++){
        	answerchk[i] = false;
        }
		if(questionNumber == 0){
			setContentView(R.layout.activity_question_house);
			ImageView titleImg = (ImageView)findViewById(R.id.img_question_house_body);
			titleImg.setImageResource(R.drawable.g_question_house_1);
			ImageButton[] answerImgBtn = new ImageButton[5];
			answerImgBtn[0] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer1);
			answerImgBtn[0].setImageResource(R.drawable.g_answer_house_1_1_btn);
			answerImgBtn[1] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer2);
			answerImgBtn[1].setImageResource(R.drawable.g_answer_house_1_2_btn);
			answerImgBtn[2] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3);
			answerImgBtn[2].setImageResource(R.drawable.g_answer_house_1_3_btn);
			answerImgBtn[3] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer4);
			answerImgBtn[3].setImageResource(R.drawable.g_answer_house_1_4_btn);
			answerImgBtn[4] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer5);
			answerImgBtn[4].setImageResource(R.drawable.g_answer_house_1_5_btn);
			
			setOnClickListenerFirst();
			
		}else if(questionNumber == 1){
			setContentView(R.layout.activity_question_house);
			ImageView titleImg = (ImageView)findViewById(R.id.img_question_house_body);
			titleImg.setImageResource(R.drawable.g_question_house_2);
			ImageButton[] answerImgBtn = new ImageButton[5];
			answerImgBtn[0] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer1);
			answerImgBtn[0].setImageResource(R.drawable.g_answer_house_2_1_btn);
			answerImgBtn[1] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer2);
			answerImgBtn[1].setImageResource(R.drawable.g_answer_house_2_2_btn);
			answerImgBtn[2] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3);
			answerImgBtn[2].setImageResource(R.drawable.g_answer_house_2_3_btn);
			answerImgBtn[3] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer4);
			answerImgBtn[3].setVisibility(View.INVISIBLE);
			answerImgBtn[4] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer5);
			answerImgBtn[4].setVisibility(View.INVISIBLE);
			
			setOnClickListenerSecond();
		}else if(questionNumber == 2){
			setContentView(R.layout.activity_question_house3);
			
			setOnClickListenerThird();
		}
	}
	
	public void setOnClickListenerFirst(){
		final ImageButton[] answerImgBtn = new ImageButton[5];
		answerImgBtn[0] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer1);
		answerImgBtn[0].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[0]){
					answerImgBtn[0].setSelected(false);
					answerchk[0] = false;
				}else{
					answerImgBtn[0].setSelected(true);
					answerchk[0] = true;
				}
			}
		});
		

		answerImgBtn[1] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer2);
		answerImgBtn[1].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[1]){
					answerImgBtn[1].setSelected(false);
					answerchk[1] = false;
				}else{
					answerImgBtn[1].setSelected(true);
					answerchk[1] = true;
				}
				
			}
		});
		

		answerImgBtn[2] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3);
		answerImgBtn[2].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[2]){
					answerImgBtn[2].setSelected(false);
					answerchk[2] = false;
				}else{
					answerImgBtn[2].setSelected(true);
					answerchk[2] = true;
				}
				
			}
		});
		

		answerImgBtn[3] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer4);
		answerImgBtn[3].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[3]){
					answerImgBtn[3].setSelected(false);
					answerchk[3] = false;
				}else{
					answerImgBtn[3].setSelected(true);
					answerchk[3] = true;
				}
				
			}
		});
		

		answerImgBtn[4] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer5);
		answerImgBtn[4].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[4]){
					answerImgBtn[4].setSelected(false);
					answerchk[4] = false;
				}else{
					answerImgBtn[4].setSelected(true);
					answerchk[4] = true;
				}
				
			}
		});
		
		Button imgBtnNext = (Button)findViewById(R.id.imgBtn_question_house_next);
		imgBtnNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				questionNumber++;
				setImgsDefault();
			}
		});
		
	}
	public void setOnClickListenerSecond(){
		final ImageButton[] answerImgBtn = new ImageButton[3];
		answerImgBtn[0] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer1);
		answerImgBtn[0].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[0]){
					answerImgBtn[0].setSelected(false);
					answerchk[0] = false;
				}else{
					answerImgBtn[0].setSelected(true);
					answerchk[0] = true;
				}
				
			}
		});
		

		answerImgBtn[1] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer2);
		answerImgBtn[1].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[1]){
					answerImgBtn[1].setSelected(false);
					answerchk[1] = false;
				}else{
					answerImgBtn[1].setSelected(true);
					answerchk[1] = true;
				}
				
			}
		});
		

		answerImgBtn[2] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3);
		answerImgBtn[2].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[2]){
					answerImgBtn[2].setSelected(false);
					answerchk[2] = false;
				}else{
					answerImgBtn[2].setSelected(true);
					answerchk[2] = true;
				}
				
			}
		});
		Button imgBtnNext = (Button)findViewById(R.id.imgBtn_question_house_next);
		imgBtnNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				questionNumber++;
				setImgsDefault();
			}
		});
		
	}
	public void setOnClickListenerThird(){
		final ImageButton[] answerImgBtn = new ImageButton[9];
		answerImgBtn[0] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3_1);
		answerImgBtn[0].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[0]){
					answerImgBtn[0].setSelected(false);
					answerchk[0] = false;
				}else{
					answerImgBtn[0].setSelected(true);
					answerchk[0] = true;
				}
				
			}
		});
		

		answerImgBtn[1] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3_2);
		answerImgBtn[1].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[1]){
					answerImgBtn[1].setSelected(false);
					answerchk[1] = false;
				}else{
					answerImgBtn[1].setSelected(true);
					answerchk[1] = true;
				}
				
			}
		});
		

		answerImgBtn[2] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3_3);
		answerImgBtn[2].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[2]){
					answerImgBtn[2].setSelected(false);
					answerchk[2] = false;
				}else{
					answerImgBtn[2].setSelected(true);
					answerchk[2] = true;
				}
				
			}
		});
		

		answerImgBtn[3] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3_4);
		answerImgBtn[3].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[3]){
					answerImgBtn[3].setSelected(false);
					answerchk[3] = false;
				}else{
					answerImgBtn[3].setSelected(true);
					answerchk[3] = true;
				}
				
			}
		});
		

		answerImgBtn[4] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3_5);
		answerImgBtn[4].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[4]){
					answerImgBtn[4].setSelected(false);
					answerchk[4] = false;
				}else{
					answerImgBtn[4].setSelected(true);
					answerchk[4] = true;
				}
				
			}
		});
		
		answerImgBtn[5] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3_6);
		answerImgBtn[5].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[5]){
					answerImgBtn[5].setSelected(false);
					answerchk[5] = false;
				}else{
					answerImgBtn[5].setSelected(true);
					answerchk[5] = true;
				}
				
			}
		});
		
		answerImgBtn[6] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3_7);
		answerImgBtn[6].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[6]){
					answerImgBtn[6].setSelected(false);
					answerchk[6] = false;
				}else{
					answerImgBtn[6].setSelected(true);
					answerchk[6] = true;
				}
				
			}
		});
		
		answerImgBtn[7] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3_8);
		answerImgBtn[7].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[7]){
					answerImgBtn[7].setSelected(false);
					answerchk[7] = false;
				}else{
					answerImgBtn[7].setSelected(true);
					answerchk[7] = true;
				}
				
			}
		});
		
		answerImgBtn[8] = (ImageButton)findViewById(R.id.imgBtn_question_house_answer3_9);
		answerImgBtn[8].setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(answerchk[8]){
					answerImgBtn[8].setSelected(false);
					answerchk[8] = false;
				}else{
					answerImgBtn[8].setSelected(true);
					answerchk[8] = true;
				}
				
			}
		});
		
		Button imgBtnNext = (Button)findViewById(R.id.img_question_house_next_3);
		imgBtnNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent iIntent = new Intent(QuestionHouseActivity.this,
						ResultActivity.class);

				startActivity(iIntent);
			}
		});
		
		
	}
	@Override
	public void onBackPressed() {
		this.finish();
	}
}
