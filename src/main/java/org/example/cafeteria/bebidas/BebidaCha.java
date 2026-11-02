package org.example.cafeteria.bebidas;

public class BebidaCha extends Bebida {

    @Override
    protected String adicionarIngrediente() {
        return "Infundindo saquinho de cha";
    }

    @Override
    public String getNome() {
        return "Cha";
    }

    @Override
    public double getPreco() {
        return 6.0;
    }
}
