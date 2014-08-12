// http://androidhuman.tistory.com/518
// Google Map V2 �뜝�럡�뀬�뜝�럩�뮔�뛾�렮維뽬떋占�
//http://biig.tistory.com/24 �뜝�럥�뿰�뼨轅명�←뙴袁с럶占쎈た占쏙옙

//http://developer.android.com/reference/com/google/android/gms/maps/model/Polygon.html
// 嶺뚯쉻�삕�뜝�럥利� �뜝�럩留꾢뜝�럥�뱺 �뜝�럥利꿨뜝�럩援� �윜諛몄굡占쎈뉴�뜝�럥裕됪ㅀ袁ъ삕 �뜝�럥�뿰�뼨轅명�ｈ땻占� 嶺뚣�볝늾占쏙옙..?

package com.nexters.explorethetown;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import com.nexters.coord.CoordConverter;
import com.nexters.coord.PointF;
import com.nexters.custom.FirstMapAnswerData;
import com.nexters.custom.FirstMapRequestData;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;

import android.app.ActionBar;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.nexters.server.RequestManager;
import com.nexters.server.ResponseData;

import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.nexters.explorethetown.R;

public class FirstAnswerMapActivity extends ActionBarActivity implements
		OnMarkerClickListener {
	private GoogleMap mmap;
	MapFragment fragment;

	private Marker nowMarker;
	
	FirstMapRequestData resultData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_answer_map);

		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		Intent iIntent = getIntent();
		String[] getIntentStr = iIntent.getStringArrayExtra("SELECT_RESULT");
		
		FirstMapAnswerData answerData = new FirstMapAnswerData();
		answerData.cd = "11";
		answerData.req_svc = "LC0005";
		answerData.requestData = getIntentStr;
		
		
		setOnClickListener();

		// Server Request

		try {
			RequestManager.sendRequest("house_gateway", answerData , new JsonHttpResponseHandler() {
				@Override
				public void onSuccess(int statusCode, Header[] headers,
						JSONObject response) {
					
					try {
						resultData = RequestManager.responseParser(response);
						int a = 0 ; 
						 a = 10 ; 
						for(int i = 0 ; i < resultData.rigions.length ; i++){
							Log.i("haha", Double.toString(resultData.rigions[i].ratio));
							int fill_color = Color.WHITE;
							if(resultData.rigions[i].ratio <= 10.0){
								fill_color = 0xFFFF9900;
							}else if(resultData.rigions[i].ratio <= 20.0){
								fill_color = 0xFFFFCC00;
							}else if(resultData.rigions[i].ratio <= 30.0){
								fill_color = 0xFFFFFF33;
							}else if(resultData.rigions[i].ratio <= 40.0){
								fill_color = 0XFFFFFF66;
							}else {
								fill_color = 0xFFFFFF99;
							}
							colormapdraw(resultData.rigions[i].coords,fill_color);
						}
						Toast toast = Toast.makeText(FirstAnswerMapActivity.this, "Good!", Toast.LENGTH_LONG);
						toast.show();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					 
					
				}});
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Go to Next
	public void setOnClickListener() {
		Button imgBtnNext = (Button) findViewById(R.id.imgBtn_first_answer_Next);

		imgBtnNext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent iIntent = new Intent(FirstAnswerMapActivity.this,
						QuestionNeighborActivity.class);

				startActivity(iIntent);

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {// �뜝�럩留꾤뇖�궡瑗룩땻類㏃삕占쎌젧
																					// �뜝�럥�뱻�뜝�럥堉믭옙�쑏熬곥굥堉�
																					// 占쎈꽞占쎄턁筌앾옙
																					// �뜝�럩�쐩
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 0:
			setUpMapIfNeeded();
			break;
		}
	}
	
	public void colormapdraw(PointF[] inPoint,int fill_color){
		PolygonOptions options = new PolygonOptions();
		for(int i = 0 ; i < inPoint.length ; i++){
			options.add(new LatLng(inPoint[i].x, inPoint[i].y));
			
		}
		
		options.strokeColor(Color.WHITE).fillColor(fill_color);
		mmap.addPolygon(options);
	}

	@Override
	public void onBackPressed() {
		this.finish();
	}

	@Override
	protected void onResume() {
		super.onResume();
		setUpMapIfNeeded();

	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	private void setUpMapIfNeeded() {
		if (mmap == null) {
			fragment = (MapFragment) getFragmentManager().findFragmentById(
					R.id.map);
			mmap = fragment.getMap();

			// �뜝�럥六삣뜝�럩�굚 �뜝�럩留꾤뇖�궪�삕 �뜝�럩�젧�뜝�럥由��뼨�먯삕!!!
			LatLng startingPoint = new LatLng(37.37221, 126.94341);
			// �뜝�럥六삣뜝�럩�굚 �뛾�룄�ｏ옙紐� �뜝�럩�젧�뜝�럥由��뼨�먯삕!!
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 16));

		}
	}

	private void setUpMap() {
		mmap.setMyLocationEnabled(true);
		mmap.getMyLocation();

	}

	@Override
	public boolean onMarkerClick(Marker arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
