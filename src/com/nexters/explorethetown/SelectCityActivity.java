/**
 * Select City in Map Image
 * 
 * Daun Joung..
 */
package com.nexters.explorethetown;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.nexters.custom.CityPosition;

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
		ImageButton imgBtnUpper = (ImageButton)findViewById(R.id.imgBtn_selectCitymap_upper);
		
		imgBtnUpper.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				Intent iIntent = new Intent(SelectCityActivity.this, SelectCityListActivity.class);
				iIntent.putExtra("CityPosition", CityPosition.UPPER);
				startActivity(iIntent);
			}
		});
		
		ImageButton imgBtnRight = (ImageButton)findViewById(R.id.imgBtn_selectCitymap_right);
		imgBtnRight.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent iIntent = new Intent(SelectCityActivity.this, SelectCityListActivity.class);
				iIntent.putExtra("CityPosition", CityPosition.RIGHT);
				startActivity(iIntent);
				
			}
		});
		
		ImageButton imgBtnLeftUp = (ImageButton)findViewById(R.id.imgBtn_selectCitymap_leftup);
		imgBtnLeftUp.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent iIntent = new Intent(SelectCityActivity.this, SelectCityListActivity.class);
				iIntent.putExtra("CityPosition", CityPosition.LEFTUP);
				startActivity(iIntent);
				
			}
		});
		
		ImageButton imgBtnLeftDown = (ImageButton)findViewById(R.id.imgBtn_selectCitymap_leftdown);
		imgBtnLeftDown.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent iIntent = new Intent(SelectCityActivity.this, SelectCityListActivity.class);
				iIntent.putExtra("CityPosition", CityPosition.LEFTDOWN);
				startActivity(iIntent);
				
			}
		});
		
		//도움말버튼.
		findViewById(R.id.img_selectCitymap_help_btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(SelectCityActivity.this,
						InitialTutorialActivity.class);
				startActivity(i);
				
			}
		});
		
		
	}	
	@Override
	public void onBackPressed() {
		this.finish();
	}
}
