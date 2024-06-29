package com.aluracursos.principal.com;


import Currency.Currency;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principalconbusqueda {
    protected static String monedaEnMano;

    public Principalconbusqueda(String siglasMoneda, String cambiarALaMoneda, double monto, double tipoCambio) {
        super();}

    public static void main(String[] args) throws IOException, InterruptedException {
        Currency miCurrency = new Currency();
        miCurrency.setOption(0);
        Scanner lectura1 = new Scanner(System.in);
        System.out.println("Bienvenido a Interchange Currency Platform");



        //  Esto es para un mensaje sobre el tipo de moneda que se selecciono.
        while (true) {

            System.out.println("Tienes dolares USD o colones CRC, escriba USD o CRC ?");
            monedaEnMano = lectura1.nextLine();
            if (monedaEnMano.equals("USD")) {
            System.out.println("Has seleccionado Dolares.");
                break;
            } else if (monedaEnMano.equals("CRC")) {
            System.out.println("Has seleccionado Colones.");
                break;
            } else {
            System.out.println("No se selecciono el tipo de moneda solicitada");

            }
        }
        Scanner lectura2 =new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese el monto a cambiar:");
            try {
                miCurrency.setMonto(lectura2.nextDouble());
                break; // Salir del bucle si la entrada es un número válido
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                lectura2.next(); // Limpiar la entrada no válida
            }
        }
//        System.out.println("Ingrese el monto a cambiar:");
//        miCurrency.setMonto(lectura2.nextDouble());

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
                    miCurrency.setMonedaACambiar("USD");
                    System.out.println("El monto convertido es: " + CurrencyConvert.convertirMoneda(monedaEnMano, miCurrency));
                    break;

                case 2:
                    miCurrency.setSiglasMoneda("CRC");
                    miCurrency.setCambiarALaMoneda("Colones");
//                    miCurrency.setTipoCambio(2);
                    miCurrency.setMonedaACambiar("CRC");
//                    miCurrency.monedaSeleccionada();
                    System.out.println("El monto convertido es: " + CurrencyConvert.convertirMoneda(monedaEnMano, miCurrency));
                    break;
                case 3:
                    miCurrency.setSiglasMoneda("COL");
                    miCurrency.setCambiarALaMoneda("Pesos Colombianos");
//                    miCurrency.setTipoCambio(3);
                    miCurrency.setMonedaACambiar("COP");
//                    miCurrency.monedaSeleccionada();
                    System.out.println("El monto convertido es: " + CurrencyConvert.convertirMoneda(monedaEnMano, miCurrency));
                    break;
                case 4:
                    miCurrency.setSiglasMoneda("MXN");
                    miCurrency.setCambiarALaMoneda("Pesos Mexicanos");
//                    miCurrency.setTipoCambio(4);
                    miCurrency.setMonedaACambiar("MXN");
//                    miCurrency.monedaSeleccionada();
                    System.out.println("El monto convertido es: " + CurrencyConvert.convertirMoneda(monedaEnMano, miCurrency));
                    break;
                case 9:
                    System.out.println("Haz salido del programa de Interchange Currency Platform");
                    System.out.println("Fue un gusto atenderle.");
                    break;
                default:
                System.out.println("Opcion no valida, favor ingresa el # de la opcion correcta.");

            }
        }


//        String direccion = "https://v6.exchangerate-api.com/v6/e09d49aca7fd771b2761a313/pair/"+monedaEnMano+"/"+miCurrency.getMonedaACambiar();
////        String direccion = "https://v6.exchangerate-api.com/v6/e09d49aca7fd771b2761a313/pair/CRC/USD";
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(direccion))
//                .build();
//        HttpResponse<String> response = client
//                .send(request, HttpResponse.BodyHandlers.ofString());
//
//        String json = response.body();
//        System.out.println(json);
//
//
//        Gson gson  = new Gson();
//        TituloOMBD miTituloOMBD = gson.fromJson(json, TituloOMBD.class);
//
//
//
//        System.out.println(miTituloOMBD.conversion_rate()*miCurrency.getMonto());

    }

    }
