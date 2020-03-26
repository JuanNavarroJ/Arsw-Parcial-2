/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.covid19.controller;

import edu.eci.arsw.covid19.model.Country;
import edu.eci.arsw.covid19.model.Region;
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
 * Clase Covid19Controller es la responsable del APICovid19.
 * @author Juan David
 */
@RestController
@RequestMapping(value = "/stats")
public class Covid19Controller {
    
    //Atributos
    @Autowired
    Covid19Services c19s;
    
    /**
     * Metodo que permite consultar una lista de paises con informacion de nombre,muertos,infectados y curados por pais en formato JSON.
     * @return Retorna una lista de Paises con su informacion de nombre,muertos,infectados y curados en formato JSON.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getStatistics(){
        List<Country> data = null;
        try {
            data = c19s.findAllCountries();
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Covid19Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido retornar la informacion", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que permite consultar la informacion por pais algunos paises tienen informacion sobre algunas regiones.
     * @param country   Es el pais el cual quieres consultar.
     * @return  Retorna una lista con las regiones del pais.
     */
    @RequestMapping(path = "/{country}",method = RequestMethod.GET)
    public ResponseEntity<?> getStatisticsByCountry(@PathVariable("country") String country){
        List<Region> data = null;
        try {
            data = c19s.findCountriesByName(country);
            return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(Covid19Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido retornar la informacion", HttpStatus.NOT_FOUND);
        }
    }

}