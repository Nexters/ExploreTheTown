package com.nexters.explorethetown;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.nexters.explorethetown.R;
import com.nexters.custom.CityName;
import com.nexters.custom.QuestionType;

public class QuestionActivity extends ActionBarActivity{
	int questionNumber;
	Question question;
	ImageView titleImg;
	ImageView progressImg;
	ImageView bodyImg;
	ImageButton[] answerImgBtn;					
	ImageButton nextBtn;
	
	int beforeClickAnswerNum;					// YES OR NO�뿉�꽌 �젙�떟 泥댄겕�븳嫄� �븯�뒗嫄�
	boolean chkYesOrNo;							// 정답 체크여부 
	boolean[] beforeClickAnswerList;			// Check Box 諛⑹떇�뿉�꽌 �젙�떟 泥댄겕�븳嫄� �븯�뒗嫄�
	int townState;			
	QuestionType nowQuestionType;				// YES OR NO / Check Box
	boolean townClicked[] = new boolean[6];		// get clicked town list
	int clickedTownsInt;							// �룄�떆 �삎�깭 �꽑�깮�븳嫄� ���옣�빐�넃�뒗 蹂��닔
	int finishTownsInt;							// 이미 설문 완료한거 저장
	int nowTownsInt;							// 현재 진행중인거 저장
	
	CityName selectCityName;					// 앞에서 선택한 지역명 받아옴
	boolean[] lessAnswerChk = new boolean[4];		

	Handler handler;
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
		selectCityName = (CityName)intent.getSerializableExtra("SELECT_CITY");
		townClicked = intent.getBooleanArrayExtra("CLICKEDQUESTION");
		clickedTownsInt = 0;
		finishTownsInt = 0;
		for(int i = 5 ; i >= 0 ; i--){
			if(townClicked[i]){
				clickedTownsInt = (clickedTownsInt)*10+(i+1);
			}
		}
		// init
		for(int i = 0 ; i < 4 ; i++){
			lessAnswerChk[i] = false;
		}
				
		nowTownsInt = clickedTownsInt%10;
		question = new Question((clickedTownsInt%10) * 10 +1);
		clickedTownsInt /= 10;
	
		answerImgBtn = new ImageButton[4];
		titleImg = (ImageView)findViewById(R.id.img_question_title);
		bodyImg = (ImageView)findViewById(R.id.img_question_body);
		answerImgBtn[0] = (ImageButton)findViewById(R.id.imgBtn_question_answer1);
		answerImgBtn[1] = (ImageButton)findViewById(R.id.img_question_answer2);
		answerImgBtn[2] = (ImageButton)findViewById(R.id.img_question_answer3);
		answerImgBtn[3] = (ImageButton)findViewById(R.id.img_question_answer4);
		nextBtn = (ImageButton)findViewById(R.id.img_question_next);
		progressImg = (ImageView)findViewById(R.id.img_question_progressView);
		
		chkYesOrNo = false;
		beforeClickAnswerList = new boolean[4];
		setInit();
		
