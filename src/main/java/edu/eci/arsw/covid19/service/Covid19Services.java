/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.covid19.service;

import edu.eci.arsw.covid19.model.Data;
import java.util.List;

/**
 *
 * @author Juan David
 */
public interface Covid19Services {

    List<Data> findAllCountries();
    List<Data> findCountriesByName(String country);

}
