package com.br.zup.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

    private String descricao;
    private List<Lance> lances;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<Lance>();
    }

    public void propoe(Lance lance) {
        if (lances.isEmpty() || podeDarLance(lance.getUsuario())) {
            lances.add(lance);
        }
    }

    public void dobraLance(Usuario usuario) {
        Lance lastLance = null;
        for (Lance lance : lances) {
            if (lance.getUsuario().equals(usuario)) lastLance = lance;
        }
        if (lastLance != null && podeDarLance(usuario)) {
            this.propoe(new Lance(usuario, lastLance.getValor() * 2));
        }
    }

    private boolean podeDarLance(Usuario usuario) {
        return !getUsuarioUltimoLance().equals(usuario) && (getTotalDeLances(usuario) < 5);
    }

    private int getTotalDeLances(Usuario usuario) {
        int total = 0;
        for (Lance l : lances) {
            if (l.getUsuario().equals(usuario)) total++;
        }
        return total;
    }

    private Usuario getUsuarioUltimoLance() {
        return lances.get((lances.size() - 1)).getUsuario();
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Lance> getLances() {
        return Collections.unmodifiableList(lances);
    }
}
