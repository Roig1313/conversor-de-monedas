package com.aluracursos.principal.com;


import Currency.Currency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principalconbusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Currency miCurrency = new Currency();
        miCurrency.setOption(0);
        Scanner lectura1 = new Scanner(System.in);
        System.out.println("Bienvenido a Interchange Currency Platform");
        System.out.println("Tienes dolares USD o colones CRC, escriba USD o CRC ?");
        miCurrency.setMonedaACambiar(lectura1.nextLine());
        Scanner lectura2 =new Scanner(System.in);
        //  Esto es para un mensaje sobre el tipo de moneda que se selecciono.
//        if (miCurrency.monedaACambiar=="USD"){
//            System.out.println("Has seleccionado Dolares.");
//        } else if (miCurrency.monedaACambiar=="CRC") {
//            System.out.println("Has seleccionado Colones.");
//        }else {
//            System.out.println("No se selecciono el tipo de moneda solicitada");
//
//        }
        System.out.println("Ingrese el monto a cambiar:");
        miCurrency.setMonto(lectura2.nextDouble());

        String opcionesTipoCambio = """
               Seleccione el tipo de moneda al que desea cambiar:
               1-DOLARES USD
               2-COLONES COSTARRICENSES CRC
               3-PESOS COLOMBIANOS COL
               4-PESOS MEXICANOS MXC
               9-SALIR
               """;
        Scanner lectura3 = new Scanner(System.in);
        while (miCurrency.getOption()!= 9){
            System.out.println(opcionesTipoCambio);
            miCurrency.setOption(lectura3.nextInt());

            switch (miCurrency.getOption()){
                case 1:
                    miCurrency.setSiglasMoneda("USD");
                    miCurrency.setCambiarALaMoneda("Dolares");
                    miCurrency.monedaSeleccionada();
                    break;
                case 2:
                    miCurrency.setSiglasMoneda("CRC");
                    miCurrency.setCambiarALaMoneda("Colones");
                    System.out.println("El monto en Colones es :"+miCurrency.getMonto()*2+" CRC");
                    break;
                case 3:
                    miCurrency.setSiglasMoneda("COL");
                    miCurrency.setCambiarALaMoneda("Pesos Colombianos");
                    System.out.println("El monto en Pesos Colombianos es :"+miCurrency.getMonto()*3+" COL");
                    break;
                case 4:
                    miCurrency.setSiglasMoneda("MXC");
                    miCurrency.setCambiarALaMoneda("Pesos Mexicanos");
                    System.out.println("El monto en Pesos Mexicanos es :"+miCurrency.getMonto()*4+" MXC");
                    break;
                case 9:
                    System.out.println("Haz salido del programa de Interchange Currency Platform");
                    System.out.println("Fue un gusto atenderle.");
                    break;
                default:
                System.out.println("Opcion no valida, favor ingresa el # de la opcion correcta.");

            }
        }
        var busqueda = lectura1.nextLine();

        String direccion = "https://v6.exchangerate-api.com/v6/e09d49aca7fd771b2761a313/latest/"+busqueda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
