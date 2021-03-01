package com.br.zup.tests;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeilaoTest {

    @Test
    public void naoDevePermitirDoisLancesSeguidosPorUmMesmoUsuario() {
        Leilao leilao = new Leilao("MacBook Pro 2015");
        Usuario steve = new Usuario("Steve Jobs");

        leilao.propoe(new Lance(steve, 2000));
        leilao.propoe(new Lance(steve, 3000));

        assertEquals(1, leilao.getLances().size());
        assertEquals(2000, leilao.getLances().get(0).getValor());
    }

    @Test
    public void naoDevePermitirMaisQue5LancesPorUmMesmoUsuario() {
        Leilao leilao = new Leilao("MacBook Pro 2015");

        Usuario steve = new Usuario("Steve Jobs");
        Usuario bill = new Usuario("Bill Gates");

        leilao.propoe(new Lance(steve, 2000));
        leilao.propoe(new Lance(bill, 3000));

        leilao.propoe(new Lance(steve, 4000));
        leilao.propoe(new Lance(bill, 5000));

        leilao.propoe(new Lance(steve, 6000));
        leilao.propoe(new Lance(bill, 7000));

        leilao.propoe(new Lance(steve, 8000));
        leilao.propoe(new Lance(bill, 9000));

        leilao.propoe(new Lance(steve, 10000));
        leilao.propoe(new Lance(bill, 11000));

        leilao.propoe(new Lance(steve, 12000));

        assertEquals(10, leilao.getLances().size());
        assertEquals(11000, leilao.getLances().get(leilao.getLances().size() - 1).getValor());
    }

    @Test
    public void deveDobrarUltimoLanceDadoPorUmUsuario() {
        Leilao leilao = new Leilao("MacBook Pro 2015");

        Usuario steve = new Usuario("Steve Jobs");
        Usuario bill = new Usuario("Bill Gates");

        leilao.propoe(new Lance(steve, 2000));
        leilao.propoe(new Lance(bill, 3000));

        leilao.dobraLance(steve);

        assertEquals(3, leilao.getLances().size());
        assertEquals(4000, leilao.getLances().get(leilao.getLances().size() - 1).getValor());
    }

    @Test
    public void naoDeveCriarUmLanceDobradoCasoNaoExistaUmLanceAnterior() {
        Leilao leilao = new Leilao("MacBook Pro 2015");

        Usuario steve = new Usuario("Steve Jobs");

        leilao.dobraLance(steve);

        assertEquals(0, leilao.getLances().size());
    }

    @Test
    public void naoDeveCriarUmLanceDobradoCasoOUltimoLanceSejaDoProprioUsuario() {
        Leilao leilao = new Leilao("MacBook Pro 2015");

        Usuario steve = new Usuario("Steve Jobs");
        leilao.propoe(new Lance(steve, 2000));

        leilao.dobraLance(steve);

        assertEquals(1, leilao.getLances().size());
    }

    @Test
    public void naoDeveCriarUmLanceDobradoCasoJaExista5LancesAnteriores() {
        Leilao leilao = new Leilao("MacBook Pro 2015");

        Usuario steve = new Usuario("Steve Jobs");
        Usuario bill = new Usuario("Bill Gates");

        leilao.propoe(new Lance(steve, 2000));
        leilao.propoe(new Lance(bill, 3000));

        leilao.propoe(new Lance(steve, 4000));
        leilao.propoe(new Lance(bill, 5000));

        leilao.propoe(new Lance(steve, 6000));
        leilao.propoe(new Lance(bill, 7000));

        leilao.propoe(new Lance(steve, 8000));
        leilao.propoe(new Lance(bill, 9000));

        leilao.propoe(new Lance(steve, 10000));
        leilao.propoe(new Lance(bill, 11000));

        leilao.dobraLance(steve);
        leilao.dobraLance(steve);
        leilao.dobraLance(steve);

        assertEquals(10, leilao.getLances().size());
        assertEquals(11000, leilao.getLances().get(leilao.getLances().size() - 1).getValor());
    }

    @Test
    public void deveCriarUmLanceDobradoCasoJaExista4LancesAnteriores() {
        Leilao leilao = new Leilao("MacBook Pro 2015");

        Usuario steve = new Usuario("Steve Jobs");
        Usuario bill = new Usuario("Bill Gates");

        leilao.propoe(new Lance(steve, 2000));
        leilao.propoe(new Lance(bill, 3000));

        leilao.propoe(new Lance(steve, 4000));
        leilao.propoe(new Lance(bill, 5000));

        leilao.propoe(new Lance(steve, 6000));
        leilao.propoe(new Lance(bill, 7000));

        leilao.propoe(new Lance(steve, 8000));
        leilao.propoe(new Lance(bill, 9000));

        leilao.dobraLance(steve);

        assertEquals(9, leilao.getLances().size());
        assertEquals(16000, leilao.getLances().get(leilao.getLances().size() - 1).getValor());
    }
}