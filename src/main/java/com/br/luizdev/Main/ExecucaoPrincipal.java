package com.br.luizdev.Main;

import com.br.luizdev.Modelo.Jogo;
import com.br.luizdev.Modelo.JogoDadosBusca;
import com.br.luizdev.Service.ConsumoAPI;
import com.br.luizdev.Service.ConverteDados;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ExecucaoPrincipal {
    public record AppListWrapper(@JsonAlias("applist") AppList appList) {}
    public record AppList(@JsonAlias("apps") List<JogoDadosBusca> apps) {}

    private ConverteDados converter = new ConverteDados();
    private ConsumoAPI buscar = new ConsumoAPI();
    private final String listaDeJogos = "https://api.steampowered.com/ISteamApps/GetAppList/v2/";
    private final String dadosDeJogos = "https://store.steampowered.com/api/appdetails?appids=";


    public void Iniciar(){
    var json = buscar.obterDados(listaDeJogos);

    AppListWrapper wrapper = converter.obterDados(json, AppListWrapper.class);
    List<JogoDadosBusca> jogos = wrapper.appList().apps();

    jogos.stream().limit(10).forEach(System.out::println);


    }

}
