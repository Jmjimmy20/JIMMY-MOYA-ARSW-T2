package com.edu.eci.arsw.covid.controller;

import com.edu.eci.arsw.covid.services.CoronavirusStatsServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/countries")
public class CoronavirusStatsController{
    @Autowired
    CoronavirusStatsServices cServices;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<?>getCasesByCountry(@PathVariable ("name") String name){
        String stats = cServices.getCountry(name);
        return new ResponseEntity<>(stats, HttpStatus.OK); 
    }

    @RequestMapping(value = "/getAll")
    public ResponseEntity<?> getAllCases(){
        String stats = cServices.getCountries();
        return new ResponseEntity<>(stats,HttpStatus.OK);
    }

}