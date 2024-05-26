package com.aluracursos.principal.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principalconbusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        int option = 0;
        Scanner lectura1 = new Scanner(System.in);
        System.out.println("Bienvenido a Interchange Currency Platform");
        System.out.println("Tienes dolares USD o colones CRC, escriba USD o CRC ?");
        String tipoMonedaQueConservas = lectura1.nextLine();
        Scanner lectura2 =new Scanner(System.in);
        System.out.println("Ingrese el monto a cambiar:");
        double montoACambiar = lectura2.nextDouble();

        String opcionesTipoCambio = """
               Seleccione el tipo de moneda al que desea cambiar:
               1-DOLARES USD
               2-COLONES COSTARRICENSES CRC
               3-PESOS COLOMBIANOS COL
               4-PESOS MEXICANOS MXC
               9-SALIR
               """;
        Scanner lectura3 = new Scanner(System.in);
        while (option != 9){
            System.out.println(opcionesTipoCambio);
            option = lectura3.nextInt();

            switch (option){
                case 1:
                    System.out.println("El monto en Dolares es :"+montoACambiar*1+" USD");
                    break;
                case 2:
                    System.out.println("El monto en Colones es :"+montoACambiar*2+" CRC");
                    break;
                case 3:
                    System.out.println("El monto en Pesos Colombianos es :"+montoACambiar*3+" COL");
                    break;
                case 4:
                    System.out.println("El monto en Pesos Mexicanos es :"+montoACambiar*4+" MXC");
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
