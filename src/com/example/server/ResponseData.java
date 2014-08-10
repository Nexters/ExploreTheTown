package com.example.server;

public class ResponseData {
	private String cdValue;
	private String cntValue;
	private String itemValue;
	
	public void setCDValue(String cdValue){
		this.cdValue = cdValue;
	}
	public String getCDValue(){
		return cdValue;
	}
	public void setCntValue(String cntValue){
		this.cntValue = cntValue;
	}
	public String getCntValue(){
		return cntValue;
	}
	public void setItemValue(String itemValue){
		this.itemValue = itemValue;
	}
	public String getItemValue(){
		return itemValue;
	}

}
