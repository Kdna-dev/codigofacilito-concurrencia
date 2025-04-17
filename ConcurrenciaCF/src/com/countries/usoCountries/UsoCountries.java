package com.countries.usoCountries;

import com.countries.apiAccess.ApiAccess;

public class UsoCountries {
	public static void main(String[] args) {
		ApiAccess api = new ApiAccess();
		api.ObtenerDatosAPI();
	}
}
