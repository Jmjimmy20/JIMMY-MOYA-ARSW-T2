package com.edu.eci.arsw.covid.persistance;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class CoronavirusStatsCache{
    ConcurrentHashMap<String, CachePaises> cache;

    public CoronavirusStatsCache(){
        cache = new ConcurrentHashMap<>();
    }

    public void addNewCountry(String key, String data){
        CachePaises aux = new CachePaises(data);
        cache.put(key, aux);
    }

    public CachePaises getCache(String key){
        return cache.get(key);
    }
    
}