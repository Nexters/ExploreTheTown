// android selector -> change image when click button
// http://goo.gl/Jlgd4v
package com.example.explorethetown;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;



import com.example.custom.*;

public class SelectCityListActivity extends ActionBarActivity{
	
	
	
	ImageButton beforeClickedButton;
	CityName clickedCityName;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_city_list);
		
		// Hidden Action bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		addFirstPageListenerOnButton();
		addStartBtnListenerOnButton();
	}
	
	public void addFirstPageListenerOnButton(){
		final ImageView bigImg = (ImageView)findViewById(R.id.img_selectCityList_City);
		
		final ImageButton imgBtnSeoul = (ImageButton)findViewById(R.id.imgBtn_selectCityList_seoul);
		imgBtnSeoul.setSelected(false);
		imgBtnSeoul.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				beforeClickedButton.setSelected(false);
				imgBtnSeoul.setSelected(true);
				beforeClickedButton = imgBtnSeoul;
				bigImg.setImageResource(R.drawable.b_big_seoul);
				clickedCityName = CityName.SEOUL;
			}
		});
		
		final ImageButton imgBtnIncheon = (ImageButton)findViewById(R.id.imgBtn_selectCityList_incheon);
		imgBtnIncheon.setSelected(false);
		imgBtnIncheon.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtnIncheon.setSelected(true);
				beforeClickedButton = imgBtnIncheon;
				bigImg.setImageResource(R.drawable.b_big_incheon);
				clickedCityName = CityName.INCHEON;
				
			}
		});
		
		final ImageButton imgBtnGyeonggi = (ImageButton)findViewById(R.id.imgBtn_selectCityList_gyeonggido);
		imgBtnGyeonggi.setSelected(false);
		imgBtnGyeonggi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtnGyeonggi.setSelected(true);
				beforeClickedButton = imgBtnGyeonggi;
				bigImg.setImageResource(R.drawable.b_big_gyeonggido);
				clickedCityName = CityName.GYEONGGI_DO;
				
			}
		});
		
		final ImageButton imgBtnGangwon = (ImageButton)findViewById(R.id.imgBtn_selectCityList_gangwondo);
		imgBtnGangwon.setSelected(false);
		imgBtnGangwon.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtnGangwon.setSelected(true);
				beforeClickedButton = imgBtnGangwon;
				bigImg.setImageResource(R.drawable.b_big_ganwondo);
				clickedCityName = CityName.GANGWON_DO;
				
			}
		});
		
		

		beforeClickedButton = imgBtnSeoul;
		beforeClickedButton.setSelected(true);
		clickedCityName = CityName.SEOUL;
	}
	
	public void addStartBtnListenerOnButton(){
		Button imgStartBtn = (Button)findViewById(R.id.button_selectCityList_start);
		
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
