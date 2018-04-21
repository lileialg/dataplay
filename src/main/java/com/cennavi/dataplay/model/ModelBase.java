package com.cennavi.dataplay.model;

import com.alibaba.fastjson.JSONObject;

public class ModelBase {

	private int id;
	
	private String name;
	
	private JSONObject jsonObj;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}
	
	
}
