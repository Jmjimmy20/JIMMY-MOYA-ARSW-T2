package com.edu.eci.arsw.covid.persistance;
import java.time.LocalDateTime;
import com.edu.eci.arsw.covid.models.Country;

public class CachePaises{

    public LocalDateTime creationTime;
    private Country data;
    
    /**
     * Creador del objeto CachePaises
     * @param data los datos del pais que es de tipo Country
     */
    public CachePaises(Country data){
        this.data = data;
        creationTime = LocalDateTime.now();
    }

    /**
     * Retornar los datos del cache de un pais
     * @return los datos del chace del pais
     */
    public Country getData(){
        return data;
    }
}