package com.br.luizdev.Modelo.JsonModels;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JogoDadosBusca(@JsonAlias("appid") Integer id,
                             @JsonAlias("name") String nome) {
}
