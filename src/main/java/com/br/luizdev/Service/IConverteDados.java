package com.br.luizdev.Service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
