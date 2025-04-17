package com.countries.apiAccess;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.countries.modelos.Country;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiAccess {
	public List<Country> obtenerDatosAPI() {
        URL url;
        List<Country> countries = null;
        try {
            url = new URL("https://restcountries.com/v3.1/all");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            ObjectMapper mapper = new ObjectMapper();
            Country[] countriesArray = mapper.readValue(conn.getInputStream(), Country[].class);
            countries = Arrays.asList(countriesArray);

            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
