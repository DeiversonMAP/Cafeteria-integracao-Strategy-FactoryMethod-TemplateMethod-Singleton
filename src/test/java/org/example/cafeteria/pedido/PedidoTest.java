package org.example.cafeteria.pedido;

import org.example.cafeteria.config.ConfiguracaoLoja;
import org.example.cafeteria.desconto.DescontoEstudante;
import org.example.cafeteria.desconto.DescontoFidelidade;
import org.example.cafeteria.desconto.SemDesconto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @BeforeEach
    @AfterEach
    void restaurarConfiguracao() {
        ConfiguracaoLoja.getInstance().setNomeLoja("Cafe Central");
        ConfiguracaoLoja.getInstance().setTaxaServicoPercentual(10.0);
    }

    @Test
    void deveCalcularTotalSemDescontoComTaxaDeServico() {
        Pedido pedido = new Pedido("Cafe", new SemDesconto());
        assertEquals(8.8, pedido.calcularTotal(), 0.001);
    }

    @Test
    void deveCalcularTotalComDescontoEstudante() {
        Pedido pedido = new Pedido("Cafe", new DescontoEstudante());
        assertEquals(7.92, pedido.calcularTotal(), 0.001);
    }

    @Test
    void deveCalcularTotalComDescontoFidelidade() {
        Pedido pedido = new Pedido("Chocolate", new DescontoFidelidade());
        assertEquals(11.22, pedido.calcularTotal(), 0.001);
    }

    @Test
    void deveUsarTaxaAlteradaNoSingleton() {
        ConfiguracaoLoja.getInstance().setTaxaServicoPercentual(0.0);
        Pedido pedido = new Pedido("Cafe", new DescontoEstudante());
        assertEquals(7.2, pedido.calcularTotal(), 0.001);
    }

    @Test
    void deveMontarComprovanteComNomeDaLojaPreparoETotal() {
        Pedido pedido = new Pedido("Cafe", new DescontoEstudante());
        assertEquals(
                "Cafe Central: Fervendo agua -> Adicionando cafe moido -> Adicionando espuma de leite -> Servindo Cafe | Total: R$ 7.92",
                pedido.comprovante()
        );
    }

    @Test
    void deveUsarNomeDaLojaAlteradoNoSingleton() {
        ConfiguracaoLoja.getInstance().setNomeLoja("Cafe da Praca");
        Pedido pedido = new Pedido("Cha", new SemDesconto());
        assertTrue(pedido.comprovante().startsWith("Cafe da Praca: "));
    }

    @Test
    void deveRejeitarBebidaInexistente() {
        assertThrows(IllegalArgumentException.class, () -> new Pedido("Suco", new SemDesconto()));
    }
}
