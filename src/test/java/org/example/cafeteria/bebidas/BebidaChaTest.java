package org.example.cafeteria.bebidas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebidaChaTest {

    @Test
    void devePrepararChaSemComplemento() {
        Bebida bebida = new BebidaCha();
        assertEquals(
                "Fervendo agua -> Infundindo saquinho de cha -> Servindo Cha",
                bebida.preparar()
        );
    }

    @Test
    void deveTerPrecoBase() {
        assertEquals(6.0, new BebidaCha().getPreco(), 0.001);
    }
}
