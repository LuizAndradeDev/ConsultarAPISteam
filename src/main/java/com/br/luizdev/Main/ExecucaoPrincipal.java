package com.br.luizdev.Main;

import com.br.luizdev.Modelo.Jogo;
import com.br.luizdev.Modelo.JogoDadosBusca;
import com.br.luizdev.Modelo.JogoInformacoes;
import com.br.luizdev.Service.ConsumoAPI;
import com.br.luizdev.Service.ConverteDados;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExecucaoPrincipal {
    public record AppListWrapper(@JsonAlias("applist") AppList appList) {
    }

    public record AppList(@JsonAlias("apps") List<JogoDadosBusca> apps) {
    }

    private Scanner scanner = new Scanner(System.in);
    private ConverteDados converter = new ConverteDados();
    private ConsumoAPI buscar = new ConsumoAPI();
    private final String listaDeJogos = "https://api.steampowered.com/ISteamApps/GetAppList/v2/";
    private final String dadosDeJogos = "https://store.steampowered.com/api/appdetails?appids=";


    public void Iniciar() {
        var json = buscar.obterDados(listaDeJogos);

        AppListWrapper wrapper = converter.obterDados(json, AppListWrapper.class);
        List<JogoDadosBusca> jogos = wrapper.appList().apps();



        System.out.print("Digite o nome do jogo: ");
        String busca = scanner.nextLine().toLowerCase();

        jogos.stream()
                .filter(j -> j.nome().toLowerCase().contains(busca))
                .forEach(j -> System.out.println("ID: " + j.id() + " | Nome: " + j.nome()));

        System.out.println("Digite o ID do jogo desejado: ");
        String idSelect = scanner.nextLine();
        String api = dadosDeJogos + idSelect;
        System.out.println(api);

        json = buscar.obterDados(dadosDeJogos + idSelect);
        JogoInformacoes jogoInfo = converter.obterDados(json, JogoInformacoes.class);

        System.out.println("#################" +
                "\nNome: " + jogoInfo.nome() +
                "\nDistribuidoras: " + jogoInfo.distribuidora() +
                "\nPreço original: " + jogoInfo.precoOriginal() +
                "\nPreço atual: " + jogoInfo.precoAtual() +
                "\n#################");


    }

}
