package org.example.cafeteria.bebidas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebidaFactoryTest {

    @Test
    void deveCriarCafe() {
        assertTrue(BebidaFactory.obterBebida("Cafe") instanceof BebidaCafe);
    }

    @Test
    void deveCriarCha() {
        assertTrue(BebidaFactory.obterBebida("Cha") instanceof BebidaCha);
    }

    @Test
    void deveCriarChocolate() {
        assertTrue(BebidaFactory.obterBebida("Chocolate") instanceof BebidaChocolate);
    }

    @Test
    void deveLancarExcecaoParaBebidaInexistente() {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> BebidaFactory.obterBebida("Suco")
        );
        assertEquals("Bebida inexistente", excecao.getMessage());
    }

    @Test
    void deveLancarExcecaoParaClasseAbstrata() {
        // "Bebida" + "" resolve para a classe abstrata Bebida, que nao pode ser instanciada.
        assertThrows(IllegalArgumentException.class, () -> BebidaFactory.obterBebida(""));
    }
}
