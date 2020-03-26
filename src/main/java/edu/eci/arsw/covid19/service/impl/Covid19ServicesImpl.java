/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.covid19.service.impl;

import edu.eci.arsw.covid19.model.Data;
import edu.eci.arsw.covid19.service.Covid19Services;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan David
 */
@Service
public class Covid19ServicesImpl implements Covid19Services{

    @Override
    public List<Data> findAllCountries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Data> findCountriesByName(String country) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
