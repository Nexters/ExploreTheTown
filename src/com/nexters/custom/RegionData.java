package com.nexters.custom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.model.LatLng;
import com.nexters.coord.CoordConverter;
import com.nexters.coord.PointF;

public class RegionData {
	public String cd = "";
	public double ratio = 0;
	public double sum = 0;
	public PointF[] coords;
	public int rank;
	public LatLng centerLatLng;
	public String address;
	public int backgroundColor;
	public void setCD(String cd){
		this.cd = cd;
	}
	public void setRatio(double ratio){
		this.ratio = ratio;
	}
	public void setSum(double sum){
		this.sum = sum;
	}


	
}
