package com.residencia.academia.service;

import com.residencia.academia.entity.Atividade;
import com.residencia.academia.repositorio.AtividadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {
    @Autowired
    private AtividadeRepositorio atividadeRepositorio;

    public List<Atividade> findAll() {
        return atividadeRepositorio.findAll();
    }

    public Atividade findById(Integer id) {
        return atividadeRepositorio.findById(id).isPresent()?
                atividadeRepositorio.findById(id).get():null;
    }

    public Atividade save (Atividade atividade) {
        return atividadeRepositorio.save(atividade);
    }

    public Atividade update (Atividade atividade) {
        return atividadeRepositorio.save(atividade);
    }

    public void delete(Integer id) {
        atividadeRepositorio.deleteById(id);
    }
}
