package com.br.luizdev.Modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JogoDadosBusca(@JsonAlias("appid") Integer id,
                             @JsonAlias("nome") String nome) {
}
