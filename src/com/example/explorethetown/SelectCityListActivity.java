package com.example.explorethetown;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SelectCityListActivity extends ActionBarActivity{
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_city_list);
		
		// Hidden Action bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		addListenerOnButton();
		addStartBtnListenerOnButton();
	}
	
	public void addListenerOnButton(){
		ImageButton imageButton1 = (ImageButton)findViewById(R.id.imgBtnCitySeoul);
		
		imageButton1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				Toast.makeText(SelectCityListActivity.this,"Image Button Clicked!",Toast.LENGTH_LONG).show();
			
			}
		});
	}
	
	public void addStartBtnListenerOnButton(){
		ImageButton imgStartBtn = (ImageButton)findViewById(R.id.imgBtnStart);
		
		imgStartBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent iIntent = new Intent(SelectCityListActivity.this, SelectQuestionWayActivity.class);
				startActivity(iIntent);
			}
		});
	}

}
