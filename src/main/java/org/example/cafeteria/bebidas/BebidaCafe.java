package org.example.cafeteria.bebidas;

public class BebidaCafe extends Bebida {

    @Override
    protected String adicionarIngrediente() {
        return "Adicionando cafe moido";
    }

    @Override
    protected boolean desejaComplemento() {
        return true;
    }

    @Override
    protected String adicionarComplemento() {
        return "Adicionando espuma de leite";
    }

    @Override
    public String getNome() {
        return "Cafe";
    }

    @Override
    public double getPreco() {
        return 8.0;
    }
}
