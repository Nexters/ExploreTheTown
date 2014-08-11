package com.nexters.explorethetown;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ResultActivity extends ActionBarActivity implements OnMarkerClickListener{

	private GoogleMap mmap;
	MapFragment fragment;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		
		// Hidden Action Bar
		ActionBar actionBar = getActionBar();
		actionBar.hide();
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
