package org.example.cafeteria.bebidas;

public class BebidaFactory {

    public static Bebida obterBebida(String tipo) {
        Class<?> classe;
        Object objeto;
        try {
            classe = Class.forName("org.example.cafeteria.bebidas.Bebida" + tipo);
            objeto = classe.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Bebida inexistente");
        }
        if (!(objeto instanceof Bebida)) {
            throw new IllegalArgumentException("Bebida invalida");
        }
        return (Bebida) objeto;
    }
}
