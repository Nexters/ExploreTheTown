/**
 * Intro
 * 
 * Daun Joung..
 * 
 * http://goo.gl/PlOs87   -> android intro page
 */
package com.nexters.explorethetown;

import com.nexters.explorethetown.R;

import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends ActionBarActivity {

	
    Handler handler; 	// Handler for delay
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		
		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
        actionBar.hide();
        
        // Change Page After Few Secs
        handler = new Handler();
        handler.postDelayed(irun, 1000);		// change page after 1 sec
        
        
	}
	
	// after 4 secs
	Runnable irun = new Runnable(){
		@Override
		public void run(){
			// TODO Auto-generated method stub
			Intent iIntent = new Intent(MainActivity.this,SelectCityActivity.class);
			startActivity(iIntent);
			finish();
			
			// Fade
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}
	};
	
	@Override
	public void onBackPressed(){
		super.onBackPressed();
		handler.removeCallbacks(irun);
	}
	
	
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		
		return true;
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		return super.onOptionsItemSelected(item);
	}
	*/
	
}
