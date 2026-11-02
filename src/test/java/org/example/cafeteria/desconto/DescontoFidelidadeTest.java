package org.example.cafeteria.desconto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescontoFidelidadeTest {

    @Test
    void deveAplicarQuinzePorCentoDeDesconto() {
        IEstrategiaDesconto estrategia = new DescontoFidelidade();
        assertEquals(8.5, estrategia.aplicar(10.0), 0.001);
    }
}
