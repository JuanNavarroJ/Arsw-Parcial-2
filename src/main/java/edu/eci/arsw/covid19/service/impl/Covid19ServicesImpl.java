/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.covid19.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covid19.model.Data;
import edu.eci.arsw.covid19.service.Covid19Services;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan David
 */
@Service
public class Covid19ServicesImpl implements Covid19Services{

    
    private Gson gson;
    
    @Override
    public List<Data> findAllCountries(){
        gson = new Gson();
        List<Data> data = null;
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                    .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                    .header("x-rapidapi-key", "f0ac279634mshfb892495e463495p1334bajsn9a3c972b3eaa")
                    .asJson();
        } catch (UnirestException ex) {
            Logger.getLogger(Covid19Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gson = new GsonBuilder().create();
        JSONArray allStats = response.getBody().getObject().getJSONObject("data").getJSONArray("covid19Stats");
        data = gson.fromJson(allStats.toString(),new TypeToken<List<Data>>(){}.getType());
        return data;
    }
    
    @Override
    public List<Data> findCountriesByName(String country){
        gson = new Gson();
        List<Data> data = null;
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+country)
            .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
            .header("x-rapidapi-key", "f0ac279634mshfb892495e463495p1334bajsn9a3c972b3eaa")
                    .asJson();
        } catch (UnirestException ex) {
            Logger.getLogger(Covid19Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gson = new GsonBuilder().create();
        JSONArray stats = response.getBody().getObject().getJSONObject("data").getJSONArray("covid19Stats");
        data = gson.fromJson(stats.toString(),new TypeToken<List<Data>>(){}.getType());
        return data;
    }
    

}
