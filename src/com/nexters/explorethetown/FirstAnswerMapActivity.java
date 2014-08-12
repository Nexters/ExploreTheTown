// http://androidhuman.tistory.com/518
// Google Map V2 �뜝�럡�뀬�뜝�럩�뮔�뛾�렮維뽬떋占�
//http://biig.tistory.com/24 �뜝�럥�뿰�뼨轅명�←뙴袁с럶占쎈た占쏙옙

//http://developer.android.com/reference/com/google/android/gms/maps/model/Polygon.html
// 嶺뚯쉻�삕�뜝�럥利� �뜝�럩留꾢뜝�럥�뱺 �뜝�럥利꿨뜝�럩援� �윜諛몄굡占쎈뉴�뜝�럥裕됪ㅀ袁ъ삕 �뜝�럥�뿰�뼨轅명�ｈ땻占� 嶺뚣�볝늾占쏙옙..?

package com.nexters.explorethetown;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.nexters.coord.CoordConverter;
import com.nexters.coord.PointF;
import com.nexters.custom.CityName;
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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.nexters.explorethetown.R;

public class FirstAnswerMapActivity extends ActionBarActivity implements
		OnMarkerClickListener {
	private GoogleMap mmap;
	MapFragment fragment;
	ProgressBar loadingBar;
	private Marker nowMarker;
	CityName selectCityName;
	
	FirstMapRequestData resultData;
	
	String requestCond;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_answer_map);

		loadingBar = (ProgressBar)findViewById(R.id.progressBar_first_answer);
		
		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		Intent iIntent = getIntent();
		selectCityName = (CityName) iIntent.getSerializableExtra("SELECT_CITY");
		String[] getIntentStr = iIntent.getStringArrayExtra("SELECT_RESULT");
		JSONArray condArr = new JSONArray();
		for(int i = 0 ; i < getIntentStr.length ; i++){
			condArr.put(getIntentStr[i]);
		}
		requestCond = condArr.toString();
		Log.i("request cond",requestCond);
		
		FirstMapAnswerData answerData = new FirstMapAnswerData();
		answerData.cd = "11";
		answerData.req_svc = "LC0005";
		answerData.requestData = getIntentStr;
		
		switch(selectCityName){
		case SEOUL :
			answerData.cd = "11";
			break;
		case INCHEON :
			answerData.cd = "23";
			break;
		case GYEONGGI_DO :
			answerData.cd = "31";
			break;
		case GANGWON_DO :
			answerData.cd = "32";
			break;
		case SEJONG : 
		case CHUNGCHEONGNAM_DO : 
			answerData.cd = "34";
			break;
		case DAEJEON :  
			answerData.cd = "25";
			break;
		case CHUNGCHEONGBUK_DO :
			answerData.cd = "33";
			break;
		case JEOLLABUK_DO :
			answerData.cd = "35";
			break;
		case JEOLLANAM_DO : 
			answerData.cd = "36";
			break;
		case GWANGJU :
			answerData.cd = "24";
			break;
		case JEJU :
			answerData.cd = "39";
			break;
		case GYEONGBUK:
			answerData.cd = "37";
			break;
		case DAEGU : 
			answerData.cd = "22";
			break;
		case ULSAN : 
			answerData.cd = "26";
			break;
		case GYEONGSANGNAM_DO :
			answerData.cd = "38";
			break;
		case BUSAN :
			answerData.cd = "21";
			break;
		}
		
		setOnClickListener();

		// Server Request

		try {
			RequestManager.sendRequestForFirstMap("house_gateway", answerData , new JsonHttpResponseHandler() {
				@Override
				public void onSuccess(int statusCode, Header[] headers,
						JSONObject response) {
					
					try {
						resultData = RequestManager.responseParserFirstMap(response);

							PolygonOptions tmp = new PolygonOptions();
							tmp.add(new LatLng(30,120), new LatLng(50,120), new LatLng(50,140), new LatLng(30,140));
							tmp.strokeColor(Color.WHITE).fillColor(0x99FFFFFF);
							mmap.addPolygon(tmp);
						for(int i = 0 ; i < resultData.rigions.length ; i++){
							//Log.i("haha", Double.toString(resultData.rigions[i].ratio));
							int fill_color = Color.WHITE;
							if(resultData.rigions[i].ratio <= 10.0){
								fill_color = 0xAAFF9900;
							}else if(resultData.rigions[i].ratio <= 20.0){
								fill_color = 0x99FFCC00;
							}else if(resultData.rigions[i].ratio <= 30.0){
								fill_color = 0x90FFFF33;
							}else if(resultData.rigions[i].ratio <= 40.0){
								fill_color = 0X89FFFF66;
							}else {
								fill_color = 0x88FFFF99;
							}
							colormapdraw(resultData.rigions[i].coords,fill_color);
						}
						RelativeLayout loadingLayout = (RelativeLayout)findViewById(R.id.layout_loading_page);
						loadingLayout.setVisibility(View.INVISIBLE);
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
				iIntent.putExtra("YELLOW_TOP30_CD", resultData.top30CdStr);
				iIntent.putExtra("FIRST_COND", requestCond);
				iIntent.putExtra("SELECT_CITY", selectCityName);
				startActivity(iIntent);
				finish();

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
		
		options.strokeColor(Color.WHITE).strokeWidth((float) 3.0).fillColor(fill_color);
		mmap.addPolygon(options);
		options = null;
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

			setMapCamera();

		}
	}
	
	private void setMapCamera(){
		LatLng startingPoint = null;
		switch(selectCityName){
		case SEOUL :
			startingPoint = new LatLng(37.561241, 126.979582);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case INCHEON :
			startingPoint = new LatLng(37.501329, 126.667484);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case GYEONGGI_DO :
			startingPoint = new LatLng(37.268678, 127.021473);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case GANGWON_DO :
			startingPoint = new LatLng(37.913123, 127.897661);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case SEJONG : 
			startingPoint = new LatLng(36.601181, 127.294313);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case CHUNGCHEONGNAM_DO : 
			startingPoint = new LatLng(36.642577, 126.663617);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case DAEJEON :  
			startingPoint = new LatLng(36.343795, 127.401412);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case CHUNGCHEONGBUK_DO :
			startingPoint = new LatLng(36.639403, 127.487243);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case JEOLLABUK_DO :
			startingPoint = new LatLng(35.818202, 127.487243);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case JEOLLANAM_DO : 
			startingPoint = new LatLng(34.808654, 126.432053);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case GWANGJU :
			startingPoint = new LatLng(35.171488, 126.864640);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case JEJU :
			startingPoint = new LatLng(33.368577, 126.533320);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case GYEONGBUK:
			startingPoint = new LatLng(36.418275, 129.013365);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case DAEGU : 
			startingPoint = new LatLng(35.870444, 128.586272);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case ULSAN : 
			startingPoint = new LatLng(35.542595, 129.329222);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case GYEONGSANGNAM_DO :
			startingPoint = new LatLng(35.225473, 128.676697);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
		case BUSAN :
			startingPoint = new LatLng(35.177563, 129.078762);
			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 10));
			break;
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
