package com.fabianmesa.conversordemonedas.principal;

import com.fabianmesa.conversordemonedas.calculos.Conversion;
import com.fabianmesa.conversordemonedas.consultas.ConsultaMonedas;
import com.fabianmesa.conversordemonedas.modelos.HistorialDeConversiones;
import com.fabianmesa.conversordemonedas.modelos.Moneda;


import java.util.Scanner;
/**
 * Challenge Conversor de Monedas - Alura Latam / Oracle Next Education
 * @author Carlos Fabian Mesa Muñoz (saturno024)
 * @version 1.0
 * @since 2026-02-19
 */
public class Principal {
    public static void main(String[] args) {
        String origen = "";
        String destino = "";
        double cantidadUsuario;
        Scanner lectura = new Scanner(System.in);

        HistorialDeConversiones historial = new HistorialDeConversiones();
        while(true){
            String menu = """
        \n
        ====================================================
        |           CONVERSOR DE MONEDAS                   |
        ====================================================
        
          1) USD [Dolar]           >>>  ARS [Peso Argentino]
          2) ARS [Peso Argentino]  >>>  USD [Dolar]
          3) USD [Dolar]           >>>  BRL [Real Brasileno]
          4) BRL [Real Brasileño]  >>>  USD [Dolar]
          5) USD [Dolar]           >>>  COP [Peso Colombiano]
          6) COP [Peso Colombiano] >>>  USD [Dolar]
        ----------------------------------------------------
          7) Personalizado (Ej: EUR, MXN, JPY)
          8) Ver Historial Completo
          0) Salir
        
        ====================================================
         >> Seleccione una opcion: \n""";

            System.out.println(menu);
            var opcion = lectura.nextInt();
                if(opcion==8){
                    historial.mostrarHistorial();
                    continue;
                }else  if(opcion==0){
                    System.out.println("\nGracias por utilizar el conversor de monedas");
                    break;
                }
                switch (opcion) {
                    case 1 : { origen = "USD"; destino = "ARS"; break;}
                    case 2 : { origen = "ARS"; destino = "USD"; break;}
                    case 3 : { origen = "USD"; destino = "BRL"; break;}
                    case 4 : { origen = "BRL"; destino = "USD"; break;}
                    case 5 : { origen = "USD"; destino = "COP"; break;}
                    case 6 : { origen = "COP"; destino = "USD"; break;}
                    case 7 : {
                        System.out.println("\nIngrese código origen (ej: GBP):\n");
                        origen = lectura.next().toUpperCase();
                        System.out.println("\nIngrese código destino (ej: EUR):\n");
                        destino = lectura.next().toUpperCase();
                        break;
                    }
                    default : {
                        System.out.println("\nOpción no válida\n");
                        continue;
                    }
                }
                System.out.println("\nIngrese el valor que desea convertir\n");
                cantidadUsuario = lectura.nextDouble();
                try {
                    ConsultaMonedas consultaMonedas = new ConsultaMonedas();
                    Moneda moneda = consultaMonedas.consultaMoneda(origen, destino);
                    Conversion conversion = new Conversion(origen, destino, moneda.getTasaDeCambio(), cantidadUsuario);
                    conversion.conversionMoneda();
                    System.out.println(conversion);
                    historial.agregarConversion(conversion);
                }catch (Exception e){
                    System.out.println("Error en consultar la moneda" + e.getMessage());
                }

        }
    }
}
