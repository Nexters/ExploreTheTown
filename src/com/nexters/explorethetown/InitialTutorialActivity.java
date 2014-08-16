package com.nexters.explorethetown;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class InitialTutorialActivity extends FragmentActivity {
	private InitialTutorialAdapter adapter;
	private ViewPager viewPager;

	// private ArrayList<String> images;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();

		setContentView(R.layout.activity_tutorial);

		viewPager = (ViewPager) findViewById(R.id.pager);

		adapter = new InitialTutorialAdapter(InitialTutorialActivity.this);

		viewPager.setAdapter(adapter);
	}

}