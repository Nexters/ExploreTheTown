package com.nexters.explorethetown;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.nexters.coord.PointF;
import com.nexters.custom.CityName;
import com.nexters.custom.SecondMapResponseData;
import com.nexters.server.RequestManager;

public class ResultActivity extends ActionBarActivity implements
		OnMarkerClickListener {

	private GoogleMap mmap;
	MapFragment fragment;
	String neighbor_result;
	String house_result;
	String top30Cds;
	CityName selectCityName;

	String nowCd;

	/* 지역경계를 그리기 위해 실행한 쓰레드 개수를 세고, 모든 쓰레드의 실행이 끝난 시점을 체크하기 위한 변수. */
	public static AtomicInteger threadCnt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		Intent iIntent = getIntent();
		neighbor_result = iIntent.getStringExtra("NEIGHBOR_RESULT");
		house_result = iIntent.getStringExtra("HOUSE_RESULT");
		top30Cds = iIntent.getStringExtra("YELLOW_TOP30_CD");

		String firstCond = iIntent.getStringExtra("FIRST_COND");
		selectCityName = (CityName) iIntent.getSerializableExtra("SELECT_CITY");

		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		switch (selectCityName) {
		case SEOUL:
			nowCd = "11";
			break;
		case INCHEON:
			nowCd = "23";
			break;
		case GYEONGGI_DO:
			nowCd = "31";
			break;
		case GANGWON_DO:
			nowCd = "32";
			break;
		case SEJONG:
		case CHUNGCHEONGNAM_DO:
			nowCd = "34";
			break;
		case DAEJEON:
			nowCd = "25";
			break;
		case CHUNGCHEONGBUK_DO:
			nowCd = "33";
			break;
		case JEOLLABUK_DO:
			nowCd = "35";
			break;
		case JEOLLANAM_DO:
			nowCd = "36";
			break;
		case GWANGJU:
			nowCd = "24";
			break;
		case JEJU:
			nowCd = "39";
			break;
		case GYEONGBUK:
			nowCd = "37";
			break;
		case DAEGU:
			nowCd = "22";
			break;
		case ULSAN:
			nowCd = "26";
			break;
		case GYEONGSANGNAM_DO:
			nowCd = "38";
			break;
		case BUSAN:
			nowCd = "21";
			break;
		}

		setOnClickListener();

		try {
			Log.i("test", "aaaa");
			RequestManager.sendRequestForSecondMap("house_gateway",
					neighbor_result, house_result, top30Cds, nowCd, firstCond,
					new JsonHttpResponseHandler() {
						@Override
						public void onSuccess(int statusCode, Header[] headers,
								JSONObject response) {
							new BackgroundParsingData(response).execute();
						}
					});
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setFont();
	}

	
	public void setFont(){
		TextView tv = (TextView)findViewById(R.id.text_result_mypopup_topleft);
		tv.setTypeface(Typeface.createFromAsset(getAssets(), "NanumBarunGothic.ttf"));		
		tv = (TextView)findViewById(R.id.text_result_mypopup_topNum);
		tv.setTypeface(Typeface.createFromAsset(getAssets(), "NanumBarunGothic.ttf"));
		tv = (TextView)findViewById(R.id.text_result_mypopup_topRight);
		tv.setTypeface(Typeface.createFromAsset(getAssets(), "NanumBarunGothic.ttf"));		
		tv = (TextView)findViewById(R.id.text_result_mypopup_bottomNum);
		tv.setTypeface(Typeface.createFromAsset(getAssets(), "NanumBarunGothic.ttf"));
		tv = (TextView)findViewById(R.id.text_result_mypopup_bottomRight);
		tv.setTypeface(Typeface.createFromAsset(getAssets(), "NanumBarunGothic.ttf"));
		tv = (TextView)findViewById(R.id.text_result_mypopup_first);
		tv.setTypeface(Typeface.createFromAsset(getAssets(), "NanumBarunGothic.ttf"));
		tv = (TextView)findViewById(R.id.text_result_mypopup_second);
		tv.setTypeface(Typeface.createFromAsset(getAssets(), "NanumBarunGothic.ttf"));		
		tv = (TextView)findViewById(R.id.text_result_mypopup_third);
		tv.setTypeface(Typeface.createFromAsset(getAssets(), "NanumBarunGothic.ttf"));
		
		
	}
	public void setOnClickListener() {
		Log.i("test", "sleepy..");
		ImageButton myImgBtn = (ImageButton) findViewById(R.id.imgBtn_result_my);
		myImgBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RelativeLayout myRelative = (RelativeLayout) findViewById(R.id.layout_result_my_popup);
				myRelative.setVisibility(View.VISIBLE);
			}
		});
	}
	
	public void setPopupClickListener(){
		Button popupNext = (Button)findViewById(R.id.imgBtn_result_mypopup_result);
		popupNext.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				RelativeLayout myRelative = (RelativeLayout) findViewById(R.id.layout_result_my_popup);
				myRelative.setVisibility(View.INVISIBLE);
				
			}
		});
	}

	public void colormapdraw(PointF[] inPoint, int fill_color) {
		PolygonOptions options = new PolygonOptions();
		for (int i = 0; i < inPoint.length; i++) {
			options.add(new LatLng(inPoint[i].x, inPoint[i].y));

		}

		options.strokeColor(Color.WHITE).strokeWidth((float) 3.0)
				.fillColor(fill_color);
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
					R.id.result_map);
			mmap = fragment.getMap();
			
			setMapCamera();

		}
	}

	private void setMapCamera() {
		LatLng startingPoint = null;

		switch (selectCityName) {
		case SEOUL:
			startingPoint = new LatLng(37.561241, 126.979582);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case INCHEON:
			startingPoint = new LatLng(37.501329, 126.667484);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case GYEONGGI_DO:
			startingPoint = new LatLng(37.268678, 127.021473);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case GANGWON_DO:
			startingPoint = new LatLng(37.913123, 127.897661);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case SEJONG:
			startingPoint = new LatLng(36.601181, 127.294313);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case CHUNGCHEONGNAM_DO:
			startingPoint = new LatLng(36.642577, 126.663617);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case DAEJEON:
			startingPoint = new LatLng(36.343795, 127.401412);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case CHUNGCHEONGBUK_DO:
			startingPoint = new LatLng(36.639403, 127.487243);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case JEOLLABUK_DO:
			startingPoint = new LatLng(35.818202, 127.487243);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case JEOLLANAM_DO:
			startingPoint = new LatLng(34.808654, 126.432053);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case GWANGJU:
			startingPoint = new LatLng(35.171488, 126.864640);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case JEJU:
			startingPoint = new LatLng(33.368577, 126.533320);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case GYEONGBUK:
			startingPoint = new LatLng(36.418275, 129.013365);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case DAEGU:
			startingPoint = new LatLng(35.870444, 128.586272);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case ULSAN:
			startingPoint = new LatLng(35.542595, 129.329222);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case GYEONGSANGNAM_DO:
			startingPoint = new LatLng(35.225473, 128.676697);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
			break;
		case BUSAN:
			startingPoint = new LatLng(35.177563, 129.078762);
			mmap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(startingPoint, 10));
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

	public class BackgroundParsingData extends
			AsyncTask<Object, String, SecondMapResponseData> {

		JSONObject response;
		PolygonOptions tmp; // background

		public BackgroundParsingData(JSONObject response) {
			this.response = response;
		}

		// 이 부분은 다른 쓰레드에서 실행된다.
		// 여기선 주로 계산을 한다.
		@Override
		protected SecondMapResponseData doInBackground(Object... arg0) {
			SecondMapResponseData resultData = null;

			try {
				// 파싱하는데 시간과 메모리가 많이 소요된다.
				resultData = RequestManager.responseParserSecondMap(response);

				// 지역 경계를 그린다.
				threadCnt = new AtomicInteger(resultData.rigions.length);
				threadCnt.addAndGet(resultData.oldRigions.length);

				// 자주색 지역 칠하기
				for (int i = 0; i < resultData.rigions.length; i++) {
					Log.i("test", "" + i);
					// Log.i("haha",
					// Double.toString(resultData.rigions[i].ratio));
					int fill_color = Color.WHITE;
					if (resultData.rigions[i].ratio <= 33.3) {
						fill_color = 0xAAFF4CB7;
					} else if (resultData.rigions[i].ratio <= 66.6) {
						fill_color = 0x99CC3399;
					} else {
						fill_color = 0x99990099;
					}

					// 지역 폴리곤을 그리는데 시간이 많이 걸리므로 이것 역시 새로운 쓰레드를 이용한다.
					new BackgroundDrawRegion(resultData.rigions[i].coords,
							fill_color).execute();
				}

				// 노란색 지역 칠하기
				for (int i = 0; i < resultData.oldRigions.length; i++) {
					// Log.i("haha",
					// Double.toString(resultData.rigions[i].ratio));
					int fill_color = Color.WHITE;
					if ((resultData.oldRigions[i].ratio > 30.0)
							&& (resultData.oldRigions[i].ratio <= 40.0)) {
						fill_color = 0X89FFFF66;
						/*
						 * colormapdraw(resultData.oldRigions[i].coords,
						 * fill_color);
						 */
					} else if ((resultData.oldRigions[i].ratio > 40.0)
							&& (resultData.oldRigions[i].ratio <= 50)) {
						fill_color = 0x88FFFF99;
						/*
						 * colormapdraw(resultData.oldRigions[i].coords,
						 * fill_color);
						 */
					}

					// 지역 폴리곤을 그리는데 시간이 많이 걸리므로 이것 역시 새로운 쓰레드를 이용한다.
					new BackgroundDrawRegion(resultData.oldRigions[i].coords,
							fill_color).execute();

				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return resultData;
		}

		// 이 부분은 메인 쓰레드에서 실행된다.
		// doInBackground 작업종료 후 호출된다.
		@Override
		protected void onPostExecute(SecondMapResponseData resultData) {

			// 배경그리기

			PolygonOptions tmp = new PolygonOptions();
			tmp.add(new LatLng(30, 120), new LatLng(50, 120), new LatLng(50,
					140), new LatLng(30, 140));
			tmp.strokeColor(Color.WHITE).fillColor(0x99FFFFFF);
			mmap.addPolygon(tmp);

			// 1,2,3위 marker
			MarkerOptions optSecond = new MarkerOptions();
			optSecond.position(resultData.rigions[1].centerLatLng);
			optSecond.icon(BitmapDescriptorFactory
					.fromResource(R.drawable.h_marker_1));
			mmap.addMarker(optSecond).showInfoWindow();

			optSecond.position(resultData.rigions[2].centerLatLng);
			optSecond.icon(BitmapDescriptorFactory
					.fromResource(R.drawable.h_maarker_2));
			mmap.addMarker(optSecond).showInfoWindow();

			optSecond.position(resultData.rigions[3].centerLatLng);
			optSecond.icon(BitmapDescriptorFactory
					.fromResource(R.drawable.h_maarker_3));
			mmap.addMarker(optSecond).showInfoWindow();

			mmap.moveCamera(CameraUpdateFactory.newLatLngZoom(
					resultData.rigions[1].centerLatLng, 10));
			/** END!!! */
		}

	}

	/**
	 * 지역경계를 다른 쓰레드에서 그린다.
	 * 
	 * @author root
	 * 
	 */
	public class BackgroundDrawRegion extends AsyncTask<Object, String, String> {

		int fill_color; // color
		PointF[] point; // point
		PolygonOptions region; // region

		public BackgroundDrawRegion(PointF[] point, int fill_color) {
			this.point = point;
			this.fill_color = fill_color;
		}

		@Override
		protected String doInBackground(Object... params) {
			region = getColormapOptions(point, fill_color);
			return null;
		}

		protected void onPostExecute(String result) {
			// view는 메인 쓰레드에서만 조작할 수 있기 때문에 이렇게 만든거.
			mmap.addPolygon(region);
			// 모든 쓰레드를 처리한 상황을 체크해고, 모든 쓰레드가 끝났으면
			if (threadCnt.decrementAndGet() == 0) {
				// view는 메인 쓰레드에서만 조작할 수 있기 때문에 이렇게 만든거.
				RelativeLayout loadingLayout = (RelativeLayout) findViewById(R.id.layout_result_loading_page);
				loadingLayout.setVisibility(View.INVISIBLE);
			}
		}

	}

	/**
	 * 경계를 표현하기 위한 유틸성 메소드
	 * 
	 * @param inPoint
	 * @param fill_color
	 * @return
	 */
	private PolygonOptions getColormapOptions(PointF[] inPoint, int fill_color) {
		PolygonOptions options = new PolygonOptions();
		for (int i = 0; i < inPoint.length; i++) {
			options.add(new LatLng(inPoint[i].x, inPoint[i].y));

		}

		options.strokeColor(Color.WHITE).strokeWidth((float) 3.0)
				.fillColor(fill_color);
		return options;
	}
}
