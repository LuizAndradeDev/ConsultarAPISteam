package com.br.luizdev.Main;

import com.br.luizdev.Modelo.JsonModels.DadosDoJogo;
import com.br.luizdev.Modelo.JsonModels.JogoDadosBusca;
import com.br.luizdev.Modelo.JsonModels.JogoInformacoes;
import com.br.luizdev.Modelo.ObjetosModel.Jogo;
import com.br.luizdev.Service.ConsumoAPI;
import com.br.luizdev.Service.ConverteDados;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private List<Jogo> listaDeFavoritos = new ArrayList<>();



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


        json = buscar.obterDados(dadosDeJogos + idSelect);
        Map<String, DadosDoJogo> mapa = converter.obterDadosMap(json, new TypeReference<>() {
        });
        JogoInformacoes jogoInfo = mapa.values().stream().findFirst().orElseThrow().data();

        Jogo jogo = new Jogo(jogoInfo);

        System.out.println("#################" +
                "\nNome: " + jogo.getNome() +
                "\nDistribuidoras: " + jogo.getDistribuidoras() +
                "\nPreço original: R$ " + jogo.getPrecoOriginal() +
                "\nPreço atual: R$ " + jogo.getPrecoAtual() +
                "\n#################");

        System.out.println("\nDeseja adicionar esse jogo aos favoritos? " +
                "\n1 -- SIM" +
                "\n2 -- NÂO");
        int numero;
        if ((numero = scanner.nextInt()) == 1) {
            listaDeFavoritos.add(jogo);
            System.out.println("Jogo adicionado");
        }
        scanner.nextLine();

    }

    public void ExibirFavoritos() {
        listaDeFavoritos.stream().forEach(lf -> System.out.println("Nome: " + lf.getNome()
                + "\nPreço Atual: " + lf.getPrecoAtual() + "\n########"));
    }

    public void ExibirMenu(){
        System.out.println("######-Menu-######" +
                "\n1 -- Pesquisar Jogo" +
                "\n2 -- Exibir Favoritos" +
                "\n3 -- Sair " +
                "\n################");
    }
}
