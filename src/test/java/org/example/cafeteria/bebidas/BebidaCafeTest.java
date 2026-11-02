package org.example.cafeteria.bebidas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebidaCafeTest {

    @Test
    void devePrepararCafeComEspumaDeLeite() {
        Bebida bebida = new BebidaCafe();
        assertEquals(
                "Fervendo agua -> Adicionando cafe moido -> Adicionando espuma de leite -> Servindo Cafe",
                bebida.preparar()
        );
    }

    @Test
    void deveTerPrecoBase() {
        assertEquals(8.0, new BebidaCafe().getPreco(), 0.001);
    }
}
