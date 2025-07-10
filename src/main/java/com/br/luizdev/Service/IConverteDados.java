package com.br.luizdev.Service;

import com.fasterxml.jackson.core.type.TypeReference;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);

    <T> T obterDadosMap(String json, TypeReference<T> typeReference);

}
