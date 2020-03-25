package com.edu.eci.arsw.covid.services;

import org.springframework.stereotype.Service;

@Service
public interface CoronavirusStatsServices{
    public String getCountries();
    public String getCountry(String country);
}