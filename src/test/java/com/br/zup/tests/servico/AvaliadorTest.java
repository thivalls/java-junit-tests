package com.br.zup.tests.servico;

import com.br.zup.tests.Lance;
import com.br.zup.tests.Leilao;
import com.br.zup.tests.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AvaliadorTest {

    @Test
    public void deveAvaliarLancesEmOrdemCrescente() {
        // Parte 1 - Criando cenário para testar a classe Avaliador
        Usuario thiago = new Usuario("Thiago");
        Usuario amanda = new Usuario("Amanda");
        Usuario iraci = new Usuario("Iraci");

        Lance lance1 = new Lance(thiago, 100);
        Lance lance2 = new Lance(amanda, 200);
        Lance lance3 = new Lance(iraci, 300);

        Leilao leilao = new Leilao("Compra de um carro 0 KM");

        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);

        // Parte 2 - Executando classe Avaliador
        Avaliador avaliador = new Avaliador();
        avaliador.avaliaLance(leilao);

        // Parte 3 - Validando resultados
        assertEquals(300, avaliador.getMaiorLance());
        assertEquals(100, avaliador.getMenorLance());
    }

    @Test
    public void deveAvaliarLancesEmOrdemDecrescente() {
        // Parte 1 - Criando cenário para testar a classe Avaliador
        Usuario thiago = new Usuario("Thiago");
        Usuario amanda = new Usuario("Amanda");
        Usuario iraci = new Usuario("Iraci");

        Lance lance1 = new Lance(thiago, 300);
        Lance lance2 = new Lance(amanda, 200);
        Lance lance3 = new Lance(iraci, 100);

        Leilao leilao = new Leilao("Compra de um carro 0 KM");

        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);

        // Parte 2 - Executando classe Avaliador
        Avaliador avaliador = new Avaliador();
        avaliador.avaliaLance(leilao);

        // Parte 3 - Validando resultados
        assertEquals(300, avaliador.getMaiorLance());
        assertEquals(100, avaliador.getMenorLance());
    }

    @Test
    public void deveAvaliarLancesEmOrdemAleatoria() {
        // Parte 1 - Criando cenário para testar a classe Avaliador
        Usuario thiago = new Usuario("Thiago");
        Usuario amanda = new Usuario("Amanda");
        Usuario iraci = new Usuario("Iraci");
        Usuario joao = new Usuario("João");
        Usuario marcao = new Usuario("Marcao Fibras");

        Lance lance1 = new Lance(thiago, 401);
        Lance lance2 = new Lance(amanda, 250);
        Lance lance3 = new Lance(iraci, 20);
        Lance lance4 = new Lance(joao, 150);
        Lance lance5 = new Lance(marcao, 1200);

        Leilao leilao = new Leilao("Compra de um carro 0 KM");

        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);
        leilao.propoe(lance4);
        leilao.propoe(lance5);

        // Parte 2 - Executando classe Avaliador
        Avaliador avaliador = new Avaliador();
        avaliador.avaliaLance(leilao);

        // Parte 3 - Validando resultados
        assertEquals(1200, avaliador.getMaiorLance());
        assertEquals(20, avaliador.getMenorLance());
    }

    @Test
    public void deveAvaliarLeilaoComApenasUmLance() {
        // Parte 1 - Criando cenário para testar a classe Avaliador
        Usuario thiago = new Usuario("Thiago");

        Lance lance1 = new Lance(thiago, 401);

        Leilao leilao = new Leilao("Compra de um carro 0 KM");

        leilao.propoe(lance1);

        // Parte 2 - Executando classe Avaliador
        Avaliador avaliador = new Avaliador();
        avaliador.avaliaLance(leilao);

        // Parte 3 - Validando resultados
        assertEquals(401, avaliador.getMaiorLance());
        assertEquals(401, avaliador.getMenorLance());
    }

    @Test
    public void deveAvaliarOsTresMaioresLances() {
        // Parte 1 - Criando cenário para testar a classe Avaliador
        Usuario thiago = new Usuario("Thiago");
        Usuario amanda = new Usuario("Amanda");
        Usuario iraci = new Usuario("Iraci");
        Usuario joao = new Usuario("João");
        Usuario marcao = new Usuario("Marcao Fibras");

        Lance lance1 = new Lance(thiago, 401);
        Lance lance2 = new Lance(amanda, 250);
        Lance lance3 = new Lance(iraci, 20);
        Lance lance4 = new Lance(joao, 150);
        Lance lance5 = new Lance(marcao, 1200);

        Leilao leilao = new Leilao("Compra de um carro 0 KM");

        leilao.propoe(lance1);
        leilao.propoe(lance2);
        leilao.propoe(lance3);
        leilao.propoe(lance4);
        leilao.propoe(lance5);

        // Parte 2 - Executando classe Avaliador
        Avaliador avaliador = new Avaliador();
        avaliador.avaliaLance(leilao);

        // Parte 3 - Validando resultados
        List<Lance> tresMaiores = avaliador.getTresMaiores();
        assertEquals(3, tresMaiores.size());
        assertEquals(1200, tresMaiores.get(0).getValor());
        assertEquals(401, tresMaiores.get(1).getValor());
        assertEquals(250, tresMaiores.get(2).getValor());
    }

    @Test
    public void deveAvaliarMaioresLancesEmUmaListaComDoisLances() {
        // Parte 1 - Criando cenário para testar a classe Avaliador
        Usuario thiago = new Usuario("Thiago");
        Usuario amanda = new Usuario("Amanda");

        Lance lance1 = new Lance(thiago, 401);
        Lance lance2 = new Lance(amanda, 250);

        Leilao leilao = new Leilao("Compra de um carro 0 KM");

        leilao.propoe(lance1);
        leilao.propoe(lance2);

        // Parte 2 - Executando classe Avaliador
        Avaliador avaliador = new Avaliador();
        avaliador.avaliaLance(leilao);

        // Parte 3 - Validando resultados
        List<Lance> tresMaiores = avaliador.getTresMaiores();
        assertEquals(2, tresMaiores.size());
        assertEquals(401, tresMaiores.get(0).getValor());
        assertEquals(250, tresMaiores.get(1).getValor());
    }

    @Test
    public void deveAvaliarListaDeLancesVazia() {
        Leilao leilao = new Leilao("Compra de um carro 0 KM");
        Avaliador avaliador = new Avaliador();
        avaliador.avaliaLance(leilao);

        // Parte 3 - Validando resultados
        List<Lance> tresMaiores = avaliador.getTresMaiores();
        assertEquals(0, tresMaiores.size());
    }
}