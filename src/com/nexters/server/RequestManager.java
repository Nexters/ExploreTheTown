package com.nexters.server;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.nexters.custom.FirstMapAnswerData;
import com.nexters.custom.FirstMapRequestData;
import com.nexters.custom.SecondMapResponseData;

public class RequestManager {

	@SuppressWarnings("deprecation")
	private static String requestFormatterForFirstMap(String relUrl, FirstMapAnswerData answerData)
			throws UnsupportedEncodingException, JSONException {
		
		String[] data = answerData.requestData;
		String cd = answerData.cd;
		String req_svc = answerData.req_svc;
		
		JSONObject resultJson = new JSONObject();
		JSONObject reqDataObject = new JSONObject();
		JSONArray itemCodeArr = new JSONArray();
		JSONArray reqDataArr = new JSONArray();
		for(int i = 0 ; i < data.length ; i++){
			itemCodeArr.put(data[i]);
		}
		
		JSONArray tmp = new JSONArray();
		reqDataObject.put("_cd", cd);
		reqDataObject.put("_cond_cd", itemCodeArr);
		reqDataObject.put("_ne_cond_cd", tmp);
		reqDataArr.put(reqDataObject);
		resultJson.put("req_data", reqDataArr);
		resultJson.put("req_svc", req_svc);
		
		
		return relUrl
				+ "/?JSONData="
				+ URLEncoder.encode(resultJson.toString());
	}

	public static FirstMapRequestData responseParserFirstMap(JSONObject responseData)
			throws JSONException {
		FirstMapRequestData returnData = new FirstMapRequestData();
		returnData.parseAndSaveData(responseData);

		return returnData;
	}


	public static boolean sendRequestForFirstMap(String relUrl, FirstMapAnswerData answerData,
			JsonHttpResponseHandler handler) throws JSONException {
		String requestURL;
		try {
			requestURL = requestFormatterForFirstMap(relUrl, answerData);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		RequestClient.get(requestURL, null, handler);
		return true;
	}
	
	public static boolean sendRequestForSecondMap(String relUrl, String neighborStr, String houseStr, String areaStr, String cd, String oldCond,
			JsonHttpResponseHandler handler) throws JSONException{
		String requestURL;
		try {
			requestURL = requestFormatterForSecondMap(relUrl, neighborStr, houseStr, areaStr, cd, oldCond);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		RequestClient.get(requestURL, null, handler);
		
		return true;
	}
	
	public static String requestFormatterForSecondMap(String relUrl, String neighborStr, String houseStr, String areaStr, String cd, String oldCond)
				throws UnsupportedEncodingException, JSONException {	


		JSONObject resultJson = new JSONObject();
		JSONArray req_dataArr = new JSONArray();
		JSONObject req_dataObj = new JSONObject();
		JSONObject old_reqObj = new JSONObject();
		
		JSONArray old_cnd = new JSONArray(oldCond);
		old_reqObj.put("_cd", cd);
		old_reqObj.put("_cond_cd", old_cnd);
		old_reqObj.put("_ne_cond_cd", new JSONArray());
		
		JSONObject neighborObject = new JSONObject(neighborStr);
		JSONArray cdArray = new JSONArray(areaStr);
		
		JSONArray houseArray = new JSONArray(houseStr);
		req_dataObj.put("_old_req", old_reqObj);
		Log.i("test","formatter3");
		req_dataObj.put("_nebor_d", neighborObject);
		req_dataObj.put("_area_cd", cdArray);
		Log.i("test","formatter2");
		req_dataObj.put("_cond_cd", houseArray);
		req_dataObj.put("_ne_cond_cd", new JSONArray());
		
		req_dataArr.put(req_dataObj);
		Log.i("test","formatter");
		resultJson.put("req_data", req_dataArr);
		resultJson.put("req_svc", "LC0006");
		
		Log.i("resultJSon", resultJson.toString());
		return relUrl
				+ "/?JSONData="
				+ URLEncoder.encode(resultJson.toString());
	}
	public static SecondMapResponseData responseParserSecondMap(JSONObject responseData)
			throws JSONException {
		SecondMapResponseData returnData = new SecondMapResponseData();
		returnData.parseAndSaveData(responseData);

		return returnData;
	}
}
