package org.example.cafeteria.bebidas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BebidaTest {

    @Test
    void deveManterOrdemDosPassosDefinidaPelaClasseBase() {
        String resultado = new BebidaCafe().preparar();

        int agua = resultado.indexOf("Fervendo agua");
        int ingrediente = resultado.indexOf("cafe moido");
        int complemento = resultado.indexOf("espuma");
        int servir = resultado.indexOf("Servindo");

        assertTrue(agua < ingrediente);
        assertTrue(ingrediente < complemento);
        assertTrue(complemento < servir);
    }

    @Test
    void deveUsarComplementoPadraoQuandoHookLigadoSemSobrescreverPasso() {
        Bebida bebida = new Bebida() {
            @Override
            protected String adicionarIngrediente() {
                return "Ingrediente X";
            }

            @Override
            protected boolean desejaComplemento() {
                return true;
            }

            @Override
            public String getNome() {
                return "Teste";
            }

            @Override
            public double getPreco() {
                return 1.0;
            }
        };

        assertEquals(
                "Fervendo agua -> Ingrediente X -> Sem complemento -> Servindo Teste",
                bebida.preparar()
        );
    }
}
