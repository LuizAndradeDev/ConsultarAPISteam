package com.br.luizdev.Service;

import com.br.luizdev.Modelo.ObjetosModel.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepositorio extends JpaRepository<Jogo, Long> {
}
