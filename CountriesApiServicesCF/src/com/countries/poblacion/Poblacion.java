package com.countries.poblacion;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.countries.apiAccess.ApiAccess;
import com.countries.modelos.Country;

public class Poblacion {

    public long obtenerPesoTotalBanderasConcurrente() {
        ApiAccess api = new ApiAccess();
        List<Country> paises = api.obtenerDatosAPI();

        return paises.parallelStream()
                    .mapToLong(this::obtenerPesoBandera)
                    .sum();
    }

    public long obtenerPesoTotalBanderasNoConcurrente() {
        ApiAccess api = new ApiAccess();
        List<Country> paises = api.obtenerDatosAPI();

        return paises.stream()
                    .mapToLong(this::obtenerPesoBandera)
                    .sum();
    }

    private long obtenerPesoBandera(Country pais) {
        try {
            URL url = new URL(pais.getFlags().getPng());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();

            long contentLength = connection.getContentLengthLong();
            connection.disconnect();

            return contentLength > 0 ? contentLength : 0;
        } catch (Exception e) {
            System.err.println("Error al obtener el peso de la bandera de " + pais.getName().getCommon() + ": " + e.getMessage());
            return 0;
        }
    }

    public Country obtenerPaisConMayorPoblacionConcurrente() {
        ApiAccess api = new ApiAccess();
		List<Country> paises = api.obtenerDatosAPI();

        return paises.parallelStream()
                    .max(Comparator.comparingLong(Country::getPopulation))
                    .orElse(null);
    } // end obtenerPaisConMayorPoblacion

    public Country obtenerPaisConMayorPoblacionNoConcurrente() {
        ApiAccess api = new ApiAccess();
		List<Country> paises = api.obtenerDatosAPI();

        return paises.stream()
                    .max(Comparator.comparingLong(Country::getPopulation))
                    .orElse(null);
    } // end obtenerPaisConMayorPoblacion

    public List<Country> obtenerTop10PaisesMasGrandesConcurrente() {
        ApiAccess api = new ApiAccess();
        List<Country> paises = api.obtenerDatosAPI();

        return paises.parallelStream()
                    .sorted(Comparator.comparingDouble(Country::getArea).reversed())
                    .limit(10)
                    .toList();
    }

    public List<Country> obtenerTop10PaisesMasGrandesNoConcurrente() {
        ApiAccess api = new ApiAccess();
        List<Country> paises = api.obtenerDatosAPI();

        return paises.stream()
                    .sorted(Comparator.comparingDouble(Country::getArea).reversed())
                    .limit(10)
                    .toList();
    }

    public Map<String, Long> obtenerIdiomasMasComunesConcurrente() {
        ApiAccess api = new ApiAccess();
        List<Country> paises = api.obtenerDatosAPI();

        return paises.parallelStream()
                    .filter(pais -> pais.getLanguages() != null)
                    .flatMap(pais -> pais.getLanguages().entrySet().stream())
                    .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.counting()
                    ));
    }

    public Map<String, Long> obtenerIdiomasMasComunesNoConcurrente() {
        ApiAccess api = new ApiAccess();
        List<Country> paises = api.obtenerDatosAPI();

        return paises.stream()
                    .filter(pais -> pais.getLanguages() != null)
                    .flatMap(pais -> pais.getLanguages().entrySet().stream())
                    .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.counting()
                    ));
    }

}
