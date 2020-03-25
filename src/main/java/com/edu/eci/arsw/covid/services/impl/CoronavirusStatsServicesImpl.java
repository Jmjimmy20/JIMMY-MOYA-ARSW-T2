package com.edu.eci.arsw.covid.services.impl;

import java.util.HashMap;

import com.edu.eci.arsw.covid.models.Country;
import com.edu.eci.arsw.covid.persistance.CoronavirusStatsCache;
import com.edu.eci.arsw.covid.services.CoronavirusStatsServices;
import com.edu.eci.arsw.covid.services.HttpConnectionService;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoronavirusStatsServicesImpl implements CoronavirusStatsServices{

    @Autowired
    HttpConnectionService httpCS;
    @Autowired
    CoronavirusStatsCache cacheP;
    String paises;


    @Override
    public HashMap<String, Country> getCountries() {
        HashMap <String, Country> datos = new HashMap<String, Country>();
        try{  
            paises = httpCS.getAllCou();
            JSONObject json = new JSONObject(paises);
            JSONArray jArray = json.getJSONObject("data").getJSONArray("covid19Stats");
            for(int i =0 ; i<jArray.length();i++){
                JSONObject aux = jArray.getJSONObject(i);
                if(datos.get(aux.getString("country"))!=null){
                    Country temporal = datos.get(aux.getString("country"));
                    temporal.sumConfirmed(aux.getInt("confirmed"));
                    temporal.sumDeaths(aux.getInt("deaths"));
                    temporal.sumRecovered(aux.getInt("recovered"));
                }else{
                    Country temporal = new Country(aux.getString("country"),aux.getInt("confirmed"),aux.getInt("deaths"),aux.getInt("recovered"));
                    datos.put(aux.getString("country"), temporal);
                }
            }


        }catch(UnirestException e){
            e.printStackTrace();
        }

        return datos;
    }

    @Override
    public String getCountry(String country)  {

        return null;
    }
    
}