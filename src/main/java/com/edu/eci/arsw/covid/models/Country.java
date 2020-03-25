package com.edu.eci.arsw.covid.models;

import java.io.Serializable; 


public class Country{

   
	String country;
    int confirmed;
    int deaths;
    int recovered;

    public Country(){

    }


    /**
     * Constructor de la clase country
     * @param country Nombre del pais
     * @param confirmed confirmed
     * @param deaths deaths
     * @param recovered recovered
     */
    public Country(String country, int confirmed, int deaths, int recovered){
        this.country = country;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    /**
     * Incrementa los valores de "Confirmed"
     * @param data dato a sumar
     */
    public void sumConfirmed(int data){
        this.confirmed += data;
    }

    /**
     * Incrementa los valores de "Deaths"
     * @param data dato a sumar
     */
    public void sumDeaths(int data){
        this.deaths += data;
    }


    /**
     * Incrementar valores de "Country"
     * @return Strign con el nombre del pais
     */
	public String getCountry() {
		return country;
    }
    

    /**
     * Asignar nombre de pais
     * @param country Nombre del pais
     */
	public void setCountry(String country) {
		this.country = country;
    }
    
    /**
     * Obtener "Confined" del pais
     * @return confirmen del pais
     */
	public int getConfirmed() {
		return confirmed;
	}


    /**
     * Asignar "confinded" del pois
     * @param confirmed valor a aumentar
     */
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}


    /**
     * btener "Deaths" del pais
     * @return deaths del pais
     */
	public int getDeaths() {
		return deaths;
	}

    /**
     * Aisgnar "Deaths" del pais
     * @param deaths valor a asignar
     */
	public void setDeaths(int deaths) {
		this.deaths = deaths;
    }
    
    /**
     * Obtener "Recovered" del pais
     * @return Recovered del pais
     */
	public int getRecovered() {
		return recovered;
	}


    /**
     * Asignar "recovered" del pais
     * @param recovered valor a asignar
     */
	public void setRecovered(int recovered) {
		this.recovered = recovered;
    }
    

    /**
     * Incrementar "recovered" del pais
     * @param data valor a aumentar
     */
    public void sumRecovered(int data){
        this.recovered += data;
    }

    


}