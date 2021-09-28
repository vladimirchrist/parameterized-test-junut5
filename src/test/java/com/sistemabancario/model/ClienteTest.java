package com.sistemabancario.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ClienteTest {
    
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 17})
    void criarClienteFail(int number) {
        // Arrange
        Exception exception = assertThrows(Exception.class, () -> {
            new Cliente("Vladimir", number);
        });
        
        // Act
        assertTrue(exception.getMessage().contains("Cliente nao possui idade minima!"));      
    }
    
    @ParameterizedTest
    @ValueSource(ints = {18, 19, 50})
    void criarCliente(int number) throws Exception {
        // Arrange
        Cliente cliente = new Cliente("Vladimir", number);
        String nomeEsperado = "Vladimir";
        
        // Assert
        assertEquals(nomeEsperado, cliente.getNome());
        assertEquals(number, cliente.getIdade());
    }
    
    @Test
    void setNomeCliente() throws Exception {
        // Arrange
        Cliente cliente = new Cliente("Vladimir", 18);
        cliente.setNome("Paulo");
        String nomeEsperado = "Paulo";
        
        // Assert
        assertEquals(nomeEsperado, cliente.getNome());
    }
}
