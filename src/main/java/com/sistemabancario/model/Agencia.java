package com.sistemabancario.model;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

    private final List<Conta> contas;
    private final String numero;

    public Agencia(String numero) {
        this.numero = numero;
        this.contas = new ArrayList();
    }
    
    public String getNumero() {
        return numero;
    }

    public boolean contains(Object o) {
        return this.contas.contains(o);
    }

    public boolean addConta(Conta e) {
        return this.contas.add(e);
    }

    public boolean remove(Object o) {
        return this.contas.remove(o);
    }
    
    public int getNumeroDeContas() {
        return this.contas.size();
    }
}
