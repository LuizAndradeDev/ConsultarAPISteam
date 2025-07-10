package com.br.luizdev.Modelo.ObjetosModel;

import com.br.luizdev.Modelo.JsonModels.JogoInformacoes;

import java.util.List;

public class Jogo {
    private String nome;
    private List<String> distribuidoras;
    private Double precoOriginal;
    private Double precoAtual;

    public Jogo(JogoInformacoes jogoInfo) {
        this.nome = jogoInfo.nome();
        this.distribuidoras = jogoInfo.distribuidora();
        this.precoOriginal = jogoInfo.preco().precoOriginal() / 100.0;

        if (jogoInfo.preco().precoAtual() == 0) {
            this.precoAtual = jogoInfo.preco().precoOriginal() / 100.0;
        } else {
            this.precoAtual = jogoInfo.preco().precoAtual() / 100.0;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getDistribuidoras() {
        return distribuidoras;
    }

    public void setDistribuidoras(List<String> distribuidoras) {
        this.distribuidoras = distribuidoras;
    }

    public Double getPrecoOriginal() {
        return precoOriginal;
    }

    public void setPrecoOriginal(Double precoOriginal) {
        this.precoOriginal = precoOriginal;
    }

    public Double getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(Double precoAtual) {
        this.precoAtual = precoAtual;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "nome='" + nome + '\'' +
                ", distribuidoras=" + distribuidoras +
                ", precoOriginal=" + precoOriginal +
                ", precoAtual=" + precoAtual +
                '}';
    }
}
