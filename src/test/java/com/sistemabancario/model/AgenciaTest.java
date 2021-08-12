package com.sistemabancario.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AgenciaTest {
    
    @Test
    void criarAgencia() {
        // Arrange
        Agencia agencia = new Agencia("1");
        String numeroEsperado = "1";
        
        // Assert
        assertEquals(numeroEsperado, agencia.getNumero());
    }
    
    @Test
    void adicionarContaAgencia() throws Exception {
        // Arrange
        Agencia agencia = new Agencia("1");
        Conta conta = new Conta("1", agencia, new Cliente("Vladimir", 18)); 
        
        // Act
        agencia.addConta(conta);    

        // Assert
        assertEquals(true , agencia.contains(conta));
    }
    
        @Test
    void removerContaAgencia() throws Exception {
        // Arrange
        Agencia agencia = new Agencia("1");
        Conta conta = new Conta("1", agencia, new Cliente("Vladimir", 18));        
        agencia.addConta(conta);   

        // Act
        agencia.remove(conta);

        // Assert
        assertEquals(false , agencia.contains(conta));
    }
    
    @Test
    void adicionarContasAgencia() throws Exception {
        // Arrange
        Agencia agencia = new Agencia("1");
        Conta c1 = new Conta("1", agencia, new Cliente("Vladimir", 18));        
        agencia.addConta(c1);
        Conta c2 = new Conta("2", agencia, new Cliente("Joao", 18));
        agencia.addConta(c2);
        int qtdContasEsperado = 2;        

        // Assert
        assertEquals(qtdContasEsperado, agencia.getNumeroDeContas());
    }
    
}
