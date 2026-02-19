package com.fabianmesa.conversordemonedas.modelos;

import java.util.Map;
/**
 * Challenge Conversor de Monedas - Alura Latam / Oracle Next Education
 * @author Carlos Fabian Mesa Muñoz (saturno024)
 * @version 1.0
 * @since 2026-02-19
 */
public record MonedaDTO(String base_code,
                        Map<String, Double> conversion_rates) {
}
