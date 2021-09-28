package com.sistemabancario.model;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    private final Agencia agencia;
    private final Cliente cliente;
    private final String numero;
    private double saldo;
    private final List<Movimentacao> movimentacoes;

    public Conta(String numero, Agencia agencia, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
        
        this.movimentacoes = new ArrayList<>();
    }
    
    public Agencia getAgencia() {
        return this.agencia;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public List<Movimentacao> getMovimentacoes() {
        return this.movimentacoes;
    }

    public void addMovimentacao(Movimentacao movimentacao) {
        this.movimentacoes.add(movimentacao);
    }

    public void saque(final double valor) throws Exception {
        if(valor <= 0)
            throw new Exception("Valor deve ser maior que 0!");
        if(this.saldo < valor)
            throw new Exception("Saldo insuficiente!");
        
        this.saldo -= valor;
    }

    public void deposito(final double valor) throws Exception {
        if(valor <= 0)
            throw new Exception("Valor deve ser maior que 0!");
        
        this.saldo += valor;
    }

    public String getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

}
