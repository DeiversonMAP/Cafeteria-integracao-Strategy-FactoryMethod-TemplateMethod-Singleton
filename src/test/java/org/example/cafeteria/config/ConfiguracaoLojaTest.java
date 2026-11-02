package org.example.cafeteria.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracaoLojaTest {

    @AfterEach
    void restaurarPadroes() {
        ConfiguracaoLoja.getInstance().setNomeLoja("Cafe Central");
        ConfiguracaoLoja.getInstance().setTaxaServicoPercentual(10.0);
    }

    @Test
    void deveRetornarSempreAMesmaInstancia() {
        assertSame(ConfiguracaoLoja.getInstance(), ConfiguracaoLoja.getInstance());
    }

    @Test
    void deveTerValoresPadrao() {
        assertEquals("Cafe Central", ConfiguracaoLoja.getInstance().getNomeLoja());
        assertEquals(10.0, ConfiguracaoLoja.getInstance().getTaxaServicoPercentual(), 0.001);
    }

    @Test
    void deveCompartilharAlteracoesEntreReferencias() {
        ConfiguracaoLoja.getInstance().setTaxaServicoPercentual(5.0);
        assertEquals(5.0, ConfiguracaoLoja.getInstance().getTaxaServicoPercentual(), 0.001);
    }
}
