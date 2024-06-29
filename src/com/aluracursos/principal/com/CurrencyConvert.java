package com.aluracursos.principal.com;

import Currency.Currency;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConvert {
    public static double convertirMoneda(String monedaEnMano, Currency miCurrency) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/e09d49aca7fd771b2761a313/pair/" + monedaEnMano + "/" + miCurrency.getMonedaACambiar();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
//        System.out.println("JSON recibido: " + json);

        Gson gson = new Gson();
        TituloOMBD miTituloOMBD = gson.fromJson(json, TituloOMBD.class);
//        System.out.println(miTituloOMBD.conversion_rate() * miCurrency.getMonto());
        Double conversionRate = miTituloOMBD.conversion_rate();
        if (conversionRate != null) {
            return conversionRate * miCurrency.getMonto();
        } else {
            System.out.println("No se pudo obtener la tasa de conversión.");
            return 0;
    }
}
}