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
	ImageView img_question;
	ImageView btn_yes;
	ImageView btn_no;
	ImageView btn_next;
	
	int townState;
	
	boolean townClicked[] = new boolean[6];
	
	boolean town_picnic_isClicked[] = new boolean[0];
	boolean town_perfect_isClicked[] = new boolean[0];
	boolean town_health_isClicked[] = new boolean[2];
	boolean town_learning_isClicked[] = new boolean[4];
	boolean town_nothing_isClicked[] = new boolean[1];
	boolean town_young_isClicked[] = new boolean[3];
	
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
		//check each array to see which town is selected. Then show questions according to that.
		//--> 
		

		img_question = (ImageView)findViewById(R.id.d_question_health);
		//btn_next = (ImageView)findViewById(R.id.imgBtn_D_Next);
		
		init(); //initializing the answer arrays for each town
		
		townState = checkNextTown(0);
		int questionNumber = 1;
		
		switch(townState) {
		case 0:
			//townHealth(); --> setContentView, change questions as it goes.
			//change the question
			System.out.println("It's here");
			town_health_setOnClickListener();
			System.out.println("chekced2");
		case 1:
			System.out.println("Got to case1");
			checkNextTown(1);
			break;
		case 2:
			checkNextTown(2);
			break;
		case 3:
			checkNextTown(3);
			break;
		case 4:
			checkNextTown(4);
			break;
		case 5:
			checkNextTown(5);
			break;
		}

		
	}
	
	public void town_health_setOnClickListener(){
		final ImageButton answer_mountain = (ImageButton)findViewById(R.id.d_answer_mountain);
		answer_mountain.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(!town_health_isClicked[0]){
					answer_mountain.setImageResource(R.drawable.d_answer_health_1_1_pressed);
					town_health_isClicked[0] = true;
				}else{
					answer_mountain.setImageResource(R.drawable.d_answer_health_1_1);
					town_health_isClicked[0] = false;
				}
			}
		});
		
		final ImageButton answer_park = (ImageButton)findViewById(R.id.d_answer_park);
		answer_park.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				if(!town_health_isClicked[1]){
					answer_park.setImageResource(R.drawable.d_answer_health_1_2_pressed);
					town_health_isClicked[1] = true;
				}else{
					answer_park.setImageResource(R.drawable.d_answer_health_1_2);
					town_health_isClicked[1] = false;
				}
			}
		});
		
		final ImageButton btn_next = (ImageButton)findViewById(R.id.d_Next);
		btn_next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//move to the next question if there is one.
				townState = checkNextTown(0);
				System.out.println("Checked");
			}
		});
		
	}
	
	
	/*
	 * Initializing the result boolean arrays
	 */
	public void init() {
		for(int i = 0 ; i < 2 ; i++){
			town_health_isClicked[i] = false;
		}
		for(int i=0; i<3; i++) {
			town_young_isClicked[i] = false;
		}
		for(int i=0; i<1; i++) {
			town_nothing_isClicked[i] = false;
		}
		for(int i=0; i<4; i++) {
			town_learning_isClicked[i] = false;
		}
	}
	
	public int checkNextTown(int townNum) {
		int nextTown = 6;
		for (int i = townNum; i < 6; i++) {
			if(townClicked[i] == true) {
				System.out.println("Next town!: " + i);
				nextTown = i;
				break;
			}
		}
		
		return nextTown;
	}
	
	
	
}
