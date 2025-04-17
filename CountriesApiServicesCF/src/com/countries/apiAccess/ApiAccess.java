package com.countries.apiAccess;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import com.countries.modelos.Country;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiAccess {
	
	public Country[] ObtenerDatosAPI (){
		
        URL url;
		Country[] countries = null;
		try {
			url = new URL("https://restcountries.com/v3.1/all");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        ObjectMapper mapper = new ObjectMapper();
	        countries = mapper.readValue(conn.getInputStream(), Country[].class);
	
	        for (Country c : countries) {
	            System.out.println(c.getName().getCommon());
	        }
	
	        conn.disconnect();		
	    } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return countries;
		
	}
}
