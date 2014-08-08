package com.example.explorethetown;
import com.example.custom.QuestionType;

public class Question {
	Question(){
		questionNumber = 0;
	}
	public Question(int QNUM){
		setQuestionNumber(QNUM);
	}
	public QuestionType getQuestionType(){
		switch(questionNumber){
		case 13:
		case 31:
		case 42:
		case 43:
		case 44:
		case 51:
			return QuestionType.CHECKBOX;
		default:
			return QuestionType.YESORNO;
		}
	}
	
	// Set Question Number and Set Question File Name
	public void setQuestionNumber(int QUESTIONNUMBER){
		questionNumber = QUESTIONNUMBER;
		question = String.format("Question %d_%d",questionNumber/10,questionNumber%10);
	}
	public String getQuestion(){
		return question;
	}
	public boolean isEndQuestion(){
		switch(questionNumber){
		case 13:
		case 22:
		case 32:
		case 44:
		case 51:
		case 63:
			return true;
		default:
				return false;
		}
	}
	
	public void nextQuestion(){
		setQuestionNumber(++questionNumber);
	}

	public int getQuestionNumber(){
		return questionNumber;
	}
	
	public int getTitleImg(){
		switch(questionNumber/10){
		case 1:
			return R.drawable.d_text_top_picnic;
		case 2:
		case 3:
			return R.drawable.d_text_top_health;
		case 4:
			return R.drawable.d_text_top_study;
		case 5:
			return R.drawable.d_text_top_less;
		case 6:
			return R.drawable.d_text_top_young;
		}
		return 0;
		
	}
	
	public int[] getAnswerImgs(){
		int[] returnArr = new int[4];
		returnArr[0] = getAnswer1Img();
		returnArr[1] = getAnswer2Img();
		returnArr[2] = getAnswer3Img();
		returnArr[3] = getAnswer4Img();
		return returnArr;
	}
	public int getBodyImg(){
		switch(questionNumber){
		case 11:
			return R.drawable.d_question_picnic_1;
		case 12:
			return R.drawable.d_question_picnic_2;
		case 13:
			return R.drawable.d_question_picnic_3;
		case 21:
		case 22:
		case 23:
		case 24:
		case 31:
			return R.drawable.d_question_health_1;
		case 32:
			return R.drawable.d_question_health_2;
		case 41:
			return R.drawable.d_question_study_1;
		case 42:
			return R.drawable.d_question_study_2;
		case 43:
			return R.drawable.d_question_study_3;
		case 44:
			return R.drawable.d_question_study_4;
		case 51:
			return R.drawable.d_question_less_1;
		case 61:
			return R.drawable.d_question_young_1;
		case 62:
			return R.drawable.d_question_young_2;
		case 63:
			return R.drawable.d_question_young_3;
		default:
			return 0;
		}
		
	}
	private int getAnswer1Img(){
		switch(questionNumber){
		case 11:
			return R.drawable.d_answer_picnic_1_1_btn;
		case 12:
			return R.drawable.d_answer_picnic_2_1_btn;
		case 13:
			return R.drawable.d_answer_picnic_3_1_btn;
		case 21:
		case 22:
		case 23:
		case 24:
		case 31:
			return R.drawable.d_answer_health_1_1_btn;
		case 32:
			return R.drawable.d_answer_health_2_1_btn;
		case 41:
			return R.drawable.d_answer_study_1_1_btn;
		case 42:
			return R.drawable.d_answer_study_2_1_btn;
		case 43:
			return R.drawable.d_answer_study_3_1_btn;
		case 44:
			return R.drawable.d_answer_study_4_1_btn;
		case 51:
			return R.drawable.d_answer_less_1_1_btn;
		case 61:
			return R.drawable.d_answer_young_1_1_btn;
		case 62:
			return R.drawable.d_answer_young_1_1_btn;
		case 63:
			return R.drawable.d_answer_young_1_1_btn;
		default:
			return 0;
		}
	}
	private int getAnswer2Img(){
		switch(questionNumber){
		case 11:
			return R.drawable.d_answer_picnic_1_2_btn;
		case 12:
			return R.drawable.d_answer_picnic_2_2_btn;
		case 13:
			return R.drawable.d_answer_picnic_3_2_btn;
		case 21:
		case 22:
		case 23:
		case 24:
		case 31:
			return R.drawable.d_answer_health_1_2_btn;
		case 32:
			return R.drawable.d_answer_health_2_2_btn;
		case 41:
			return R.drawable.d_answer_study_1_2_btn;
		case 42:
			return R.drawable.d_answer_study_2_2_btn;
		case 43:
			return R.drawable.d_answer_study_3_2_btn;
		case 44:
			return R.drawable.d_answer_study_4_2_btn;
		case 51:
			return R.drawable.d_answer_less_1_2_btn;
		case 61:
			return R.drawable.d_answer_young_1_2_btn;
		case 62:
			return R.drawable.d_answer_young_1_2_btn;
		case 63:
			return R.drawable.d_answer_young_1_2_btn;
		default:
			return 0;
		}
	}
	private int getAnswer3Img(){
		switch(questionNumber){
		case 13:
			return R.drawable.d_answer_picnic_3_3_btn;
		case 42:
			return R.drawable.d_answer_study_2_3_btn;
		case 43:
			return R.drawable.d_answer_study_3_3_btn;
		case 51:
			return R.drawable.d_answer_less_1_3_btn;
		default:
			return 0;
		}
	}
	private int getAnswer4Img(){
		switch(questionNumber){
		case 13:
			return R.drawable.d_answer_picnic_3_4_btn;
		case 43:
			return R.drawable.d_answer_study_3_4_btn;
		case 51:
			return R.drawable.d_answer_less_1_4_btn;
		default:
			return 0;
		}
	}
	
	public int getTopProgressImg(){
		switch(questionNumber){
		case 11:
			return R.drawable.d_view_young_one;
		case 12:
			return R.drawable.d_view_young_two;
		case 13:
			return R.drawable.d_view_young_three;
		case 21:
		case 31:
			return R.drawable.d_view_health_one;
		case 32:
			return R.drawable.d_view_health_two;
		case 41:
			return R.drawable.d_view_study_one;
		case 42:
			return R.drawable.d_view_study_two;
		case 43:
			return R.drawable.d_view_study_three;
		case 44:
			return R.drawable.d_view_study_four;
		case 51:
			return R.drawable.d_view_four_copy_7;
		case 61:
			return R.drawable.d_view_young_one;
		case 62:
			return R.drawable.d_view_young_two;
		case 63:
			return R.drawable.d_view_young_three;
		default:
			return 0;
			
		}
		
	}
	private int questionNumber;		// 11 : Question1_1  21 : Question 2_1 Etc...
	private String question;
}
