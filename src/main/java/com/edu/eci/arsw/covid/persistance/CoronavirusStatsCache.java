package com.edu.eci.arsw.covid.persistance;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import com.edu.eci.arsw.covid.models.Country;

@Service
public class CoronavirusStatsCache{
    HashMap<String, CachePaises> cache;

    HashMap<String, ArrayList<Country>> provincias;

    /**
     * Creador del objeto CoronavirusStatsCache
     */
    public CoronavirusStatsCache(){
        cache = new HashMap<>();
        provincias = new HashMap<>();
    }

    /**
     * Agregar un nuevo pais
     * @param key Nombre del pais 
     * @param data Datos del pais para cahche
     */
    public void addNewCountry(String key, Country data){
        CachePaises aux = new CachePaises(data);
        cache.put(key, aux);
    }

    /**
     * Obtener cache de un pais
     * @param key Nombre del pais
     * @return Cache del pais buscado
     */
    public CachePaises getCache(String key){
        return cache.get(key);
    }

    /**
     * Agregar cache de provincia
     * @param key Nombre de la provincia
     * @param array Arreglo de la provincia
     */
    public void addCacheProv(String key,ArrayList<Country> array){
        provincias.put(key, array);
    }

    /**
     * Obtener Cache de provincia
     * @param key Nombre de la provincia
     * @return Arreglo de la provincia
     */
    public ArrayList<Country> getCacheProv(String key){
        return provincias.get(key);
    }

    /**
     * Obtener cache
     * @return retorna cache
     */
    public HashMap<String, CachePaises> getCache(){
        return cache;
    }

    /**
     * Verifica si el cache esta vacio
     * @return Indica si esta vacio o no el cache (true:false)
     */
    public boolean isEmpty(){
        return cache.isEmpty();
    }
    
}