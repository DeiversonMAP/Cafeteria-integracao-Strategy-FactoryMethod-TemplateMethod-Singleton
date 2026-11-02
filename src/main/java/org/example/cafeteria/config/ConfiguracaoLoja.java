package org.example.cafeteria.config;

public class ConfiguracaoLoja {

    private static ConfiguracaoLoja instancia;

    private String nomeLoja;
    private double taxaServicoPercentual;

    private ConfiguracaoLoja() {
        this.nomeLoja = "Cafe Central";
        this.taxaServicoPercentual = 10.0;
    }

    public static ConfiguracaoLoja getInstance() {
        if (instancia == null) {
            instancia = new ConfiguracaoLoja();
        }
        return instancia;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public double getTaxaServicoPercentual() {
        return taxaServicoPercentual;
    }

    public void setTaxaServicoPercentual(double taxaServicoPercentual) {
        this.taxaServicoPercentual = taxaServicoPercentual;
    }
}
