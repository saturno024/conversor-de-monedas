package com.fabianmesa.conversordemonedas.consultas;

import com.fabianmesa.conversordemonedas.modelos.Moneda;
import com.fabianmesa.conversordemonedas.modelos.MonedaDTO;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
/**
 * Challenge Conversor de Monedas - Alura Latam / Oracle Next Education
 * @author Carlos Fabian Mesa Muñoz (saturno024)
 * @version 1.0
 * @since 2026-02-19
 */

public class ConsultaMonedas {

    public Moneda consultaMoneda(String monedaOrigen, String  monedaDestino){

        // Recuperamos la clave desde las variables del sistema
        String apiKey = System.getenv("EXCHANGE_RATE_KEY");

        // Armamos la URL usando la variable
        var direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaOrigen);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            MonedaDTO monedaDTO = new Gson().fromJson(response.body(), MonedaDTO.class);
            Double tasa = monedaDTO.conversion_rates().get(monedaDestino);

            return new Moneda(monedaOrigen, monedaDestino, tasa);

        } catch (Exception e) {
            throw new RuntimeException("Error en la consulta: " + e.getMessage());
        }
    }
}
