package com.sistemabancario.model;

import java.util.Objects;

public class Movimentacao {

    private String descricao;
    private final Conta conta;
    private final TipoMovimentacao tipo;
    private final double valor;
    private boolean confirmada;

    public Movimentacao(Conta conta, TipoMovimentacao tipo, double valor){
        this.conta = conta;
        this.tipo = tipo;
        this.valor = valor;
    }
    
    public Conta getConta() {
        return this.conta;
    }

    public TipoMovimentacao getTipo(){
        return tipo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws Exception {
        Objects.requireNonNull(descricao, "Descrição não pode ser nula.");

        if(descricao.trim().isEmpty()){
            throw new Exception("Descrição não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

}
