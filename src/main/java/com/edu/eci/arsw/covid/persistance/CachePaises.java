package com.edu.eci.arsw.covid.persistance;

import java.time.LocalDateTime;

import com.edu.eci.arsw.covid.models.Country;

public class CachePaises{

    public LocalDateTime creationTime;
    private Country data;
    

    public CachePaises(Country data){
        this.data = data;
        creationTime = LocalDateTime.now();
    }

    public Country getData(){
        return data;
    }
}