package com.steam;

import java.util.Objects;

public class MainStream {

    public static void main(String[] args){
        operacoesStreamAPI();
    }
    public static void operacoesStreamAPI(){

    }
}

class Contato{
    private String nome;
    private Long numero;

    public Contato(String nome, Long numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public Long getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome) && Objects.equals(numero, contato.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, numero);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}