		setOnClickListener();
		showImgs();
	}
	
	public void setOnClickListener(){
		answerImgBtn[0].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(nowQuestionType == QuestionType.YESORNO){
					chkYesOrNo = true;
					if(beforeClickAnswerNum != -1){
						answerImgBtn[beforeClickAnswerNum].setSelected(false);
					}
					answerImgBtn[0].setSelected(true);
					beforeClickAnswerNum = 0;
				}else if(nowQuestionType == QuestionType.CHECKBOX){
					if((question.getQuestionNumber() == 61) && lessAnswerChk[0]){
						Toast toast = Toast.makeText(QuestionActivity.this, "You can't click this asnwer", Toast.LENGTH_SHORT);
						toast.show();
					}else if(beforeClickAnswerList[0]){
						answerImgBtn[0].setSelected(false);
						beforeClickAnswerList[0] = false;
					}else{
						answerImgBtn[0].setSelected(true);
						beforeClickAnswerList[0] = true;
					}
				}
			}
		});
		
		answerImgBtn[1].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(nowQuestionType == QuestionType.YESORNO){
					chkYesOrNo = false;
					if(beforeClickAnswerNum != -1){
						answerImgBtn[beforeClickAnswerNum].setSelected(false);
					}
					answerImgBtn[1].setSelected(true);
					beforeClickAnswerNum = 1;
				}else if(nowQuestionType == QuestionType.CHECKBOX){
					if((question.getQuestionNumber() == 61) && lessAnswerChk[1]){
						Toast toast = Toast.makeText(QuestionActivity.this, "You can't click this asnwer", Toast.LENGTH_SHORT);
						toast.show();
					}else if(beforeClickAnswerList[1]){
						answerImgBtn[1].setSelected(false);
						beforeClickAnswerList[1] = false;
					}else{
						answerImgBtn[1].setSelected(true);
						beforeClickAnswerList[1] = true;
					}
				}
			}
		});
		
		answerImgBtn[2].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(nowQuestionType == QuestionType.YESORNO){
					if(beforeClickAnswerNum != -1){
						answerImgBtn[beforeClickAnswerNum].setSelected(false);
					}
					answerImgBtn[2].setSelected(true);
					beforeClickAnswerNum = 2;
				}else if(nowQuestionType == QuestionType.CHECKBOX){
					if((question.getQuestionNumber() == 61) && lessAnswerChk[2]){
						Toast toast = Toast.makeText(QuestionActivity.this, "You can't click this asnwer", Toast.LENGTH_SHORT);
						toast.show();
					}else if(beforeClickAnswerList[2]){
						answerImgBtn[2].setSelected(false);
						beforeClickAnswerList[2] = false;
					}else{
						answerImgBtn[2].setSelected(true);
						beforeClickAnswerList[2] = true;
					}
				}
			}
		});
		answerImgBtn[3].setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(nowQuestionType == QuestionType.YESORNO){
					if(beforeClickAnswerNum != -1){
						answerImgBtn[beforeClickAnswerNum].setSelected(false);
					}
					answerImgBtn[3].setSelected(true);
					beforeClickAnswerNum = 3;
				}else if(nowQuestionType == QuestionType.CHECKBOX){
					if((question.getQuestionNumber() == 61) && lessAnswerChk[3]){
						Toast toast = Toast.makeText(QuestionActivity.this, "You can't click this asnwer", Toast.LENGTH_SHORT);
						toast.show();
					}else if(beforeClickAnswerList[3]){
						answerImgBtn[3].setSelected(false);
						beforeClickAnswerList[3] = false;
					}else{
						answerImgBtn[3].setSelected(true);
						beforeClickAnswerList[3] = true;
					}
				}
			}
		});
		
		nextBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if((nowQuestionType == QuestionType.YESORNO) && (beforeClickAnswerNum == -1)){
					Toast toast = Toast.makeText(QuestionActivity.this, "질문에 답해주세요!", Toast.LENGTH_LONG);
					toast.show();
				}else{
					switch(nowQuestionType){
					case YESORNO:
						question.setAnswerCode(chkYesOrNo);
						checkLessAnswer();
						break;
					case CHECKBOX:
						question.setAnswerCode(beforeClickAnswerList);
						checkLessAnswer();
					}
					
					if(question.isEndQuestion()){
						if(clickedTownsInt == 0){
							if(question.answersCodeSize() != 0){
							Intent iIntent = new Intent(QuestionActivity.this,FirstAnswerMapActivity.class);
							iIntent.putExtra("SELECT_CITY", selectCityName);
							iIntent.putExtra("SELECT_RESULT", question.answersCode.toString());
							iIntent.putExtra("NO_SELECT_RESULT",question.answersNoCode.toString());
							startActivity(iIntent);
							finish();
							}else{
						        // Change Page After Few Secs
						        handler = new Handler();
						        handler.postDelayed(noAnswerGoBack, 1000);		// change page after 1 sec
						        Toast toast = Toast.makeText(QuestionActivity.this, "위 조건은 모든 동네가 해당됩니다. \n다시 답변해주세요.", Toast.LENGTH_LONG);
							    toast.show();
								
							}
						}else{
							finishTownsInt = finishTownsInt*10+nowTownsInt;
							question.setQuestionNumber((clickedTownsInt%10)*10+1);
							nowTownsInt = clickedTownsInt%10;
							clickedTownsInt /= 10;
							showImgs();
						}
					}else{
						question.nextQuestion();
						showImgs();
					}
				}
			}
		});
		

		
	}
	
	// after 4 secs go back
	Runnable noAnswerGoBack = new Runnable(){
		@Override
		public void run(){
	        finish();
		}
	};
	
	
	public void checkLessAnswer(){
		if(question.getQuestionNumber() == 51){
			if(chkYesOrNo){
				lessAnswerChk[3] = true;
			}
		}else if(question.getQuestionNumber() == 53){
			if(chkYesOrNo){
				lessAnswerChk[0] = true;
			}
		}else if(question.getQuestionNumber() == 42){
			if(beforeClickAnswerList[2]){
				lessAnswerChk[1] = true;
			}
		}else if(question.getQuestionNumber() == 43){
			boolean chk = false;
			for(int i = 0 ; i < 4 ; i++){
				if(beforeClickAnswerList[i]){
					chk = true;
					break;
				}
			}
			if(chk){
				lessAnswerChk[2] = true;
			}
		}
	}
	// show images
	private void showImgs(){
		setInit();
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
		progressImg.setImageResource(question.getTopProgressImg());
		
	}
	
	private void setInit(){
		nowQuestionType = question.getQuestionType();
		for(int i = 0 ; i < 4 ; i++){
			answerImgBtn[i].setSelected(false);
			beforeClickAnswerList[i] = false;
		}
		beforeClickAnswerNum = -1;
	}

	@Override
	public void onBackPressed() {
		this.finish();
		//townClicked
		//clickedTownInt

		
	}

	
	
	
	
	
}
