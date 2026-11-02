package org.example.cafeteria.bebidas;

public class BebidaChocolate extends Bebida {

    @Override
    protected String adicionarIngrediente() {
        return "Dissolvendo chocolate em po";
    }

    @Override
    protected boolean desejaComplemento() {
        return true;
    }

    @Override
    protected String adicionarComplemento() {
        return "Adicionando chantilly";
    }

    @Override
    public String getNome() {
        return "Chocolate";
    }

    @Override
    public double getPreco() {
        return 12.0;
    }
}
