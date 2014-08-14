package com.nexters.explorethetown;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import com.nexters.explorethetown.R;
import com.nexters.custom.QuestionType;

public class Question {
	Question(){
		questionNumber = 0;
		answersCode = new JSONArray();
		answersNoCode = new JSONArray();
	}
	public Question(int QNUM){
		setQuestionNumber(QNUM);
		answersCode = new JSONArray();
		answersNoCode = new JSONArray();
	}
	public QuestionType getQuestionType(){
		switch(questionNumber){
		case 13:
		case 31:
		case 42:
		case 43:
		case 44:
		case 61:
			return QuestionType.CHECKBOX;
		default:
			return QuestionType.YESORNO;
		}
	}
	public int answersCodeSize(){
		return answersCode.length() + answersNoCode.length();
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
		case 26:
		case 32:
		case 44:
		case 61:
		case 53:
			return true;
		default:
				return false;
		}
	}
	
	public void nextQuestion(){
		setQuestionNumber(++questionNumber);
	}
	public void beforeQuestion(int finishList){
		if((questionNumber%10) == 1){
			setQuestionNumber((finishList%10)*10+1);
		}else{
			setQuestionNumber(--questionNumber);
		}
	}

	public int getQuestionNumber(){
		return questionNumber;
	}
	
	public int getTitleImg(){
		switch(questionNumber/10){
		case 1:
			return R.drawable.d_text_top_picnic;
		case 2:
			return R.drawable.d_text_top_every;
		case 3:
			return R.drawable.d_text_top_health;
		case 4:
			return R.drawable.d_text_top_study;
		case 5:
			return R.drawable.d_text_top_young;
		case 6:
			return R.drawable.d_text_top_less;
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
			return R.drawable.d_question_every_1;
		case 22:
			return R.drawable.d_question_every_2;
		case 23:
			return R.drawable.d_question_every_3;
		case 24:
			return R.drawable.d_question_every_4;
		case 25:
			return R.drawable.d_question_every_5;
		case 26:
			return R.drawable.d_question_every_6;
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
			return R.drawable.d_question_young_1;
		case 52:
			return R.drawable.d_question_young_2;
		case 53:
			return R.drawable.d_question_young_3;
		case 61:
			return R.drawable.d_question_less_1;
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
		case 25:
		case 26:
			return R.drawable.d_answer_every_1_1_btn;
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
			return R.drawable.d_answer_young_1_1_btn;
		case 52:
			return R.drawable.d_answer_young_1_1_btn;
		case 53:
			return R.drawable.d_answer_young_1_1_btn;
		case 61:
			return R.drawable.d_answer_less_1_1_btn;
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
		case 25:
		case 26:
			return R.drawable.d_answer_every_1_2_btn;
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
			return R.drawable.d_answer_young_1_2_btn;
		case 52:
			return R.drawable.d_answer_young_1_2_btn;
		case 53:
			return R.drawable.d_answer_young_1_2_btn;
		case 61:
			return R.drawable.d_answer_less_1_2_btn;
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
		case 61:
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
		case 61:
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
			return R.drawable.d_view_every_one;
		case 22:
			return R.drawable.d_view_every_two;
		case 23:
			return R.drawable.d_view_every_three;
		case 24:
			return R.drawable.d_view_every_four;
		case 25:
			return R.drawable.d_view_every_five;
		case 26:
			return R.drawable.d_view_every_six;
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
			return R.drawable.d_view_young_one;
		case 52:
			return R.drawable.d_view_young_two;
		case 53:
			return R.drawable.d_view_young_three;
		case 61:
			return R.drawable.d_view_four_copy_7;
		default:
			return 0;
			
		}
		
	}
	public void setAnswerCode(boolean chk){
		if(chk == true){
			switch(questionNumber){
			case 11:
				answersCode.put("item_40");
				break;
			case 12:
				answersCode.put("item_41");
				break;
			case 21:
				answersCode.put("item_53");
				break;
			case 22:
				answersCode.put("item_31");
				answersCode.put("item_32");
				break;
			case 23:
				answersCode.put("item_33");
				break;
			case 24:
				answersCode.put("item_36");
				break;
			case 25:
				answersCode.put("item_34");
				break;
			case 26:
				answersCode.put("literary_art_hall");
				break;
			case 32:
				answersCode.put("item_43");
				break;
			case 41:
				answersCode.put("item_19");
				break;
			case 51:
				answersCode.put("item_29");
				answersCode.put("item_30");
				break;
			case 52:
				answersCode.put("item_39");
				break;
			case 53:
				answersCode.put("item_54");
				break;
			}
		}
	}
	public void setAnswerCode(boolean[] chk){
		if(chk[0]){
			switch(questionNumber){
			case 13:
				answersCode.put("athletic_field");
				break;
			case 31:
				answersCode.put("trail");
				break;
			case 42:
				answersCode.put("item_20");
				break;
			case 43:
				answersCode.put("item_23");
				break;
			case 44:
				answersCode.put("item_35");
				break;
			case 61:
				answersNoCode.put("item_54");
				break;
			}
		}else if(chk[1]){
			switch(questionNumber){
			case 13:
				answersCode.put("swimming_pool");
				break;
			case 31:
				answersCode.put("item_42");
				break;
			case 42:
				answersCode.put("item_21");
				break;
			case 43:
				answersCode.put("item_24");
				break;
			case 44:
				answersCode.put("item_28");
				break;
			case 61:
				answersNoCode.put("item_22");
				break;
			}
		}else if(chk[2]){
			switch(questionNumber){
			case 13:
				answersCode.put("roller_skating_rink");
				break;
			case 42:
				answersCode.put("item_22");
				break;
			case 43:
				answersCode.put("item_25");
				break;
			case 61:
				answersNoCode.put("item_23");
				answersNoCode.put("item_24");
				answersNoCode.put("item_25");
				answersNoCode.put("item_26");
				break;
			}
		}else if(chk[3]){
			switch(questionNumber){
			case 13:
				answersCode.put("driving_range");
				break;
			case 43:
				answersCode.put("item_26");
				break;
			case 61:
				answersNoCode.put("item_29");
				answersNoCode.put("item_30");
				break;
			}
		}
	}
	

	
	public JSONArray answersCode;			// ���� ��û ��ȣ�� ����
	public JSONArray answersNoCode;			// ���� ���� ����
	private int questionNumber;		// 11 : Question1_1  21 : Question 2_1 Etc...
	private String question;
}
