package com.sistemabancario.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ContaTest {
    
    @Test
    void criarConta() throws Exception {
            // Arrange
            Agencia agencia = new Agencia("1");
            Cliente cliente = new Cliente("Vladimir", 18);
            Conta conta = new Conta("1", agencia, cliente);
            float saldoEsperado = 0;
            
            // Assert
            assertEquals(cliente, conta.getCliente());
            assertEquals(agencia, conta.getAgencia());
            assertEquals(saldoEsperado, conta.getSaldo());    
    }
    
    @Test
    void deposito() throws Exception {
        // Arrange
        Agencia agencia = new Agencia("1");
        Cliente cliente = new Cliente("Vladimir", 18);
        Conta conta = new Conta("1", agencia, cliente);
        
        // Act
        conta.deposito(50);
        
        // Assert
        assertEquals(50, conta.getSaldo());
        
    }
    
    @Test
    void saque() throws Exception {
        // Arrange
        Agencia agencia = new Agencia("1");
        Cliente cliente = new Cliente("Vladimir", 18);
        Conta conta = new Conta("1", agencia, cliente);
        
        // Act
        conta.deposito(10);
        conta.saque(4);
        
        // Assert
        assertEquals(6, conta.getSaldo());
        
    }
    
    @ParameterizedTest(name = "{index} => value={0}, message={1}")
    @MethodSource
    void saqueInvalido(float value, String message) throws Exception {
        // Arrange
        Agencia agencia = new Agencia("1");
        Cliente cliente = new Cliente("Vladimir", 18);
        Conta conta = new Conta("1", agencia, cliente);
        conta.deposito(10);
        
        // Act
        Exception exception = assertThrows(Exception.class, () -> {
            conta.saque(value);
        });
        
        // Assert
        assertEquals(message, exception.getMessage());
    }
    
    private static Stream<Arguments> saqueInvalido() {
        return Stream.of(
            Arguments.of(-1, "Valor deve ser maior que 0!"),
            Arguments.of(0, "Valor deve ser maior que 0!"),
            Arguments.of(50, "Saldo insuficiente!")
        );
    }
    
    
    @ParameterizedTest(name = "{index} => value={0}, message={1}")
    @MethodSource
    void depositoInvalido(float value, String message) throws Exception {
        // Arrange
        Agencia agencia = new Agencia("1");
        Cliente cliente = new Cliente("Vladimir", 18);
        Conta conta = new Conta("1", agencia, cliente);
        
        // Act
        Exception exception = assertThrows(Exception.class, () -> {
            conta.deposito(value);
        });
        
        // Assert
        assertEquals(message, exception.getMessage());
        
    }
    
    private static Stream<Arguments> depositoInvalido() {
        return Stream.of(
            Arguments.of(-1, "Valor deve ser maior que 0!"),
            Arguments.of(0, "Valor deve ser maior que 0!")
        );
    }
}
