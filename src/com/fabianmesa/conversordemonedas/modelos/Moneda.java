package com.fabianmesa.conversordemonedas.modelos;

public class Moneda {
    private String monedaOrigen;
    private String monedaDestino;
    private double tasaDeCambio;
    /**
     * Challenge Conversor de Monedas - Alura Latam / Oracle Next Education
     * @author Carlos Fabian Mesa Muñoz (saturno024)
     * @version 1.0
     * @since 2026-02-19
     */
    public Moneda(String monedaOrigen, String monedaDestino, double tasaDeCambio) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tasaDeCambio = tasaDeCambio;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getTasaDeCambio() {
        return tasaDeCambio;
    }

}
