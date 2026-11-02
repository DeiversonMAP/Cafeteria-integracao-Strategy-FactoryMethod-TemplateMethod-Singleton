package org.example.cafeteria.pedido;

import org.example.cafeteria.bebidas.Bebida;
import org.example.cafeteria.bebidas.BebidaFactory;
import org.example.cafeteria.config.ConfiguracaoLoja;
import org.example.cafeteria.desconto.IEstrategiaDesconto;

import java.util.Locale;

/**
 * Ponto unico de integracao dos quatro padroes:
 * - Factory Method: cria a bebida pelo nome (BebidaFactory);
 * - Template Method: a bebida criada se prepara por Bebida.preparar();
 * - Strategy: o desconto vem de uma IEstrategiaDesconto intercambiavel;
 * - Singleton: ConfiguracaoLoja fornece a taxa de servico e o nome da loja.
 */
public class Pedido {

    private final Bebida bebida;
    private final IEstrategiaDesconto estrategiaDesconto;

    public Pedido(String tipoBebida, IEstrategiaDesconto estrategiaDesconto) {
        this.bebida = BebidaFactory.obterBebida(tipoBebida);
        this.estrategiaDesconto = estrategiaDesconto;
    }

    public double calcularTotal() {
        double comDesconto = estrategiaDesconto.aplicar(bebida.getPreco());
        double taxa = ConfiguracaoLoja.getInstance().getTaxaServicoPercentual();
        return comDesconto * (1 + taxa / 100);
    }

    public String comprovante() {
        String loja = ConfiguracaoLoja.getInstance().getNomeLoja();
        return loja + ": " + bebida.preparar()
                + " | Total: R$ " + String.format(Locale.US, "%.2f", calcularTotal());
    }
}
