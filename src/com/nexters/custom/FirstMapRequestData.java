package com.nexters.custom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.model.LatLng;
import com.nexters.coord.CoordConverter;
import com.nexters.coord.PointF;

public class FirstMapRequestData {
	public int totalCnt;
	public RegionData[] rigions;
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
			
			rigions = new RegionData[region_data_arr.length()];
			
			for(int i = 0 ; i < region_data_arr.length() ; i++){
				rigions[i] = new RegionData();
				JSONObject objJSON = region_data_arr.getJSONObject(i);
				rigions[i].cd = objJSON.getString("_cd");
				rigions[i].ratio = objJSON.getDouble("_ratio");
				rigions[i].address = objJSON.getString("_address");
				if(rigions[i].ratio <= 30){
					top30Cds.put(rigions[i].cd);
				}
				rigions[i].rank = objJSON.getInt("_rank");
				String location = objJSON.getString("_location");
				parseCoord(location,i);

			}
			
			top30CdStr = top30Cds.toString();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void parseCoord(String inStr, int inI) throws JSONException{
		JSONArray jsonArr = new JSONArray(inStr);
		JSONArray coordsArrJson = jsonArr.getJSONArray(0);
		double mxSum = 0;
		double mySum = 0;
		
		rigions[inI].coords = new PointF[coordsArrJson.length()];
		for(int i = 0 ; i < rigions[inI].coords.length ; i++){
			JSONArray nowCoord = coordsArrJson.getJSONArray(i);
			double mx = nowCoord.getDouble(0);
			double my = nowCoord.getDouble(1);
			mxSum += mx;
			mySum += my;
			rigions[inI].coords[i] = new PointF(mx, my);
		}
		int size = coordsArrJson.length();
		rigions[inI].centerLatLng = new LatLng(mxSum/size, mySum/size);
	}
}
