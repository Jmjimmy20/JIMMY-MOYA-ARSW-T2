package com.edu.eci.arsw.covid.services;

import org.springframework.stereotype.Service;
import org.json.JSONObject;
import java.util.HashMap;

import com.edu.eci.arsw.covid.models.Country;

@Service
public interface CoronavirusStatsServices{
    /**
     * Interfaz para obtener todos los paises del API
     * @return HashMaps con la infomacion de todos los paises
     */
    public HashMap<String, Country> getCountries();

    /**
     * Interfaz para obtener los datos de un pais en especifico
     * @param country Nombre del pais a buscar
     * @return HashMaps con la infomacion del pais buscado
     */
    public HashMap<String, Country> getCountry(String country);
}