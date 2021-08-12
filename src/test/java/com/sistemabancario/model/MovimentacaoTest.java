package com.sistemabancario.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MovimentacaoTest {
    @Test
    void criarMovimentacao() throws Exception {
        // Arrange
        Agencia agencia = new Agencia("1");
        Cliente cliente = new Cliente("Vladimir", 18);
        Conta conta = new Conta("1", agencia, cliente);
        Movimentacao movimentacao = new Movimentacao(conta, TipoMovimentacao.DEPOSITO, 50);
           
        // Assert
        assertEquals(false, movimentacao.isConfirmada());
        assertEquals(conta, movimentacao.getConta());
        assertEquals(TipoMovimentacao.DEPOSITO, movimentacao.getTipo());
        assertEquals(50, movimentacao.getValor());
    }
    
    @Test
    void setDescricaoMovimentacao() throws Exception {
        // Arrange
        Agencia agencia = new Agencia("1");
        Cliente cliente = new Cliente("Vladimir", 18);
        Conta conta = new Conta("1", agencia, cliente);
        Movimentacao movimentacao = new Movimentacao(conta, TipoMovimentacao.DEPOSITO, 50);
        String descricaoEsperada = "deposito";

        // Act
        movimentacao.setDescricao("deposito");
       
        // Assert
        assertEquals(descricaoEsperada, movimentacao.getDescricao());    
    }
    
        @Test
    void setConfirmacaoMovimentacao() throws Exception {
        // Arrange
        Agencia agencia = new Agencia("1");
        Cliente cliente = new Cliente("Vladimir", 18);
        Conta conta = new Conta("1", agencia, cliente);
        Movimentacao movimentacao = new Movimentacao(conta, TipoMovimentacao.DEPOSITO, 50);
        
        // Act
        movimentacao.setConfirmada(true);
        
        // Assert
        assertEquals(true, movimentacao.isConfirmada());    
    }
     
    
    @ParameterizedTest(name = "{index} => descricao={0}, message={1}")
    @MethodSource
    void setDescricaoMovimentacaoInvalida(String descricao, String message) throws Exception {
        // Arrange
        Agencia agencia = new Agencia("1");
        Cliente cliente = new Cliente("Vladimir", 18);
        Conta conta = new Conta("1", agencia, cliente);
        Movimentacao movimentacao = new Movimentacao(conta, TipoMovimentacao.DEPOSITO, 50);
        
        // Act
        Exception exception = assertThrows(Exception.class, () -> {
             movimentacao.setDescricao(descricao);
        });
        
        // Assert
        assertTrue(exception.getMessage().contains(message));    
    }
     
    private static Stream<Arguments> setDescricaoMovimentacaoInvalida() {
        return Stream.of(
            Arguments.of("", "Descrição não pode ser vazia."),
            Arguments.of(null, "Descrição não pode ser nula.")
        );
    }

}
