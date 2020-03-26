/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.covid19.controller;

import edu.eci.arsw.covid19.model.Data;
import edu.eci.arsw.covid19.service.Covid19Services;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan David
 */
@RestController
@RequestMapping(value = "/stats")
public class Covid19Controller {
    
    //Atributos
    @Autowired
    Covid19Services c19s;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getStatistics(){
        List<Data> data = null;
        try {
            data = c19s.findAllCountries();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Covid19Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido retornar la informacion", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/{country}",method = RequestMethod.GET)
    public ResponseEntity<?> getStatisticsByCountry(@PathVariable("country") String country){
        List<Data> data = null;
        try {
            data = c19s.findCountriesByName(country);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Covid19Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido retornar la informacion", HttpStatus.NOT_FOUND);
        }
    }

}