package com.residencia.academia.service;

import com.residencia.academia.dto.AtividadeDTO;
import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Atividade;
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

        if (turma.getInstrutor() != null) {
            Instrutor instrutor = turma.getInstrutor();
            InstrutorDTO instrutorDTO = new InstrutorDTO();

            instrutorDTO.setIdInstrutor(instrutor.getIdInstrutor());
            instrutorDTO.setRg(instrutor.getRg());
            instrutorDTO.setNomeInstrutor(instrutor.getNomeInstrutor());
            instrutorDTO.setDataNascimento(instrutor.getDataNascimento());
            instrutorDTO.setTitulacaoInstrutor(instrutor.getTitulacaoInstrutor());
        }

        if (turma.getAtividade() != null) {
            Atividade atividade = turma.getAtividade();
            AtividadeDTO atividadeDTO = new AtividadeDTO();

            atividadeDTO.setIdAtividade(atividade.getIdAtividade());
            atividadeDTO.setNome(atividade.getNome());
        }
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
