// android selector -> change image when click button
// http://goo.gl/Jlgd4v
package com.nexters.explorethetown;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.nexters.explorethetown.R;
import com.nexters.custom.*;

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
	}
	
	public void showContentViewSetting(CityPosition nowCity){
		switch(nowCity){
		case UPPER:
			setContentView(R.layout.activity_select_city_list_first);
			addFirstPageListenerOnButton();
			break;
		case LEFTUP:
			setContentView(R.layout.activity_select_city_list_second);
			addSecondPageListenerOnButton();
			break;
		case LEFTDOWN:
			setContentView(R.layout.activity_select_city_list_third);
			addThirdPageListenerOnButton();
			break;
		case RIGHT:
			setContentView(R.layout.activity_select_city_list_fourth);
			addFourthPageListenerOnButton();
			break;
		}
		
		//도움말버튼 설정 
		findViewById(R.id.img_selectCitymap_help_btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(SelectCityListActivity.this,
						InitialTutorialActivity.class);
				startActivity(i);
				
			}
		});
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
		
		ImageButton imgBtnLeft = (ImageButton)findViewById(R.id.imgBtn_selectCityListFirst_left);
		imgBtnLeft.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showContentViewSetting(CityPosition.RIGHT);
			}
		});
		
		ImageButton imgBtnRight = (ImageButton)findViewById(R.id.imgBtn_selectCityListFirst_right);
		imgBtnRight.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showContentViewSetting(CityPosition.LEFTUP);
			}
		});
		beforeClickedButton = imgBtn1;
		beforeClickedButton.setSelected(true);
		clickedCityName = CityName.SEOUL;
		addStartBtnListenerOnButton();
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
		
		ImageButton imgBtnLeft = (ImageButton)findViewById(R.id.imgBtn_selectCityListSecond_left);
		imgBtnLeft.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showContentViewSetting(CityPosition.UPPER);
				
			}
		});
		
		ImageButton imgBtnRight = (ImageButton)findViewById(R.id.imgBtn_selectCityListSecond_right);
		imgBtnRight.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showContentViewSetting(CityPosition.LEFTDOWN);
				
			}
		});
		beforeClickedButton = imgBtn1;
		beforeClickedButton.setSelected(true);
		clickedCityName = CityName.CHUNGCHEONGNAM_DO;
		addStartBtnListenerOnButton();
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

		ImageButton imgBtnLeft = (ImageButton)findViewById(R.id.imgBtn_selectCityListThird_left);
		imgBtnLeft.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showContentViewSetting(CityPosition.LEFTUP);
				
			}
		});
		
		ImageButton imgBtnRight = (ImageButton)findViewById(R.id.imgBtn_selectCityListThird_right);
		imgBtnRight.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showContentViewSetting(CityPosition.RIGHT);
				
			}
		});
		
		beforeClickedButton = imgBtn1;
		beforeClickedButton.setSelected(true);
		clickedCityName = CityName.JEOLLABUK_DO;
		addStartBtnListenerOnButton();
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
		

		ImageButton imgBtnLeft = (ImageButton)findViewById(R.id.imgBtn_selectCityListFourth_left);
		imgBtnLeft.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showContentViewSetting(CityPosition.LEFTDOWN);
				
			}
		});
		
		ImageButton imgBtnRight = (ImageButton)findViewById(R.id.imgBtn_selectCityListFourth_right);
		imgBtnRight.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showContentViewSetting(CityPosition.UPPER);
				
			}
		});

		
		
		beforeClickedButton = imgBtn1;
		beforeClickedButton.setSelected(true);
		clickedCityName = CityName.JEOLLABUK_DO;
		addStartBtnListenerOnButton();
	}
	
	public void addStartBtnListenerOnButton(){
		Button imgStartBtn = (Button)findViewById(R.id.button_selectCityList_start);
		
		imgStartBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent iIntent = new Intent(SelectCityListActivity.this, SelectQuestionWayActivity.class);
				iIntent.putExtra("SELECT_CITY", clickedCityName);
				startActivity(iIntent);
			}
		});
	}
	@Override
	public void onBackPressed() {
		this.finish();
	}
}
