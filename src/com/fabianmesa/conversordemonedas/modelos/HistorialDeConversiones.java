package com.fabianmesa.conversordemonedas.modelos;

import com.fabianmesa.conversordemonedas.calculos.Conversion;

import java.util.ArrayList;
import java.util.List;
/**
 * Challenge Conversor de Monedas - Alura Latam / Oracle Next Education
 * @author Carlos Fabian Mesa Muñoz (saturno024)
 * @version 1.0
 * @since 2026-02-19
 */
public class HistorialDeConversiones {
    private List<Conversion> historial = new ArrayList<>();

    public void agregarConversion(Conversion conversion) {
        historial.add(conversion);
    }
    public List<Conversion> getHistorial() {
        return historial;
    }
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Historial de conversiones no encontrados.");
        }else{
            System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("----------HISTORIAL DE CONVERSIONES.-----------------");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
            for (Conversion conversion : historial) {
                System.out.println(conversion.toString()+"\n");
            }
            System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            System.out.println("---------------FIN HISTORIAL DE CONVERSIONES----------");
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
        }

    }
}
