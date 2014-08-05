package com.example.explorethetown;

public class Question {
	Question(){
		questionNumber = 0;
	}
	public Question(int QNUM){
		setQuestionNumber(QNUM);
	}
	public int getQuestionType(){
		switch(questionNumber){
		case 13:
			return 1;
		default:
			return 0;
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
		case 15:
		case 22:
		case 33:
			return true;
		default:
				return false;
		}
	}
	
	public void nextQuestion(){
		setQuestionNumber(++questionNumber);
	}

	
	private int questionNumber;		// 11 : Question1_1  21 : Question 2_1 Etc...
	private String question;
}
