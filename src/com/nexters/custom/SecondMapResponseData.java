package com.nexters.custom;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.nexters.coord.CoordConverter;
import com.nexters.coord.PointF;

public class SecondMapResponseData {
	public int totalCnt;
	public HashMap<String, RegionData> regionMap = new HashMap<String, RegionData>();
	public String top30CdStr;
	public String firstCD;
	public String secondCD;
	public String thirdCD;
	public int newRegionCnt;
	CoordConverter converter = new CoordConverter();
	
	public void parseAndSaveData(JSONObject inJson){
		JSONArray res_data;
		try {
			res_data = inJson.getJSONArray("res_data");
			JSONObject res_data_obj = res_data.getJSONObject(0);
			
			totalCnt = res_data_obj.getInt("_totCnt");
			JSONArray region_data_arr = res_data_obj.getJSONArray("_rslt");
			
			JSONArray oldregion_data_arr = res_data_obj.getJSONArray("_old_rslt");
			
			RegionData oldRigions = null;
			
			for(int i = 0 ; i < oldregion_data_arr.length() ; i++){
				oldRigions = new RegionData();

				JSONObject objJSON = oldregion_data_arr.getJSONObject(i);
				oldRigions.cd = objJSON.getString("_cd");
				oldRigions.ratio = objJSON.getDouble("_ratio");
				oldRigions.rank = objJSON.getInt("_rank");
				oldRigions.address = objJSON.getString("_address");
				String location = objJSON.getString("_location");
				parseCoordOld(location,i, oldRigions);
				
				if(oldRigions.ratio <= 10.0){
					oldRigions.backgroundColor = 0xAAFF9900;
				}else if(oldRigions.ratio <= 20.0){
					oldRigions.backgroundColor = 0x99FFCC00;
				}else if(oldRigions.ratio <= 30.0){
					oldRigions.backgroundColor = 0x90FFFF33;
				}else if(oldRigions.ratio <= 40.0){
					oldRigions.backgroundColor = 0x89FFFF66;
				}else{
					oldRigions.backgroundColor = 0x88FFFF99;
				}
				
				//set score by item.
				//rigions.scoreMap
				JSONObject valObject = objJSON.getJSONObject("_val");
				Iterator<String> it = valObject.keys();
				while(it.hasNext()){
					try{
						String valueKey = it.next();	//item.
						String value = valObject.getString(valueKey);
						double valueD = Double.parseDouble(value);
						int valueI = (int) (valueD * 100);
						oldRigions.scoreMap.put(valueKey, valueI);
						Log.i("value", valueKey +","+valueI);
					}catch(Exception e){
						
					}
				}
				
				regionMap.put(oldRigions.cd, oldRigions);
			}
			
			newRegionCnt = region_data_arr.length();
			RegionData rigions = null;
			for(int i = 0 ; i < region_data_arr.length() ; i++){
				rigions = new RegionData();
				JSONObject objJSON = region_data_arr.getJSONObject(i);
				rigions.cd = objJSON.getString("_cd");
				rigions.ratio = objJSON.getDouble("_ratio");
				rigions.rank = objJSON.getInt("_rank");
				String location = objJSON.getString("_location");
				rigions.address = objJSON.getString("_address");
				parseCoord(location,i, rigions);
				
				if(rigions.ratio <= 15){
					rigions.backgroundColor = 0xAA660066;
				}else if(rigions.ratio <= 30){
					rigions.backgroundColor = 0x99CC0099;
				}else{
					rigions.backgroundColor= 0x99FF33CC;
				}
				

				
				//add attr
				if(regionMap.containsKey(rigions.cd)){
					RegionData temp = regionMap.get(rigions.cd);
					for(Entry<String, Integer> e : temp.scoreMap.entrySet()){
						rigions.scoreMap.put(e.getKey(), e.getValue());
					}
					//rigions.scoreMap.put("line", 0);
				}
				
				//set score by item.
				//rigions.scoreMap
				JSONObject valObject = objJSON.getJSONObject("_val");
				Iterator<String> it = valObject.keys();
				while(it.hasNext()){
					try{
						String valueKey = it.next();	//item.
						String value = valObject.getString(valueKey);
						double valueD = Double.parseDouble(value);
						int valueI = (int) (valueD * 100);
						rigions.scoreMap.put(valueKey, valueI);
						Log.i("value", valueKey +","+valueI);
					}catch(Exception e){
						
					}
				}
				
				regionMap.put(rigions.cd, rigions);
			}

			// 1,2,3위 CD 저장하기
			JSONObject tmpJSON = region_data_arr.getJSONObject(0);
			firstCD = tmpJSON.getString("_cd");
			tmpJSON = region_data_arr.getJSONObject(1);
			secondCD = tmpJSON.getString("_cd");
			tmpJSON = region_data_arr.getJSONObject(2);
			thirdCD = tmpJSON.getString("_cd");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void parseCoord(String inStr, int inI, RegionData inRigions) throws JSONException{
		JSONArray jsonArr = new JSONArray(inStr);
		JSONArray coordsArrJson = jsonArr.getJSONArray(0);
		double mxSum = 0;
		double mySum = 0;
		
		inRigions.coords = new PointF[coordsArrJson.length()];
		for(int i = 0 ; i < inRigions.coords.length ; i++){
			JSONArray nowCoord = coordsArrJson.getJSONArray(i);
			double mx = nowCoord.getDouble(0);
			double my = nowCoord.getDouble(1);
			mxSum += mx;
			mySum += my;
			inRigions.coords[i] = new PointF(mx, my);
		}
		int size = coordsArrJson.length();
		inRigions.centerLatLng = new LatLng(mxSum/size, mySum/size);
	}
	private void parseCoordOld(String inStr, int inI, RegionData inRigions) throws JSONException{
		JSONArray jsonArr = new JSONArray(inStr);
		JSONArray coordsArrJson = jsonArr.getJSONArray(0);
		double mxSum = 0;
		double mySum = 0;
		
		inRigions.coords = new PointF[coordsArrJson.length()];
		for(int i = 0 ; i < inRigions.coords.length ; i++){
			JSONArray nowCoord = coordsArrJson.getJSONArray(i);
			double mx = nowCoord.getDouble(0);
			double my = nowCoord.getDouble(1);
			mxSum += mx;
			mySum += my;
			inRigions.coords[i] = new PointF(mx, my);
		}
		int size = coordsArrJson.length();
		inRigions.centerLatLng = new LatLng(mxSum/size, mySum/size);
	}
}
