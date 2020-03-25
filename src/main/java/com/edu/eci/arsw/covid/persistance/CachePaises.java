package com.edu.eci.arsw.covid.persistance;

import java.time.LocalDateTime;

public class CachePaises{

    public LocalDateTime creationTime;
    private String data;
    

    public CachePaises(String data){
        this.data = data;
        creationTime = LocalDateTime.now();
    }
    
    public String getData(){
        return data;
    }
}