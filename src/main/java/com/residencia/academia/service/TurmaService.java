package com.residencia.academia.service;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repositorio.TurmaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {
    @Autowired
    TurmaRepositorio turmaRepositorio;

    public List<Turma> findAll() {
        return turmaRepositorio.findAll();
    }

    public TurmaDTO findDTOById(Integer id) {
        Turma turma = turmaRepositorio.findById(id).isPresent() ? turmaRepositorio.findById(id).get() : null;

        TurmaDTO turmaDTO = new TurmaDTO();
        if (null != turma) {
            turmaDTO = EntityToTDO(turma);
        }

        return turmaDTO;
    }

    public Turma findById(Integer id) {
        return turmaRepositorio.findById(id).isPresent() ? turmaRepositorio.findById(id).get() : null;
    }

    public TurmaDTO saveDTO(TurmaDTO instrutorDTO) {
        Turma novaTurma = new Turma();
        if (null != instrutorDTO) {
            novaTurma = DTOToEntity(instrutorDTO);
            turmaRepositorio.save(novaTurma);
        }
        return EntityToTDO(novaTurma);
    }

    public Turma save(Turma turma) {
        return turmaRepositorio.save(turma);
    }

    public Turma update(Turma turma) {
        return turmaRepositorio.save(turma);
    }

    public void delete(Integer id) {
        turmaRepositorio.deleteById(id);
    }

    private TurmaDTO EntityToTDO(Turma turma) {
        TurmaDTO turmaDTO = new TurmaDTO();
        turmaDTO.setIdTurma(turma.getIdTurma());
        turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
        turmaDTO.setHorarioTurma(turma.getHorarioTurma());
        turmaDTO.setDataFim(turma.getDataInicio());
        turmaDTO.setDataInicio(turma.getDataFim());

        return turmaDTO;
    }

    private Turma DTOToEntity(TurmaDTO turmaDTO) {
        Turma turma = new Turma();
        turma.setIdTurma(turmaDTO.getIdTurma());
        turma.setDuracaoTurma(turmaDTO.getDuracaoTurma());
        turma.setHorarioTurma(turmaDTO.getHorarioTurma());
        turma.setDataFim(turmaDTO.getDataInicio());
        turma.setDataInicio(turmaDTO.getDataFim());

        return turma;
    }
}
