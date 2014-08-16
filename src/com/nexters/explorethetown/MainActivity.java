/**
 * Intro
 * 
 * Daun Joung..
 * 
 * http://goo.gl/PlOs87   -> android intro page
 */
package com.nexters.explorethetown;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {

	Handler handler; // Handler for delay
	private static final int AUTO_HIDE_DELAY_MILLIS = 1500;
	// 시작관련 변수
	private boolean isFirst = false; // 처음 실행 여부

	// 설정 저장소
	SharedPreferences pref;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);

		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		// 저장소 초기화
		pref = getApplicationContext().getSharedPreferences("explorethetown",
				Context.MODE_PRIVATE);

		// 처음 실행 여부 체크
		isFirst = pref.getBoolean("isFirst", true);
		// isFirst = true; //test
		if (isFirst) {
			pref.edit().putBoolean("isFirst", false).commit();

			// start normal activity
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// start first tutorial activity

					Intent i = new Intent(MainActivity.this,
							InitialTutorialActivity.class);
					startActivityForResult(i, 0);

					// close this activity
					// finish();
				}
			}, AUTO_HIDE_DELAY_MILLIS);

		} else {

			// start normal activity
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Intent iIntent = new Intent(MainActivity.this,
							SelectCityActivity.class);
					startActivity(iIntent);
					finish();

					// Fade
					overridePendingTransition(android.R.anim.fade_in,
							android.R.anim.fade_out);
				}
			}, AUTO_HIDE_DELAY_MILLIS);
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Intent iIntent = new Intent(MainActivity.this, SelectCityActivity.class);
		startActivity(iIntent);
		finish();

		// Fade
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);
	}

}
