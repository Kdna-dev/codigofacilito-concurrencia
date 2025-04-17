package com.countries.usoCountries;

import java.util.List;
import java.util.Map;
import com.countries.modelos.Country;
import com.countries.poblacion.Poblacion;

public class UsoCountries {

	private Poblacion api;

	public UsoCountries() {
		this.api = new Poblacion();
	}

	public static void main(String[] args) {
		UsoCountries uso = new UsoCountries();
		uso.compararPaisMayorPoblacion();
		System.out.println();
		uso.compararPesoTotalBanderas();
		System.out.println();
		uso.compararTop10PaisesMasGrandes();
		System.out.println();
		uso.compararIdiomasMasComunes();
	}

	public void compararPaisMayorPoblacion() {
        // Measure time for concurrent execution
        long startTimeConcurrent = System.currentTimeMillis();
        Country pais = api.obtenerPaisConMayorPoblacionConcurrente();
        long endTimeConcurrent = System.currentTimeMillis();
        System.out.println("País con mayor población: " + pais.getName().getCommon());
        System.out.println("Tiempo de ejecución concurrente: " + (endTimeConcurrent - startTimeConcurrent) + " ms");

        // Measure time for non-concurrent execution
        long startTimeNonConcurrent = System.currentTimeMillis();
        Country pais2 = api.obtenerPaisConMayorPoblacionNoConcurrente();
        long endTimeNonConcurrent = System.currentTimeMillis();
        System.out.println("País con menor población: " + pais2.getName().getCommon());
        System.out.println("Tiempo de ejecución no concurrente: " + (endTimeNonConcurrent - startTimeNonConcurrent) + " ms");

		// Compare execution times
        long diferenciaTiempo = (endTimeNonConcurrent - startTimeNonConcurrent) - (endTimeConcurrent - startTimeConcurrent);
        System.out.println("Diferencia de tiempo (no concurrente - concurrente): " + diferenciaTiempo + " ms");
	}

	public void compararPesoTotalBanderas() {
        // Measure time for concurrent execution
        long startTimeConcurrent = System.currentTimeMillis();
        long pesoConcurrente = api.obtenerPesoTotalBanderasConcurrente();
        long endTimeConcurrent = System.currentTimeMillis();
        System.out.println("Peso total de banderas (concurrente): " + pesoConcurrente + " bytes");
        System.out.println("Tiempo de ejecución concurrente: " + (endTimeConcurrent - startTimeConcurrent) + " ms");

        // Measure time for non-concurrent execution
        long startTimeNonConcurrent = System.currentTimeMillis();
        long pesoNoConcurrente = api.obtenerPesoTotalBanderasNoConcurrente();
        long endTimeNonConcurrent = System.currentTimeMillis();
        System.out.println("Peso total de banderas (no concurrente): " + pesoNoConcurrente + " bytes");
        System.out.println("Tiempo de ejecución no concurrente: " + (endTimeNonConcurrent - startTimeNonConcurrent) + " ms");

        // Compare execution times
        long diferenciaTiempo = (endTimeNonConcurrent - startTimeNonConcurrent) - (endTimeConcurrent - startTimeConcurrent);
        System.out.println("Diferencia de tiempo (no concurrente - concurrente): " + diferenciaTiempo + " ms");
	}

	public void compararTop10PaisesMasGrandes() {
		System.out.println("\n--- COMPARACIÓN TOP 10 PAÍSES MÁS GRANDES ---");

		// Measure time for concurrent execution
		long startTimeConcurrent = System.currentTimeMillis();
		List<Country> paisesConcurrente = api.obtenerTop10PaisesMasGrandesConcurrente();
		long endTimeConcurrent = System.currentTimeMillis();

		System.out.println("Top 10 países más grandes (concurrente):");
		paisesConcurrente.forEach(pais -> 
			System.out.println(pais.getName().getCommon() + ": " + pais.getArea() + " km²"));
		System.out.println("Tiempo de ejecución concurrente: " + (endTimeConcurrent - startTimeConcurrent) + " ms");

		// Measure time for non-concurrent execution
		long startTimeNonConcurrent = System.currentTimeMillis();
		List<Country> paisesNoConcurrente = api.obtenerTop10PaisesMasGrandesNoConcurrente();
		long endTimeNonConcurrent = System.currentTimeMillis();

		System.out.println("\nTop 10 países más grandes (no concurrente):");
		paisesNoConcurrente.forEach(pais -> 
			System.out.println(pais.getName().getCommon() + ": " + pais.getArea() + " km²"));
		System.out.println("Tiempo de ejecución no concurrente: " + (endTimeNonConcurrent - startTimeNonConcurrent) + " ms");

		// Compare execution times
		long diferenciaTiempo = (endTimeNonConcurrent - startTimeNonConcurrent) - (endTimeConcurrent - startTimeConcurrent);
		System.out.println("Diferencia de tiempo (no concurrente - concurrente): " + diferenciaTiempo + " ms");
	}

	public void compararIdiomasMasComunes() {
		System.out.println("\n--- COMPARACIÓN IDIOMAS MÁS COMUNES ---");

		// Measure time for concurrent execution
		long startTimeConcurrent = System.currentTimeMillis();
		Map<String, Long> idiomasConcurrente = api.obtenerIdiomasMasComunesConcurrente();
		long endTimeConcurrent = System.currentTimeMillis();

		System.out.println("Idiomas más comunes (concurrente):");
		idiomasConcurrente.entrySet().stream()
			.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
			.limit(10)
			.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " países"));
		System.out.println("Tiempo de ejecución concurrente: " + (endTimeConcurrent - startTimeConcurrent) + " ms");

		// Measure time for non-concurrent execution
		long startTimeNonConcurrent = System.currentTimeMillis();
		Map<String, Long> idiomasNoConcurrente = api.obtenerIdiomasMasComunesNoConcurrente();
		long endTimeNonConcurrent = System.currentTimeMillis();

		System.out.println("\nIdiomas más comunes (no concurrente):");
		idiomasNoConcurrente.entrySet().stream()
			.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
			.limit(10)
			.forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " países"));
		System.out.println("Tiempo de ejecución no concurrente: " + (endTimeNonConcurrent - startTimeNonConcurrent) + " ms");

		// Compare execution times
		long diferenciaTiempo = (endTimeNonConcurrent - startTimeNonConcurrent) - (endTimeConcurrent - startTimeConcurrent);
		System.out.println("Diferencia de tiempo (no concurrente - concurrente): " + diferenciaTiempo + " ms");
	}
}
