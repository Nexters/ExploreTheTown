package com.nexters.custom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.nexters.coord.CoordConverter;
import com.nexters.coord.PointF;

public class SecondMapResponseData {
	public int totalCnt;
	public RegionData[] rigions;
	public RegionData[] oldRigions;
	public String top30CdStr;
	CoordConverter converter = new CoordConverter();
	
	public void parseAndSaveData(JSONObject inJson){
		JSONArray res_data;
		Log.i("test","parse2");
		try {
			Log.i("test","parse");
			res_data = inJson.getJSONArray("res_data");
			JSONObject res_data_obj = res_data.getJSONObject(0);
			
			totalCnt = res_data_obj.getInt("_totCnt");
			JSONArray region_data_arr = res_data_obj.getJSONArray("_rslt");
			
			rigions = new RegionData[region_data_arr.length()];
			Log.i("regisonSize : ", ""+rigions.length);
			for(int i = 0 ; i < region_data_arr.length() ; i++){
				rigions[i] = new RegionData();
				JSONObject objJSON = region_data_arr.getJSONObject(i);
				rigions[i].cd = objJSON.getString("_cd");
				rigions[i].ratio = objJSON.getDouble("_ratio");
				rigions[i].rank = objJSON.getInt("_rank");
				String location = objJSON.getString("_location");
				parseCoord(location,i);

			}
			JSONArray oldregion_data_arr = res_data_obj.getJSONArray("_old_rslt");
						
			oldRigions = new RegionData[oldregion_data_arr.length()];
			
			for(int i = 0 ; i < oldregion_data_arr.length() ; i++){
				
				oldRigions[i] = new RegionData();
				JSONObject objJSON = oldregion_data_arr.getJSONObject(i);
				oldRigions[i].cd = objJSON.getString("_cd");
				oldRigions[i].ratio = objJSON.getDouble("_ratio");
				oldRigions[i].rank = objJSON.getInt("_rank");
				String location = objJSON.getString("_location");
				parseCoordOld(location,i);

			}
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void parseCoord(String inStr, int inI) throws JSONException{
		JSONArray jsonArr = new JSONArray(inStr);
		JSONArray coordsArrJson = jsonArr.getJSONArray(0);
		
		rigions[inI].coords = new PointF[coordsArrJson.length()];
		for(int i = 0 ; i < rigions[inI].coords.length ; i++){
			JSONArray nowCoord = coordsArrJson.getJSONArray(i);
			double mx = nowCoord.getDouble(0);
			double my = nowCoord.getDouble(1);
			rigions[inI].coords[i] = new PointF(mx, my);
		}
	}
	private void parseCoordOld(String inStr, int inI) throws JSONException{
		JSONArray jsonArr = new JSONArray(inStr);
		JSONArray coordsArrJson = jsonArr.getJSONArray(0);
		
		oldRigions[inI].coords = new PointF[coordsArrJson.length()];
		for(int i = 0 ; i < oldRigions[inI].coords.length ; i++){
			JSONArray nowCoord = coordsArrJson.getJSONArray(i);
			double mx = nowCoord.getDouble(0);
			double my = nowCoord.getDouble(1);
			oldRigions[inI].coords[i] = new PointF(mx, my);
		}
	}
}
