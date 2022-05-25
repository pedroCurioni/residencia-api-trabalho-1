package com.residencia.academia.service;

import com.residencia.academia.dto.AtividadeDTO;
import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Atividade;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repositorio.AtividadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtividadeService {
    @Autowired
    private AtividadeRepositorio atividadeRepositorio;

    public List<Atividade> findAll() {
        return atividadeRepositorio.findAll();
    }

    public AtividadeDTO findDTOById(Integer id) {
        Atividade atividade = atividadeRepositorio.findById(id).isPresent() ? atividadeRepositorio.findById(id).get() : null;

        AtividadeDTO atividadeDTO = new AtividadeDTO();
        if (null != atividade) {
            atividadeDTO = EntityToTDO(atividade);
        }
        return atividadeDTO;
    }

    public Atividade findById(Integer id) {
        return atividadeRepositorio.findById(id).isPresent() ? atividadeRepositorio.findById(id).get() : null;
    }

    public AtividadeDTO saveDTO(AtividadeDTO atividadeDTO) {
        Atividade novaAtividade = new Atividade();
        if (null != atividadeDTO) {
            novaAtividade = DTOToEntity(atividadeDTO);
            atividadeRepositorio.save(novaAtividade);
        }
        return EntityToTDO(novaAtividade);
    }

    public Atividade save(Atividade atividade) {
        return atividadeRepositorio.save(atividade);
    }

    public Atividade update(Atividade atividade) {
        return atividadeRepositorio.save(atividade);
    }

    public void delete(Integer id) {
        atividadeRepositorio.deleteById(id);
    }

    private AtividadeDTO EntityToTDO(Atividade atividade) {
        AtividadeDTO atividadeDTO = new AtividadeDTO();
        atividadeDTO.setIdAtividade(atividade.getIdAtividade());
        atividadeDTO.setNome(atividade.getNome());

        return atividadeDTO;
    }

    private Atividade DTOToEntity(AtividadeDTO atividadeDTO) {
        Atividade atividade = new Atividade();
        atividade.setIdAtividade(atividadeDTO.getIdAtividade());
        atividade.setNome(atividadeDTO.getNome());

        return atividade;
    }
}
