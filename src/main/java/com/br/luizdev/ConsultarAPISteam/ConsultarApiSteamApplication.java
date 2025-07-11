package com.br.luizdev.ConsultarAPISteam;

import com.br.luizdev.Main.ExecucaoPrincipal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ConsultarApiSteamApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConsultarApiSteamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		ExecucaoPrincipal exec = new ExecucaoPrincipal();
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        while (escolha != 3) {
            exec.ExibirMenu();
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    exec.Iniciar();
                    break;
                case 2:
                    exec.ExibirFavoritos();
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }



    }
}
