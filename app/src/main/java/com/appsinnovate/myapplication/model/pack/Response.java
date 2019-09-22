package com.appsinnovate.myapplication.model.pack;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@SerializedName("continent")
	private Continent continent;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setContinent(Continent continent){
		this.continent = continent;
	}

	public Continent getContinent(){
		return continent;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"continent = '" + continent + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}