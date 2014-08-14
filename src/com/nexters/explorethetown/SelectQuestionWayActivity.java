/**
 * ������ ����, ����� �����ϴ� ������
 */
package com.nexters.explorethetown;

import com.nexters.custom.CityName;
import com.nexters.explorethetown.R;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class SelectQuestionWayActivity extends ActionBarActivity {

	
	CityName selectCityName;
	boolean isClicked[] = new boolean[6];
	ImageView imgCenterBig ;
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_way);
		
		Intent iIntent = getIntent();
		selectCityName = (CityName)iIntent.getSerializableExtra("SELECT_CITY");
		
		
		imgCenterBig = (ImageView)findViewById(R.id.img_question_way_center);
		// init
		for(int i = 0 ; i < 6 ; i++){
			isClicked[i] = false;
		}
		
		

		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		setOnClickListener();
		
	}
	
	public void setOnClickListener(){
		final ImageButton imageButton1 = (ImageButton)findViewById(R.id.imgBtn_Question1);
		
		imageButton1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(!isClicked[0]){
					imageButton1.setImageResource(R.drawable.c_btn_picnic_pressed);
					isClicked[0] = true;
					imgCenterBig.setImageResource(R.drawable.c_big_picnic);
				}else{
					imageButton1.setImageResource(R.drawable.c_btn_picnic);
					isClicked[0] = false;
					if (checkNothingClicked()){
						imgCenterBig.setImageResource(R.drawable.c_unselect);
					}
				}
			}
		});
		final ImageButton imageButton2 = (ImageButton)findViewById(R.id.imgBtn_Question2);
		
		imageButton2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(!isClicked[1]){
					imageButton2.setImageResource(R.drawable.c_btn_every_pressed);
					isClicked[1] = true;
					imgCenterBig.setImageResource(R.drawable.c_big_every);
				}else{
					imageButton2.setImageResource(R.drawable.c_btn_every);
					isClicked[1] = false;
					if (checkNothingClicked()){
						imgCenterBig.setImageResource(R.drawable.c_unselect);
					}
				}

			}
		});
		final ImageButton imageButton3 = (ImageButton)findViewById(R.id.imgBtn_Question3);
		
		imageButton3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(!isClicked[2]){
					imageButton3.setImageResource(R.drawable.c_btn_health_pressed);
					isClicked[2] = true;
					imgCenterBig.setImageResource(R.drawable.c_big_health);
				}else{
					imageButton3.setImageResource(R.drawable.c_btn_health);
					isClicked[2] = false;
					if (checkNothingClicked()){
						imgCenterBig.setImageResource(R.drawable.c_unselect);
					}
				}
			}
		});
		final ImageButton imageButton4 = (ImageButton)findViewById(R.id.imgBtn_Question4);
		
		imageButton4.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(!isClicked[3]){
					imageButton4.setImageResource(R.drawable.c_btn_study_pressed);
					isClicked[3] = true;
					imgCenterBig.setImageResource(R.drawable.c_big_study);
				}else{
					imageButton4.setImageResource(R.drawable.c_btn_study);
					isClicked[3] = false;
					if (checkNothingClicked()){
						imgCenterBig.setImageResource(R.drawable.c_unselect);
					}
				}
			}
		});
		final ImageButton imageButton5 = (ImageButton)findViewById(R.id.imgBtn_Question5);
		
		imageButton5.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(!isClicked[4]){
					imageButton5.setImageResource(R.drawable.c_btn_young_pressed);
					isClicked[4] = true;
					imgCenterBig.setImageResource(R.drawable.c_big_young);
				}else{
					imageButton5.setImageResource(R.drawable.c_btn_young);
					isClicked[4] = false;
					if (checkNothingClicked()){
						imgCenterBig.setImageResource(R.drawable.c_unselect);
					}
				}
			}
		});
		final ImageButton imageButton6 = (ImageButton)findViewById(R.id.imgBtn_Question6);
		imageButton6.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				if(!isClicked[5]){
					imageButton6.setImageResource(R.drawable.c_btn_less_pressed);
					isClicked[5] = true;
					imgCenterBig.setImageResource(R.drawable.c_big_less);
				}else{
					imageButton6.setImageResource(R.drawable.c_btn_less);
					isClicked[5] = false;
					if (checkNothingClicked()){
						imgCenterBig.setImageResource(R.drawable.c_unselect);
					}
				}
				
			}
		});
		
		ImageButton goNextBtn = (ImageButton)findViewById(R.id.imgBtn_C_Next);
		goNextBtn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(checkNothingClicked()){
					Toast toast = Toast.makeText(SelectQuestionWayActivity.this, "Please select type", Toast.LENGTH_LONG);
					toast.show();
			
				}else{
					Intent iIntent = new Intent(SelectQuestionWayActivity.this, QuestionActivity.class);
					iIntent.putExtra("CLICKEDQUESTION", isClicked);
					iIntent.putExtra("SELECT_CITY", selectCityName);
					startActivity(iIntent);
					//finish();
				}
			}
		});
	}
	
	private boolean checkNothingClicked(){
		int chk = 0;
		for(int i = 0 ; i < 6 ; i++){
			if(isClicked[i]){
				chk++;
			}
		}
		
		if(chk == 0){
			return true;
		}
		return false;
	}
	@Override
	public void onBackPressed() {
		this.finish();
	}
}
