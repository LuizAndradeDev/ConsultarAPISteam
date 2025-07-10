package com.br.luizdev.Modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JogoInformacoes(
        @JsonAlias("name") String nome,
        @JsonAlias("publishers") List<String> distribuidora,
        @JsonAlias("price_overview") PrecoInfo preco) {
}
