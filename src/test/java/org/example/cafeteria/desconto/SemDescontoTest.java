package org.example.cafeteria.desconto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SemDescontoTest {

    @Test
    void deveManterOValorOriginal() {
        IEstrategiaDesconto estrategia = new SemDesconto();
        assertEquals(10.0, estrategia.aplicar(10.0), 0.001);
    }
}
