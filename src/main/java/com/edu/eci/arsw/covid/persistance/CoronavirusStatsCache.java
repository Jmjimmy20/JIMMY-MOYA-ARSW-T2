package com.edu.eci.arsw.covid.persistance;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import com.edu.eci.arsw.covid.models.Country;

@Service
public class CoronavirusStatsCache{
    HashMap<String, CachePaises> cache;

    HashMap<String, ArrayList<Country>> provincias;

    public CoronavirusStatsCache(){
        cache = new HashMap<>();
    }

    public void addNewCountry(String key, Country data){
        CachePaises aux = new CachePaises(data);
        cache.put(key, aux);
    }

    public CachePaises getCache(String key){

        return cache.get(key);
    }

    public void addCacheProv(String key,ArrayList<Country> array){
        provincias.put(key, array);
    }

    public ArrayList<Country> getCacheProv(String key){


        return provincias.get(key);
    }

    public HashMap<String, CachePaises> getCache(){
        return cache;
    }

    public boolean isEmpty(){
        return cache.isEmpty();
    }
    
}