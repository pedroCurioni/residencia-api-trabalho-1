package com.residencia.academia.repositorio;

import com.residencia.academia.entity.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepositorio extends JpaRepository<Atividade, Integer> {
}
