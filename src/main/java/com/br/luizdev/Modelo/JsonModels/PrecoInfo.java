package com.br.luizdev.Modelo.JsonModels;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PrecoInfo(
        @JsonAlias("initial") int precoOriginal,
        @JsonAlias("final") int precoAtual,
        @JsonAlias("discount_percent") int desconto) {
}