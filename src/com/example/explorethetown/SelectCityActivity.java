/**
 * Select City in Map Image
 * 
 * Daun Joung..
 */
package com.example.explorethetown;


import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SelectCityActivity  extends ActionBarActivity{	
	
	 Handler handler;			// Handler for delay
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_city_map_image);
		
		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
        actionBar.hide();
        
        
        // add click listener
        addListenerOnButton();
	}
	
	
	public void addListenerOnButton(){
		ImageButton imageButton1 = (ImageButton)findViewById(R.id.imgBtnUpper);
		
		imageButton1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				Toast.makeText(SelectCityActivity.this, "ImageButton is clicked!!",Toast.LENGTH_LONG).show();
		
				
				//Change Page after Few secs
				// TODO 
				handler = new Handler();
				handler.postDelayed(irun, 1000);		//change page after 2 secs
			}
			
			Runnable irun = new Runnable(){
				@Override
				public void run(){
					Intent iIntent = new Intent(SelectCityActivity.this, SelectCityListActivity.class);
					startActivity(iIntent);
					finish();
					
					
				}
			};
			
		});
	}
}
