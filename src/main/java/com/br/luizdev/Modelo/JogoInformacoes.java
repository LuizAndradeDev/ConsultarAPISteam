package com.br.luizdev.Modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JogoInformacoes(@JsonAlias("name") String nome,
                              @JsonAlias("publishers") String distribuidora,
                              @JsonAlias("initial") int precoOriginal,
                              @JsonAlias("final") int precoAtual,
                              @JsonAlias("discount_percent") int disconto) {
}
