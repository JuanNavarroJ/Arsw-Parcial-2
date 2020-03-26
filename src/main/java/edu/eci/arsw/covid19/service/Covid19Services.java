/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.covid19.service;

import edu.eci.arsw.covid19.model.Country;
import edu.eci.arsw.covid19.model.Region;
import java.util.List;

/**
 * Interface Covid19Services la cual va a prestar los servicios requeridos para el funcionamiento del API. 
 * @author Juan David
 */
public interface Covid19Services {

    /**
     * Metodo findAllCountries permite consultar todos los paises reportados en el API de coronavirus.
     * @return  Retorna una lista de 
     */
    List<Country> findAllCountries();
    /**
     * Metodo findCountriesByName permite consultar todas las regiones de un pais reportados en el API de coronavirus.
     * @param country   Es el pais del cual se quiere conocer toda su informacion de sus Regiones.
     * @return  Retorna una lista con las Regiones del pais.
     */
    List<Region> findCountriesByName(String country);

}
