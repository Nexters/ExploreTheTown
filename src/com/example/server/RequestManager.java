package com.example.server;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.JsonHttpResponseHandler;

public class RequestManager {
	private ResponseData responseOne;
	
	
	
	private String requestFormatter(String relUrl, String cd, String req_svc) throws UnsupportedEncodingException{
		return relUrl + "/?JSONData=" +    
		        URLEncoder.encode("{\"req_data\":[{\"_cd\":\"" + cd +
						"\"}],\"req_svc\":\"" + req_svc +
						"\"}", "UTF-8");
	}
	private void responseParser(JSONObject responseData) throws JSONException{
		JSONArray res_data = responseData.getJSONArray("res_data");
		JSONObject component = res_data.getJSONObject(0);
		
		String cdValue = component.get("_cd").toString();
		String cntValue = component.get("_cnt").toString();
		String itemValue = component.get("_item").toString();
		responseOne.setCDValue(cdValue);
		responseOne.setCntValue(cntValue);
		responseOne.setItemValue(itemValue);
	}
	public boolean sendRequest(String relUrl, String cd, String req_svc){
		String requestURL;
		try {
			requestURL = requestFormatter(relUrl, cd, req_svc);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return false;
		}
		 RequestClient.get(requestURL, null, new JsonHttpResponseHandler() {
	        	
	            @Override
	            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
	            	try {
	            		responseParser(response);
	            		
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	            
	        });
		return false;
	}
	
	public ResponseData getResponseOne(){
		return responseOne;
	}
}
