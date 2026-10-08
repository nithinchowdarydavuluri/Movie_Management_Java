package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Model.Movie;
import org.example.Model.Ticket;
import org.example.enums.TickectCategory;

public class JsonUtil {


    public static String ObjectToJson(Ticket tic){

        try{
            ObjectMapper om = new ObjectMapper();
            String jsonString = om.writeValueAsString(tic);
            return  jsonString;
        }catch(Exception e){
             throw  new RuntimeException(e);
        }

    }
    public static Movie jsonToObject(String temp) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(temp, Movie.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Invalid JSON for Ticket", e);
        }
    }




}
