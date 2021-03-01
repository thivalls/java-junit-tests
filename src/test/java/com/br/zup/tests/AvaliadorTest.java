package com.br.zup.tests;

import com.br.zup.tests.servico.Avaliador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AvaliadorTest {

    @Test
    public void main() {
        // Parte 1 - Criando cenário para testar a classe Avaliador
        Usuario thiago = new Usuario("Thiago");
        Usuario amanda = new Usuario("Amanda");
        Usuario iraci = new Usuario("Iraci");
        Usuario joao = new Usuario("João");
        Usuario marcao = new Usuario("Marcao Fibras");

        Lance lance1 = new Lance(thiago, 401);
        Lance lance2 = new Lance(thiago, 250);
        Lance lance3 = new Lance(thiago, 20);
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
        avaliador.avaliaMaiorLance(leilao);
        avaliador.avaliaMenorLance(leilao);

        // Parte 3 - Validando resultados
        Assertions.assertEquals(1200, avaliador.getMaiorLance());
        Assertions.assertEquals(20, avaliador.getMenorLance());
    }}