package com.br.zup.tests.servico;

import com.br.zup.tests.Lance;
import com.br.zup.tests.Leilao;

public class Avaliador {
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;

    public void avaliaMaiorLance(Leilao leilao) {
        for (Lance lance: leilao.getLances()) {
            if (lance.getValor() > maiorLance) maiorLance = lance.getValor();
        }
    }

    public void avaliaMenorLance(Leilao leilao) {
        for (Lance lance: leilao.getLances()) {
            if (lance.getValor() < menorLance) menorLance = lance.getValor();
        }
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }
}
