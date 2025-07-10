package com.br.luizdev.Modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDoJogo(
        @JsonAlias("success") boolean sucesso,
        @JsonAlias("data") JogoInformacoes data) {
}
