package com.ionix.prueba.models.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class JsonApiExterna implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6232555049240961048L;
	private int responseCode;
	private String description;
	private int elapsedTime;
	private Map<Object, Object> result;
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getElapsedTime() {
		return elapsedTime;
	}
	public void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	public Map<Object, Object> getResult() {
		return result;
	}
	public void setResult(Map<Object, Object> result) {
		this.result = result;
	}

	
	
}
