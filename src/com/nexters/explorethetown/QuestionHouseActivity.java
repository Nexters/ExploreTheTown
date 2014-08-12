package com.nexters.explorethetown;

import org.json.JSONArray;

import com.nexters.custom.CityName;
import com.nexters.explorethetown.R;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class QuestionHouseActivity extends ActionBarActivity {

	
	int questionNumber;
	boolean[] answerchk;
	
	String neighbor_resultStr;
	JSONArray houseResult;
	String top30Cds;
	String firstCond;
	CityName selectCityName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        answerchk = new boolean[9];
        
        Intent iIntent = getIntent();
        neighbor_resultStr = iIntent.getStringExtra("NEIGHBOR_RESULT");
        top30Cds = iIntent.getStringExtra("YELLOW_TOP30_CD");
        firstCond = iIntent.getStringExtra("FIRST_COND");
		selectCityName = (CityName) iIntent.getSerializableExtra("SELECT_CITY");
 
		houseResult = new JSONArray();
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
				int endchk = 0 ;
				for(int i = 0 ; i < 5 ; i++){
					if(answerchk[i] == true){
						endchk++;
					}
				}
				if(endchk == 0){
					Toast toast = Toast.makeText(QuestionHouseActivity.this, "Please select answer", Toast.LENGTH_LONG);
					toast.show();
				}else{
					for(int i = 0 ; i < 5  ;i++){
						if(answerchk[i] ){
							String tmpStr = "house_0"+(i+1);
							houseResult.put(tmpStr);
							Log.i("house put",tmpStr);
						}
					}
					questionNumber++;
					setImgsDefault();

				}
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
				int endchk = 0 ;
				for(int i = 0 ; i < 3 ; i++){
					if(answerchk[i] == true){
						endchk++;
					}
				}
				if(endchk == 0){
					Toast toast = Toast.makeText(QuestionHouseActivity.this, "Please select answer", Toast.LENGTH_LONG);
					toast.show();
				}else{
					for(int i = 0 ; i < 3  ;i++){
						if(answerchk[i] ){
							String tmpStr = "year_0"+i;
							houseResult.put(tmpStr);
							Log.i("house put",tmpStr);
						}
					}
					questionNumber++;
					setImgsDefault();

				}
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
				int endchk = 0 ;
				for(int i = 0 ; i < 9 ; i++){
					if(answerchk[i] == true){
						endchk++;
					}
				}
				if(endchk == 0){
					Toast toast = Toast.makeText(QuestionHouseActivity.this, "Please select answer", Toast.LENGTH_LONG);
					toast.show();
				}else{
					for(int i = 0 ; i < 9  ;i++){
						if(answerchk[i] ){
							String tmpStr = "area_0"+(i+1);
							houseResult.put(tmpStr);
							Log.i("house put",tmpStr);
						}
					}
					Intent iIntent = new Intent(QuestionHouseActivity.this,
							ResultActivity.class);
					iIntent.putExtra("NEIGHBOR_RESULT", neighbor_resultStr);
					iIntent.putExtra("HOUSE_RESULT", houseResult.toString());
					iIntent.putExtra("YELLOW_TOP30_CD", top30Cds);
					iIntent.putExtra("FIRST_COND", firstCond);
					iIntent.putExtra("SELECT_CITY", selectCityName);
					Log.i("neighbor check",neighbor_resultStr);
					Log.i("house check",houseResult.toString());
					Log.i("con check",firstCond);
					startActivity(iIntent);

				}

			}
		});
		
		
	}
	@Override
	public void onBackPressed() {
		this.finish();
	}
}
