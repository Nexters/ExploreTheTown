package com.example.explorethetown;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.custom.QuestionType;

public class QuestionActivity extends ActionBarActivity{
	int questionNumber;
	Question question;
	ImageView titleImg;
	ImageView progressImg;
	ImageView bodyImg;
	ImageButton[] answerImgBtn;					
	ImageButton nextBtn;
	
	int beforeClickAnswerNum;					// YES OR NO에서 정답 체크한거 하는거
	boolean[] beforeClickAnswerList;			// Check Box 방식에서 정답 체크한거 하는거
	int townState;			
	QuestionType nowQuestionType;				// YES OR NO / Check Box
	boolean townClicked[] = new boolean[6];		// get clicked town list
	int clickedTownsInt;							// 도시 형태 선택한거 저장해놓는 변수
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
		clickedTownsInt = 0;
		for(int i = 5 ; i >= 0 ; i--){
			if(townClicked[i]){
				clickedTownsInt = (clickedTownsInt)*10+(i+1);
			}
		}
		
		
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
					if(beforeClickAnswerNum != -1){
						answerImgBtn[beforeClickAnswerNum].setSelected(false);
					}
					answerImgBtn[0].setSelected(true);
					beforeClickAnswerNum = 0;
				}else if(nowQuestionType == QuestionType.CHECKBOX){
					if(beforeClickAnswerList[0]){
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
					if(beforeClickAnswerNum != -1){
						answerImgBtn[beforeClickAnswerNum].setSelected(false);
					}
					answerImgBtn[1].setSelected(true);
					beforeClickAnswerNum = 1;
				}else if(nowQuestionType == QuestionType.CHECKBOX){
					if(beforeClickAnswerList[1]){
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
					if(beforeClickAnswerList[2]){
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
					if(beforeClickAnswerList[3]){
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
					Toast toast = Toast.makeText(QuestionActivity.this, "Please select answer", Toast.LENGTH_LONG);
					toast.show();
				}else{
					if(question.isEndQuestion()){
						if(clickedTownsInt == 0){
							Intent iIntent = new Intent(QuestionActivity.this,AnswerMapActivity.class);
							startActivity(iIntent);
							finish();
						}else{
							question.setQuestionNumber((clickedTownsInt%10)*10+1);
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

	
	
	
	
	
	
}
