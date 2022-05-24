package com.residencia.academia.repositorio;

import com.residencia.academia.entity.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepositorio extends JpaRepository<Instrutor, Integer> {
}
