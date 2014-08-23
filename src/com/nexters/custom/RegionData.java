package com.nexters.custom;

import java.util.HashMap;
import java.util.Map;

import com.google.android.gms.maps.model.LatLng;
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
	public Map<String, Integer> scoreMap;

	public RegionData() {
		scoreMap = new HashMap<String, Integer>();
	}

	public void setCD(String cd) {
		this.cd = cd;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

}
