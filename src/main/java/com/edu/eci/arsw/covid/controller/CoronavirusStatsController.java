package com.edu.eci.arsw.covid.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

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
    public ResponseEntity<?> getCasesByCountry(@PathVariable ("name") String name){
        try {
            return new ResponseEntity<>(cServices.getCountry(name), HttpStatus.OK);
          } catch (Exception ex) {
            Logger.getLogger(CoronavirusStatsController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
          }
        
    }

    @RequestMapping(value = "/getAll")
    public ResponseEntity<?> getAllCases(){
        try {
            return new ResponseEntity<>(cServices.getCountries(), HttpStatus.OK);
          } catch (Exception ex) {
            Logger.getLogger(CoronavirusStatsController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
          }
        
    }


}