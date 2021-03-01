package com.br.zup.tests.servico;

import com.br.zup.tests.Leilao;
import com.br.zup.tests.Usuario;
import com.br.zup.tests.builders.CriadorDeLeilao;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AvaliadorTest {
    private Avaliador avaliador;
    private Usuario thiago;
    private Usuario amanda;
    private Usuario iraci;
    private Usuario joao;
    private Usuario marcao;

    @Before
    public void criaAvaliador() {
        this.avaliador = new Avaliador();
        this.thiago = new Usuario("Thiago");
        this.amanda = new Usuario("Amanda");
        this.iraci = new Usuario("Iraci");
        this.joao = new Usuario("João");
        this.marcao = new Usuario("Marcao Fibras");
    }

    @Test()
    public void naoDeveAvaliarLeiloesSemLances() {
        this.criaAvaliador();
        Leilao leilao = new CriadorDeLeilao().para("MacBook Pro 15 2012").constroi();
        assertThrows(RuntimeException.class, () -> {
            avaliador.avaliaLance(leilao);
        });
    }

    @Test
    public void deveAvaliarLancesEmOrdemCrescente() {
        System.out.println("+++++++++++++++++++++++");
        Leilao leilao = new CriadorDeLeilao().para("Compra de um carro 0 KM")
                .lance(thiago, 100.0)
                .lance(amanda, 200.0)
                .lance(iraci, 300.0)
                .constroi();
        this.criaAvaliador();
        System.out.println(leilao);
        System.out.println(avaliador);
        System.out.println("+++++++++++++++++++++++");
        avaliador.avaliaLance(leilao);
        assertEquals(300, avaliador.getMaiorLance());
        assertEquals(100, avaliador.getMenorLance());
    }

//    @Test
//    public void deveAvaliarLancesEmOrdemDecrescente() {
//        Leilao leilao = new CriadorDeLeilao().para("Compra de um carro 0 KM")
//                .lance(thiago, 300.0)
//                .lance(amanda, 200.0)
//                .lance(iraci, 100.0)
//                .constroi();
//        this.criaAvaliador();
//        avaliador.avaliaLance(leilao);
//        assertEquals(300, avaliador.getMaiorLance());
//        assertEquals(100, avaliador.getMenorLance());
//    }
//
//    @Test
//    public void deveAvaliarLancesEmOrdemAleatoria() {
//
//        Leilao leilao = new CriadorDeLeilao().para("Compra de um carro 0 KM")
//                .lance(thiago, 401.0)
//                .lance(amanda, 250.0)
//                .lance(iraci, 20.0)
//                .lance(joao, 150.0)
//                .lance(marcao, 1200.0)
//                .constroi();
//
//        this.criaAvaliador();
//
//        avaliador.avaliaLance(leilao);
//        assertEquals(1200.0, avaliador.getMaiorLance());
//        assertEquals(20.0, avaliador.getMenorLance());
//    }
//
//    @Test
//    public void deveAvaliarLeilaoComApenasUmLance() {
//        Leilao leilao = new CriadorDeLeilao().para("Compra de um carro 0 KM")
//                .lance(thiago, 401.0)
//                .constroi();
//        this.criaAvaliador();
//        avaliador.avaliaLance(leilao);
//        assertEquals(401.0, avaliador.getMaiorLance());
//        assertEquals(401.0, avaliador.getMenorLance());
//    }
//
//    @Test
//    public void deveAvaliarOsTresMaioresLances() {
//        Leilao leilao = new CriadorDeLeilao().para("Compra de um carro 0 KM")
//                .lance(thiago, 401.0)
//                .lance(amanda, 250.0)
//                .lance(iraci, 20.0)
//                .lance(joao, 150.0)
//                .lance(marcao, 1200.0)
//                .constroi();
//
//        this.criaAvaliador();
//        avaliador.avaliaLance(leilao);
//
//        List<Lance> tresMaiores = avaliador.getTresMaiores();
//        assertEquals(3, tresMaiores.size());
//        assertEquals(1200, tresMaiores.get(0).getValor());
//        assertEquals(401, tresMaiores.get(1).getValor());
//        assertEquals(250, tresMaiores.get(2).getValor());
//    }
//
//    @Test
//    public void deveAvaliarMaioresLancesEmUmaListaComDoisLances() {
//        Leilao leilao = new CriadorDeLeilao().para("Compra de um carro 0 KM")
//                .lance(thiago, 401.0)
//                .lance(amanda, 250.0)
//                .constroi();
//
//        this.criaAvaliador();
//        avaliador.avaliaLance(leilao);
//
//        List<Lance> tresMaiores = avaliador.getTresMaiores();
//        assertEquals(2, tresMaiores.size());
//        assertEquals(401, tresMaiores.get(0).getValor());
//        assertEquals(250, tresMaiores.get(1).getValor());
//    }
//
//    @Test
//    public void deveAvaliarListaDeLancesVazia() {
//        Leilao leilao = new CriadorDeLeilao().para("Compra de um carro 0 KM")
//                .constroi();
//        this.criaAvaliador();
//        avaliador.avaliaLance(leilao);
//        List<Lance> tresMaiores = avaliador.getTresMaiores();
//        assertEquals(0, tresMaiores.size());
//    }
}