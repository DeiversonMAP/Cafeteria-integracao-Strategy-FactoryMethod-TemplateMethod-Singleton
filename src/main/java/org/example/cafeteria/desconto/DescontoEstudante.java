package org.example.cafeteria.desconto;

public class DescontoEstudante implements IEstrategiaDesconto {
    @Override
    public double aplicar(double valor) {
        return valor * 0.90;
    }
}
