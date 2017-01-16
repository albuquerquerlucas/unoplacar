package com.luke.unoplacar.entidade;

import java.io.Serializable;

/**
 * Created by Mrluke on 12/01/2017.
 */

public class Jogador implements Serializable {

    private Long id;
    private String nome;
    private int pontuacao;
    private int isNovo;

    public Jogador() {
    }

    public Jogador(String nome, int pontuacao, int isNovo) {
        //this.id = id;
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.isNovo = isNovo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getIsNovo() {
        return isNovo;
    }

    public void setIsNovo(int isNovo) {
        this.isNovo = isNovo;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
