package com.sistemabancario.model;

public class Cliente {

    public int idade;
    private String nome;

    public Cliente(String nome, int idade) throws Exception {
        if(idade < 18)
            throw new Exception("Cliente nao possui idade minima!");
        this.nome = nome;
        this.idade = idade;
    }
    
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
