package com.edu.eci.arsw.covid.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.springframework.stereotype.Service;


@Service
public class HttpConnectionService{

    public String getCountryStats(String country) throws UnirestException{
        HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+ country)
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "6cd6905b70msha154511195878ffp126a21jsn0f5635fb15d4")
                .asString();
        return response.getBody();
    }

    public String getAllCou() throws UnirestException{
        HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
            .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
            .header("x-rapidapi-key", "6cd6905b70msha154511195878ffp126a21jsn0f5635fb15d4")
            .asString();
        return response.getBody();
    }


}