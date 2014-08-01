package com.example.explorethetown;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

public class QuestionNeighborActivity extends ActionBarActivity {
	public class MainActivity extends ActionBarActivity {

		
	    Handler handler; 	// Handler for delay
	    
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_question_neighbor);
			
			// Hidden Action Bar
			ActionBar actionBar = getActionBar();
	        actionBar.hide();
	        
	        	        
		}
	}	
}
