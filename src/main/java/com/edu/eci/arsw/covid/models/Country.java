package com.edu.eci.arsw.covid.models;

import java.io.Serializable; 

public class Country{

   
	String country;
    int confirmed;
    int deaths;
    int recovered;

    public Country(){

    }

    public Country(String country, int confirmed, int deaths, int recovered){
        this.country = country;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public void sumConfirmed(int data){
        this.confirmed += data;
    }

    public void sumDeaths(int data){
        this.deaths += data;
    }

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getRecovered() {
		return recovered;
	}

	public void setRecovered(int recovered) {
		this.recovered = recovered;
    }
    
    public void sumRecovered(int data){
        this.recovered += data;
    }

    


}