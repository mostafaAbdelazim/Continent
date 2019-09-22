package com.appsinnovate.myapplication.model.pack;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Continent{

	@SerializedName("continent_name")
	private String continentName;

	@SerializedName("id")
	private int id;

	@SerializedName("countries")
	private List<CountriesItem> countries;

	public void setContinentName(String continentName){
		this.continentName = continentName;
	}

	public String getContinentName(){
		return continentName;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCountries(List<CountriesItem> countries){
		this.countries = countries;
	}

	public List<CountriesItem> getCountries(){
		return countries;
	}

	@Override
 	public String toString(){
		return 
			"Continent{" + 
			"continent_name = '" + continentName + '\'' + 
			",id = '" + id + '\'' + 
			",countries = '" + countries + '\'' + 
			"}";
		}
}