package com.nexters.server;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.nexters.custom.FirstMapAnswerData;
import com.nexters.custom.FirstMapRequestData;

public class RequestManager {

	@SuppressWarnings("deprecation")
	private static String requestFormatter(String relUrl, FirstMapAnswerData answerData)
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

	public static FirstMapRequestData responseParser(JSONObject responseData)
			throws JSONException {
		FirstMapRequestData returnData = new FirstMapRequestData();
		returnData.parseAndSaveData(responseData);

		return returnData;
	}

	public static boolean sendRequest(String relUrl, FirstMapAnswerData answerData,
			JsonHttpResponseHandler handler) throws JSONException {
		String requestURL;
		try {
			requestURL = requestFormatter(relUrl, answerData);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		RequestClient.get(requestURL, null, handler);
		return false;
	}
}
