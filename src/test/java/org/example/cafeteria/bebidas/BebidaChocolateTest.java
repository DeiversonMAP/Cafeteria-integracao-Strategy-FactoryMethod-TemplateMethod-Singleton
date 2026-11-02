package org.example.cafeteria.bebidas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebidaChocolateTest {

    @Test
    void devePrepararChocolateComChantilly() {
        Bebida bebida = new BebidaChocolate();
        assertEquals(
                "Fervendo agua -> Dissolvendo chocolate em po -> Adicionando chantilly -> Servindo Chocolate",
                bebida.preparar()
        );
    }

    @Test
    void deveTerPrecoBase() {
        assertEquals(12.0, new BebidaChocolate().getPreco(), 0.001);
    }
}
