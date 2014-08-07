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
import com.example.custom.*;
import com.example.custom.CityPosition;

public class SelectCityListActivity extends ActionBarActivity{
	
	
	
	ImageButton beforeClickedButton;
	CityName clickedCityName;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		// Hidden Action bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
		
		Intent iIntent = getIntent();
		CityPosition nowCity = (CityPosition)iIntent.getSerializableExtra("CityPosition");
		
		showContentViewSetting(nowCity);
		
		addStartBtnListenerOnButton();
	}
	
	public void showContentViewSetting(CityPosition nowCity){
		switch(nowCity){
		case UPPER:
			setContentView(R.layout.activity_select_city_list_first);
			addFirstPageListenerOnButton();
			break;
		case RIGHT:
			setContentView(R.layout.activity_select_city_list_second);
			addSecondPageListenerOnButton();
			break;
		case LEFTUP:
			setContentView(R.layout.activity_select_city_list_third);
			addThirdPageListenerOnButton();
			break;
		case LEFTDOWN:
			setContentView(R.layout.activity_select_city_list_fourth);
			addFourthPageListenerOnButton();
			break;
		}
	}
	
	public void addFirstPageListenerOnButton(){
		final ImageView bigImg = (ImageView)findViewById(R.id.img_selectCityListFirst_City);
		
		final ImageButton imgBtn1 = (ImageButton)findViewById(R.id.imgBtn_selectCityListFirst_seoul);
		imgBtn1.setSelected(false);
		imgBtn1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				beforeClickedButton.setSelected(false);
				imgBtn1.setSelected(true);
				beforeClickedButton = imgBtn1;
				bigImg.setImageResource(R.drawable.b_big_seoul);
				clickedCityName = CityName.SEOUL;
			}
		});
		
		final ImageButton imgBtn2 = (ImageButton)findViewById(R.id.imgBtn_selectCityListFirst_incheon);
		imgBtn2.setSelected(false);
		imgBtn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn2.setSelected(true);
				beforeClickedButton = imgBtn2;
				bigImg.setImageResource(R.drawable.b_big_incheon);
				clickedCityName = CityName.INCHEON;
				
			}
		});
		
		final ImageButton imgBtn3 = (ImageButton)findViewById(R.id.imgBtn_selectCityListFirst_gyeonggido);
		imgBtn3.setSelected(false);
		imgBtn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn3.setSelected(true);
				beforeClickedButton = imgBtn3;
				bigImg.setImageResource(R.drawable.b_big_gyeonggido);
				clickedCityName = CityName.GYEONGGI_DO;
				
			}
		});
		
		final ImageButton imgBtn4 = (ImageButton)findViewById(R.id.imgBtn_selectCityListFirst_gangwondo);
		imgBtn4.setSelected(false);
		imgBtn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn4.setSelected(true);
				beforeClickedButton = imgBtn4;
				bigImg.setImageResource(R.drawable.b_big_ganwondo);
				clickedCityName = CityName.GANGWON_DO;
				
			}
		});
		beforeClickedButton = imgBtn1;
		beforeClickedButton.setSelected(true);
		clickedCityName = CityName.SEOUL;
	}
	
	public void addSecondPageListenerOnButton(){
		final ImageView bigImg = (ImageView)findViewById(R.id.img_selectCityListSecond_City);
		
		final ImageButton imgBtn1 = (ImageButton)findViewById(R.id.imgBtn_selectCityListSecond_chungcheongnamdo);
		imgBtn1.setSelected(false);
		imgBtn1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				beforeClickedButton.setSelected(false);
				imgBtn1.setSelected(true);
				beforeClickedButton = imgBtn1;
				bigImg.setImageResource(R.drawable.b_big_chungcheongnamdo);
				clickedCityName = CityName.CHUNGCHEONGNAM_DO;
			}
		});
		
		final ImageButton imgBtn2 = (ImageButton)findViewById(R.id.imgBtn_selectCityListSecond_sejong);
		imgBtn2.setSelected(false);
		imgBtn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn2.setSelected(true);
				beforeClickedButton = imgBtn2;
				bigImg.setImageResource(R.drawable.b_big_sejong);
				clickedCityName = CityName.SEJONG;
				
			}
		});
		
		final ImageButton imgBtn3 = (ImageButton)findViewById(R.id.imgBtn_selectCityListSecond_daejeon);
		imgBtn3.setSelected(false);
		imgBtn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn3.setSelected(true);
				beforeClickedButton = imgBtn3;
				bigImg.setImageResource(R.drawable.b_big_daejeon);
				clickedCityName = CityName.DAEJEON;
				
			}
		});
		
		final ImageButton imgBtn4 = (ImageButton)findViewById(R.id.imgBtn_selectCityListSecond_chungcheongbukdo);
		imgBtn4.setSelected(false);
		imgBtn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn4.setSelected(true);
				beforeClickedButton = imgBtn4;
				bigImg.setImageResource(R.drawable.b_big_chungcheongbukdo);
				clickedCityName = CityName.CHUNGCHEONGBUK_DO;
				
			}
		});
		beforeClickedButton = imgBtn1;
		beforeClickedButton.setSelected(true);
		clickedCityName = CityName.CHUNGCHEONGNAM_DO;
	}
	
	public void addThirdPageListenerOnButton(){
		final ImageView bigImg = (ImageView)findViewById(R.id.img_selectCityListThird_City);
		
		final ImageButton imgBtn1 = (ImageButton)findViewById(R.id.imgBtn_selectCityListThird_jeollabukdo);
		imgBtn1.setSelected(false);
		imgBtn1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				beforeClickedButton.setSelected(false);
				imgBtn1.setSelected(true);
				beforeClickedButton = imgBtn1;
				bigImg.setImageResource(R.drawable.b_big_jeollabukdo);
				clickedCityName = CityName.JEOLLABUK_DO;
			}
		});
		
		final ImageButton imgBtn2 = (ImageButton)findViewById(R.id.imgBtn_selectCityListThird_jeollanamdo);
		imgBtn2.setSelected(false);
		imgBtn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn2.setSelected(true);
				beforeClickedButton = imgBtn2;
				bigImg.setImageResource(R.drawable.b_big_jeollanamdo);
				clickedCityName = CityName.JEOLLANAM_DO;
				
			}
		});
		
		final ImageButton imgBtn3 = (ImageButton)findViewById(R.id.imgBtn_selectCityListThird_gwangju);
		imgBtn3.setSelected(false);
		imgBtn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn3.setSelected(true);
				beforeClickedButton = imgBtn3;
				bigImg.setImageResource(R.drawable.b_big_gwangju);
				clickedCityName = CityName.GWANGJU;
				
			}
		});
		
		final ImageButton imgBtn4 = (ImageButton)findViewById(R.id.imgBtn_selectCityListThird_jeju);
		imgBtn4.setSelected(false);
		imgBtn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn4.setSelected(true);
				beforeClickedButton = imgBtn4;
				bigImg.setImageResource(R.drawable.b_big_jeju);
				clickedCityName = CityName.JEJU;
				
			}
		});
		beforeClickedButton = imgBtn1;
		beforeClickedButton.setSelected(true);
		clickedCityName = CityName.JEOLLABUK_DO;
	}
	
	public void addFourthPageListenerOnButton(){
		final ImageView bigImg = (ImageView)findViewById(R.id.img_selectCityListFourth_City);
		
		final ImageButton imgBtn1 = (ImageButton)findViewById(R.id.imgBtn_selectCityListFourth_gyeongsangbuk);
		imgBtn1.setSelected(false);
		imgBtn1.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View arg0){
				beforeClickedButton.setSelected(false);
				imgBtn1.setSelected(true);
				beforeClickedButton = imgBtn1;
				bigImg.setImageResource(R.drawable.b_big_gyeongbuk);
				clickedCityName = CityName.GYEONGBUK;
			}
		});
		
		final ImageButton imgBtn2 = (ImageButton)findViewById(R.id.imgBtn_selectCityListFourth_daegu);
		imgBtn2.setSelected(false);
		imgBtn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn2.setSelected(true);
				beforeClickedButton = imgBtn2;
				bigImg.setImageResource(R.drawable.b_big_daegu);
				clickedCityName = CityName.DAEGU;
				
			}
		});
		
		final ImageButton imgBtn3 = (ImageButton)findViewById(R.id.imgBtn_selectCityListFourth_ulsan);
		imgBtn3.setSelected(false);
		imgBtn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn3.setSelected(true);
				beforeClickedButton = imgBtn3;
				bigImg.setImageResource(R.drawable.b_big_ulsan);
				clickedCityName = CityName.ULSAN;
				
			}
		});
		
		final ImageButton imgBtn4 = (ImageButton)findViewById(R.id.imgBtn_selectCityListFourth_gyeonsangnamdo);
		imgBtn4.setSelected(false);
		imgBtn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn4.setSelected(true);
				beforeClickedButton = imgBtn4;
				bigImg.setImageResource(R.drawable.b_big_gyeongsangnamdo);
				clickedCityName = CityName.GYEONGSANGNAM_DO;
				
			}
		});
		
		final ImageButton imgBtn5 = (ImageButton)findViewById(R.id.imgBtn_selectCityListFourth_busan);
		imgBtn5.setSelected(false);
		imgBtn5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				beforeClickedButton.setSelected(false);
				imgBtn5.setSelected(true);
				beforeClickedButton = imgBtn5;
				bigImg.setImageResource(R.drawable.b_big_busan);
				clickedCityName = CityName.BUSAN;
				
			}
		});
		beforeClickedButton = imgBtn1;
		beforeClickedButton.setSelected(true);
		clickedCityName = CityName.JEOLLABUK_DO;
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
