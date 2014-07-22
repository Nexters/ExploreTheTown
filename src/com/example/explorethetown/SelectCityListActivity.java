package com.example.explorethetown;

import android.app.ActionBar;
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

}
