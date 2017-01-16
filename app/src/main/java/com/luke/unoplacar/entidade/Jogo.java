package com.luke.unoplacar.entidade;

import java.io.Serializable;

/**
 * Created by Mrluke on 12/01/2017.
 */

public class Jogo implements Serializable {

    private Long id;
    private int numeroPartidas;
    private int qtdJogadores;
    private int mediaPontos;

    public Jogo() {

    }

    public Jogo(int numeroPartidas, int qtdJogadores, int mediaPontos) {
        //this.id = id;
        this.numeroPartidas = numeroPartidas;
        this.qtdJogadores = qtdJogadores;
        this.mediaPontos = mediaPontos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroPartidas() {
        return numeroPartidas;
    }

    public void setNumeroPartidas(int numeroPartidas) {
        this.numeroPartidas = numeroPartidas;
    }

    public int getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(int qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    public int getMediaPontos() {
        return mediaPontos;
    }

    public void setMediaPontos(int mediaPontos) {
        this.mediaPontos = mediaPontos;
    }
}
