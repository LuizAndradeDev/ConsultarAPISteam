package com.br.luizdev.ConsultarAPISteam;

import com.br.luizdev.Main.ExecucaoPrincipal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultarApiSteamApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConsultarApiSteamApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
		ExecucaoPrincipal exec = new ExecucaoPrincipal();
        exec.Iniciar();


    }
}
