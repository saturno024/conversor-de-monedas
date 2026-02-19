package com.fabianmesa.conversordemonedas.calculos;

import com.fabianmesa.conversordemonedas.modelos.Moneda;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
/**
 * Challenge Conversor de Monedas - Alura Latam / Oracle Next Education
 * @author Carlos Fabian Mesa Muñoz (saturno024)
 * @version 1.0
 * @since 2026-02-19
 */
public class Conversion extends Moneda {
    private double cantidadUsuario;
    private double resultadoFinal;
    private LocalDateTime fechaHora;


    public Conversion(String monedaOrigen, String monedaDestino, double tasaDeCambio, double cantidadUsuario ) {
        super(monedaOrigen, monedaDestino, tasaDeCambio);
        this.cantidadUsuario = cantidadUsuario;
        this.fechaHora = LocalDateTime.now();
    }

    public double conversionMoneda(){
        this.resultadoFinal = this.cantidadUsuario * getTasaDeCambio();
        return this.resultadoFinal;

    }

    @Override
    public String toString() {
        // 1. Formateadores de números (Tasa y Dinero)
        java.text.DecimalFormat dfTasa = new java.text.DecimalFormat("#.##########");
        java.text.DecimalFormat dfDinero = new java.text.DecimalFormat("#,###.00");

        // 2. Formateador de fecha (Día/Mes/Año Hora:Minuto:Segundo)
        java.time.format.DateTimeFormatter formatoFecha = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaBonita = fechaHora.format(formatoFecha);

        // 3. El bloque de texto final
        return """
        \n
        ====================================================
        |              RESULTADO DE CONVERSION             |
        ====================================================
        
        Moneda Origen:  [%s] 
        Moneda Destino: [%s]
        
        Tasa de Cambio: %s
        ----------------------------------------------------
        Monto ingresado: %s %s
        VALOR FINAL:     %s %s
        Fecha:           %s 
        
        ====================================================
        """.formatted(
                getMonedaOrigen(),
                getMonedaDestino(),
                dfTasa.format(getTasaDeCambio()),
                dfDinero.format(cantidadUsuario),
                getMonedaOrigen(),
                dfDinero.format(resultadoFinal),
                getMonedaDestino(),
                fechaBonita
        );
    }

}



