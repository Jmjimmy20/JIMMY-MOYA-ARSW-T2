package com.edu.eci.arsw.covid.services.impl;

import com.edu.eci.arsw.covid.persistance.CoronavirusStatsCache;
import com.edu.eci.arsw.covid.services.CoronavirusStatsServices;
import com.edu.eci.arsw.covid.services.HttpConnectionService;
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
    String data;


    @Override
    public String getCountries() {
        paises = "";
        try{
            paises = httpCS.getAllCou();
        }catch(UnirestException e){
            e.printStackTrace();
        }
        
        return paises;
    }

    @Override
    public String getCountry(String country)  {
        return null;
    }
    
}