package com.edu.eci.arsw.covid.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.edu.eci.arsw.covid.models.Country;
import com.edu.eci.arsw.covid.persistance.CachePaises;
import com.edu.eci.arsw.covid.persistance.CoronavirusStatsCache;
import com.edu.eci.arsw.covid.services.CoronavirusStatsServices;
import com.edu.eci.arsw.covid.services.HttpConnectionService;

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
        if(cacheP.isEmpty()){
            try{  
                paises = httpCS.getAllCou();
                processData(paises, "country", datos);
            }catch(UnirestException e){
                e.printStackTrace();
            }
            for(Map.Entry<String, Country> c : datos.entrySet()){
                cacheP.addNewCountry(c.getKey(), c.getValue());
            }
        }else{
            for(Map.Entry<String, CachePaises> c : cacheP.getCache().entrySet()){
                datos.put(c.getKey(), c.getValue().getData());
            }
        }
        
        return datos;
    }

    @Override
    public HashMap<String, Country> getCountry(String country)  {
        HashMap <String, Country> datos = new HashMap<String, Country>();
            if(cacheP.getCacheProv(country).isEmpty()){
                try {
                    paises = httpCS.getCountryStats(country);
                    //System.out.println(paises.substring(50));
                    processData(paises, "province", datos);
                } catch (UnirestException e) {
                    e.printStackTrace();
                }
                ArrayList<Country> array = new ArrayList<Country>();
                for(Map.Entry<String, Country> c : datos.entrySet()){
                    array.add(c.getValue());
                }
                cacheP.addCacheProv(country, array);
            }else{
                for(Country c : cacheP.getCacheProv(country)){
                    datos.put(c.getCountry(), c);
                }
            }
            
        return datos;
    }

    private void processData(String data, String op, HashMap<String, Country> datos){
        JSONObject json = new JSONObject(data);
        JSONArray jArray = json.getJSONObject("data").getJSONArray("covid19Stats");
        for(int i =0 ; i<jArray.length();i++){
            JSONObject aux = jArray.getJSONObject(i);
            if(datos.get(aux.getString(op))!=null){
                Country temporal = datos.get(aux.getString(op));
                temporal.sumConfirmed(aux.getInt("confirmed"));
                temporal.sumDeaths(aux.getInt("deaths"));
                temporal.sumRecovered(aux.getInt("recovered"));
            }else{
                Country temporal = new Country(aux.getString(op),aux.getInt("confirmed"),aux.getInt("deaths"),aux.getInt("recovered"));
                datos.put(aux.getString(op), temporal);
            }
        }
    }
    
}