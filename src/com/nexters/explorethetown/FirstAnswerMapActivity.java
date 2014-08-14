// http://androidhuman.tistory.com/518
// Google Map V2 �뜝�럡�뀬�뜝�럩�뮔�뛾�렮維뽬떋占�
//http://biig.tistory.com/24 �뜝�럥�뿰�뼨轅명�←뙴袁с럶占쎈た占쏙옙

//http://developer.android.com/reference/com/google/android/gms/maps/model/Polygon.html
// 嶺뚯쉻�삕�뜝�럥利� �뜝�럩留꾢뜝�럥�뱺 �뜝�럥利꿨뜝�럩援� �윜諛몄굡占쎈뉴�뜝�럥裕됪ㅀ袁ъ삕 �뜝�럥�뿰�뼨轅명�ｈ땻占� 嶺뚣�볝늾占쏙옙..?

package com.nexters.explorethetown;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
import com.nexters.custom.FirstMapAnswerData;
import com.nexters.custom.FirstMapRequestData;
import com.nexters.server.RequestManager;

public class FirstAnswerMapActivity extends ActionBarActivity implements
		OnMarkerClickListener {
	private GoogleMap mmap;
	MapFragment fragment;
	ProgressBar loadingBar;
	private Marker nowMarker;
	private Marker beforeMarker;
	CityName selectCityName;
	

	Marker[] cityMarker;

	FirstMapRequestData resultData;


	JSONArray answersCode = null;
	JSONArray answersNoCode = null;
	/* 지역경계를 그리기 위해 실행한 쓰레드 개수를 세고, 모든 쓰레드의 실행이 끝난 시점을 체크하기 위한 변수. */
	public static AtomicInteger threadCnt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_answer_map);

		loadingBar = (ProgressBar) findViewById(R.id.progressBar_first_answer);

		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();

		Intent iIntent = getIntent();
		selectCityName = (CityName) iIntent.getSerializableExtra("SELECT_CITY");

		try {
			answersCode = new JSONArray(iIntent.getStringExtra("SELECT_RESULT"));
			answersNoCode = new JSONArray(iIntent.getStringExtra("NO_SELECT_RESULT"));
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		

		FirstMapAnswerData answerData = new FirstMapAnswerData();
		answerData.cd = "11";
		answerData.req_svc = "LC0005";
		answerData.answerCode  = answersCode;
		answerData.answerNoCode = answersNoCode;

		switch (selectCityName) {
		case SEOUL:
			answerData.cd = "11";
			break;
		case INCHEON:
			answerData.cd = "23";
			break;
		case GYEONGGI_DO:
			answerData.cd = "31";
			break;
		case GANGWON_DO:
			answerData.cd = "32";
			break;
		case SEJONG:
		case CHUNGCHEONGNAM_DO:
			answerData.cd = "34";
			break;
		case DAEJEON:
			answerData.cd = "25";
			break;
		case CHUNGCHEONGBUK_DO:
			answerData.cd = "33";
			break;
		case JEOLLABUK_DO:
			answerData.cd = "35";
			break;
		case JEOLLANAM_DO:
			answerData.cd = "36";
			break;
		case GWANGJU:
			answerData.cd = "24";
			break;
		case JEJU:
			answerData.cd = "39";
			break;
		case GYEONGBUK:
			answerData.cd = "37";
			break;
		case DAEGU:
			answerData.cd = "22";
			break;
		case ULSAN:
			answerData.cd = "26";
			break;
		case GYEONGSANGNAM_DO:
			answerData.cd = "38";
			break;
		case BUSAN:
			answerData.cd = "21";
			break;
		}




		
		// Server Request

		try {
			RequestManager.sendRequestForFirstMap("house_gateway", answerData,
					new JsonHttpResponseHandler() {
						@Override
						public void onSuccess(int statusCode, Header[] headers,
								JSONObject response) {

							// 서버에서 받아온 데이터를 메인 쓰레드가 아닌 새로운 쓰레드에서 처리한다.
							new BackgroundParsingData(response).execute();
						}
					});
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
				iIntent.putExtra("FIRST_COND", answersCode.toString());
				iIntent.putExtra("FIRST_NE_COND", answersNoCode.toString());
				iIntent.putExtra("SELECT_CITY", selectCityName);
				startActivity(iIntent);
				finish();

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case 0:
			setUpMapIfNeeded();
			break;
		}
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
					R.id.map);
			mmap = fragment.getMap();
			mmap.setOnMarkerClickListener(this);
			setMapCamera();
			
			PolygonOptions tmp; // background
			// 일단 배경을 흰색으로 칠함
			tmp = new PolygonOptions();
			tmp.add(new LatLng(30, 120), new LatLng(50, 120), new LatLng(50,
					140), new LatLng(30, 140));
			tmp.strokeColor(Color.WHITE).fillColor(0x99FFFFFF);
			// view는 메인 쓰레드에서만 조작할 수 있기 때문에 이렇게 만든거.
			mmap.addPolygon(tmp);

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
		for(int i =0 ; i < resultData.rigions.length ; i++){
			if(arg0.equals(cityMarker[i])){
				//cityMarker[i].setIcon(BitmapDescriptorFactory
				//		.fromResource(R.drawable.h_marker_0));
				Toast toast = Toast.makeText(FirstAnswerMapActivity.this, resultData.rigions[i].address, Toast.LENGTH_SHORT);
				toast.show();
				break;
			}
		}
		
		
		return false;
	}

	public class BackgroundParsingData extends
			AsyncTask<Object, String, String> {

		JSONObject response;// 서버에서 받아온 문자열


		public BackgroundParsingData(JSONObject response) {
			this.response = response;
		}

		// 이 부분은 다른 쓰레드에서 실행된다.
		// 여기선 주로 계산을 한다.
		@Override
		protected String doInBackground(Object... arg0) {

			try {
				// 파싱하는데 시간과 메모리가 많이 소요된다.
				resultData = RequestManager.responseParserFirstMap(response);
				cityMarker = new Marker[resultData.rigions.length];
				// 지역 경계를 그린다.
				threadCnt = new AtomicInteger(resultData.rigions.length);
				for (int i = 0; i < resultData.rigions.length; i++) {
					int fill_color = Color.WHITE;
					if (resultData.rigions[i].ratio <= 10.0) {
						fill_color = 0xAAFF9900;
					} else if (resultData.rigions[i].ratio <= 20.0) {
						fill_color = 0x99FFCC00;
					} else if (resultData.rigions[i].ratio <= 30.0) {
						fill_color = 0x90FFFF33;
					} else if (resultData.rigions[i].ratio <= 40.0) {
						fill_color = 0X89FFFF66;
					} else {
						fill_color = 0x88FFFF99;
					}

					// 지역 폴리곤을 그리는데 시간이 많이 걸리므로 이것 역시 새로운 쓰레드를 이용한다.
					new BackgroundDrawRegion(resultData.rigions[i].coords,
							fill_color, resultData.rigions[i].centerLatLng).execute();
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}

		// 이 부분은 메인 쓰레드에서 실행된다.
		// doInBackground 작업종료 후 호출된다.
		@Override
		protected void onPostExecute(String result) {



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
		LatLng centerLatLng;
		MarkerOptions optSecond;

		public BackgroundDrawRegion(PointF[] point, int fill_color, LatLng inLatLng) {
			this.point = point;
			this.fill_color = fill_color;
			centerLatLng = inLatLng;
		}
		@Override
		protected String doInBackground(Object... params) {
			region = getColormapOptions(point, fill_color);

			return null;
		}

		protected void onPostExecute(String result) {
			// view는 메인 쓰레드에서만 조작할 수 있기 때문에 이렇게 만든거.
			mmap.addPolygon(region);
			// marker 추가하기
			optSecond = new MarkerOptions();
			optSecond.position(centerLatLng);
			optSecond.icon(BitmapDescriptorFactory
					.fromResource(R.drawable.h_marker_empty));
			cityMarker[resultData.rigions.length - threadCnt.intValue()] = mmap.addMarker(optSecond);
			//TODO
			//모든 쓰레드를 처리한 상황을 체크해고, 모든 쓰레드가 끝났으면 
			if (threadCnt.decrementAndGet() == 0) {
				// view는 메인 쓰레드에서만 조작할 수 있기 때문에 이렇게 만든거.
				RelativeLayout loadingLayout = (RelativeLayout) findViewById(R.id.layout_loading_page);
				loadingLayout.setVisibility(View.INVISIBLE);
				setOnClickListener();
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
