package org.example.cafeteria.desconto;

public class SemDesconto implements IEstrategiaDesconto {
    @Override
    public double aplicar(double valor) {
        return valor;
    }
}
