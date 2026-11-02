package org.example.cafeteria.desconto;

public class DescontoFidelidade implements IEstrategiaDesconto {
    @Override
    public double aplicar(double valor) {
        return valor * 0.85;
    }
}
