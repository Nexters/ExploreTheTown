package com.nexters.custom;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.nexters.coord.CoordConverter;
import com.nexters.coord.PointF;

public class FirstMapRequestData {
	public int totalCnt;
	public HashMap<String,RegionData> regionMap = new HashMap<String,RegionData>();
	public String top30CdStr;
	CoordConverter converter = new CoordConverter();
	
	public void parseAndSaveData(JSONObject inJson){
		JSONArray res_data;
		JSONArray top30Cds;
		try {
			top30Cds = new JSONArray();
			res_data = inJson.getJSONArray("res_data");
			JSONObject res_data_obj = res_data.getJSONObject(0);
			
			totalCnt = res_data_obj.getInt("_totCnt");
			JSONArray region_data_arr = res_data_obj.getJSONArray("_rslt");
			
			Log.i("request total check",region_data_arr.length()+"");
			
			
			for(int i = 0 ; i < region_data_arr.length() ; i++){
				RegionData rigions = new RegionData();
				JSONObject objJSON = region_data_arr.getJSONObject(i);
				rigions.cd = objJSON.getString("_cd");
				rigions.ratio = objJSON.getDouble("_ratio");
				rigions.address = objJSON.getString("_address");
				if(rigions.ratio <= 30){
					top30Cds.put(rigions.cd);
				}
				rigions.rank = objJSON.getInt("_rank");
				String location = objJSON.getString("_location");
				Log.i("request for check",i+"");
				parseCoord(location,rigions);
				
				regionMap.put(rigions.cd, rigions);

			}
			Log.i("first map total cnt",regionMap.size()+"");
			Log.i("top 30 cds json arry",top30Cds.toString());
			top30CdStr = top30Cds.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void parseCoord(String inStr,  RegionData rigions) throws JSONException{
		JSONArray jsonArr = new JSONArray(inStr);
		JSONArray coordsArrJson = jsonArr.getJSONArray(0);
		double mxSum = 0;
		double mySum = 0;
		
		rigions.coords = new PointF[coordsArrJson.length()];
		for(int i = 0 ; i < rigions.coords.length ; i++){
			JSONArray nowCoord = coordsArrJson.getJSONArray(i);
			double mx = nowCoord.getDouble(0);
			double my = nowCoord.getDouble(1);
			mxSum += mx;
			mySum += my;
			rigions.coords[i] = new PointF(mx, my);
		}
		int size = coordsArrJson.length();
		rigions.centerLatLng = new LatLng(mxSum/size, mySum/size);
	}
}
