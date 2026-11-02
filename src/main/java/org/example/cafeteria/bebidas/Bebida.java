package org.example.cafeteria.bebidas;

import java.util.ArrayList;
import java.util.List;

public abstract class Bebida {

    /** Template method: fixa a ordem dos passos e nao pode ser sobrescrito. */
    public final String preparar() {
        List<String> passos = new ArrayList<>();
        passos.add(ferverAgua());
        passos.add(adicionarIngrediente());
        if (desejaComplemento()) {
            passos.add(adicionarComplemento());
        }
        passos.add(servir());
        return String.join(" -> ", passos);
    }

    // Passo concreto: igual para todas as bebidas.
    protected String ferverAgua() {
        return "Fervendo agua";
    }

    // Passo abstrato: cada bebida implementa o seu.
    protected abstract String adicionarIngrediente();

    // Hooks: tem comportamento padrao e podem ser sobrescritos.
    protected boolean desejaComplemento() {
        return false;
    }

    protected String adicionarComplemento() {
        return "Sem complemento";
    }

    protected String servir() {
        return "Servindo " + getNome();
    }

    public abstract String getNome();

    public abstract double getPreco();
}
