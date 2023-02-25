package com.harsha.app.controller;


import java.io.IOException;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;



public class ApiCalls{
	
	
	public  JSONObject fprices(String source,String destination,String date) throws IOException, UnirestException
	{
		String query="https://skyscanner50.p.rapidapi.com/api/v1/searchFlights?origin="+source+"&destination="+destination+"&date="+date+"&adults=1";
		
		HttpResponse <JsonNode> response = Unirest.get(query)
			      .header("x-rapidapi-host", "skyscanner50.p.rapidapi.com")
			      .header("x-rapidapi-key", "d1c6edf56amshe290eeab90d53b5p1fca44jsn5072b344edfd")
			      .asJson();
			    System.out.println(response.getStatus());
			    System.out.println(response.getClass());
			    System.out.println(response.getBody().toString());
			    System.out.println("-------------------------------------------------");
			    JSONObject obj=response.getBody().getObject();
			    return obj;
			      	
	}
	
	public  JSONObject dprices(String source,String destination,String startdate,String returndate) throws IOException,UnirestException {
		
		String query="https://skyscanner50.p.rapidapi.com/api/v1/searchFlights?origin="+source+"&destination="+destination+"&date="+startdate+"&returnDate="+returndate+"&adults=1";
		
		HttpResponse <JsonNode> response = Unirest.get(query)
			      .header("x-rapidapi-host", "skyscanner50.p.rapidapi.com")
			      .header("x-rapidapi-key", "d1c6edf56amshe290eeab90d53b5p1fca44jsn5072b344edfd")
			      .asJson();
			    System.out.println(response.getStatus());
			    JSONObject obj=response.getBody().getObject();

			    return obj;
			    	
			   
			    
		
	}
	
	public  JSONObject rts(String source,String destination,String startdate,String currency,String countrycode) throws IOException,UnirestException {
		
		String query="https://skyscanner50.p.rapidapi.com/api/v1/searchFlights?origin="+source+"&destination="+destination+"&date="+startdate+"&adults=1&currency="+currency+"&countryCode="+countrycode;
		HttpResponse <JsonNode> response = Unirest.get(query)
			      .header("x-rapidapi-host", "skyscanner50.p.rapidapi.com")
			      .header("x-rapidapi-key", "d1c6edf56amshe290eeab90d53b5p1fca44jsn5072b344edfd")
			      .asJson();
			    System.out.println(response.getStatus());
			    JSONObject obj=response.getBody().getObject();
			    
			    return obj;

			    
		
	}
	
	public JSONObject curs() throws IOException,UnirestException{
		String query="https://wft-geo-db.p.rapidapi.com/v1/locale/currencies?limit=10";
		
		HttpResponse <JsonNode> response = Unirest.get(query)
			      .header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
			      .header("x-rapidapi-key", "d1c6edf56amshe290eeab90d53b5p1fca44jsn5072b344edfd")
			      .asJson();
			    System.out.println(response.getStatus());
			    JSONObject obj=response.getBody().getObject();
			    return obj;

            
		
	}
	
	public  JSONObject cntrys() throws IOException,UnirestException{
		String nameprefix="I";
		String query="https://wft-geo-db.p.rapidapi.com/v1/geo/countries?limit=10&namePrefix="+nameprefix;
		HttpResponse <JsonNode> response = Unirest.get(query)
			      .header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
			      .header("x-rapidapi-key", "d1c6edf56amshe290eeab90d53b5p1fca44jsn5072b344edfd")
			      .asJson();
			    System.out.println(response.getStatus());
			    JSONObject obj=response.getBody().getObject();
			    return obj;


	}
	
	public  JSONObject places(String code) throws IOException,UnirestException{
		String query="https://wft-geo-db.p.rapidapi.com/v1/geo/cities?limit=10&countryIds="+code+"&minPopulation=4100000&types=CITY";
		HttpResponse <JsonNode> response = Unirest.get(query)
			      .header("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
			      .header("x-rapidapi-key", "d1c6edf56amshe290eeab90d53b5p1fca44jsn5072b344edfd")
			      .asJson();
		        System.out.println(response.getStatus());
			    JSONObject obj=response.getBody().getObject();
			    return obj;

           
	}
	
	
}
