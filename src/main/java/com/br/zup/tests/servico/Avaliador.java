package com.br.zup.tests.servico;

import com.br.zup.tests.Lance;
import com.br.zup.tests.Leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Avaliador {
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;
    private List maiores;

    public void avaliaLance(Leilao leilao) {
        if(leilao.getLances().size() == 0) {
            throw new RuntimeException("Não é possível avaliar leilão sem nenhum lance");
        }

        for (Lance lance: leilao.getLances()) {
            if (lance.getValor() > maiorLance) maiorLance = lance.getValor();
            if (lance.getValor() < menorLance) menorLance = lance.getValor();
        }

        maiores = new ArrayList<Lance>(leilao.getLances());
        Collections.sort(maiores, new Comparator<Lance>() {
            public int compare(Lance o1, Lance o2) {
                if(o1.getValor() < o2.getValor()) return 1;
                if(o1.getValor() > o2.getValor()) return -1;
                return 0;
            }
        });

        maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
    }

//    public void avaliaMenorLance(Leilao leilao) {
//        for (Lance lance: leilao.getLances()) {
//            if (lance.getValor() < menorLance) menorLance = lance.getValor();
//        }
//    }


    public List<Lance> getTresMaiores() {
        return maiores;
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }
}
