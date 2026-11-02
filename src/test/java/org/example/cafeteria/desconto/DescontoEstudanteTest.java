package org.example.cafeteria.desconto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescontoEstudanteTest {

    @Test
    void deveAplicarDezPorCentoDeDesconto() {
        IEstrategiaDesconto estrategia = new DescontoEstudante();
        assertEquals(9.0, estrategia.aplicar(10.0), 0.001);
    }
}
