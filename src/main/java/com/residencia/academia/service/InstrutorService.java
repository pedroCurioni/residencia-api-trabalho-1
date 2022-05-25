package com.residencia.academia.service;


import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repositorio.InstrutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstrutorService {
    @Autowired
    InstrutorRepositorio instrutorRepositorio;

    public List<Instrutor> findAll() {
        return instrutorRepositorio.findAll();
    }

    public InstrutorDTO findDTOById(Integer id) {
        Instrutor instrutor = instrutorRepositorio.findById(id).isPresent() ? instrutorRepositorio.findById(id).get() : null;

        InstrutorDTO instrutorDTO = new InstrutorDTO();
        if (null != instrutor) {
            instrutorDTO = EntityToTDO(instrutor);
        }
        return instrutorDTO;
    }

    public Instrutor findById(Integer id) {
        return instrutorRepositorio.findById(id).isPresent() ? instrutorRepositorio.findById(id).get() : null;
    }

    public InstrutorDTO saveDTO(InstrutorDTO instrutorDTO) {
        Instrutor novoInstrutor = new Instrutor();
        if (null != instrutorDTO) {
            novoInstrutor = DTOToEntity(instrutorDTO);
            instrutorRepositorio.save(novoInstrutor);
        }
        return EntityToTDO(novoInstrutor);
    }

    public Instrutor save(Instrutor instrutor) {
        return instrutorRepositorio.save(instrutor);
    }

    public Instrutor update(Instrutor instrutor) {
        return instrutorRepositorio.save(instrutor);
    }

    public void delete(Integer id) {
        instrutorRepositorio.deleteById(id);
    }

    private InstrutorDTO EntityToTDO(Instrutor instrutor) {
        InstrutorDTO instrutorDTO = new InstrutorDTO();
        instrutorDTO.setIdInstrutor(instrutor.getIdInstrutor());
        instrutorDTO.setRg(instrutor.getRg());
        instrutorDTO.setNomeInstrutor(instrutor.getNomeInstrutor());
        instrutorDTO.setDataNascimento(instrutor.getDataNascimento());
        instrutorDTO.setTitulacaoInstrutor(instrutor.getTitulacaoInstrutor());

        if (instrutor.getTurmas() != null) {
            List<TurmaDTO> listTurmaDTO = new ArrayList<>();
            for (Turma turma : instrutor.getTurmas()) {
                TurmaDTO turmaDTO = new TurmaDTO();
                turmaDTO.setIdTurma(turma.getIdTurma());
                turmaDTO.setHorarioTurma(turma.getHorarioTurma());
                turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
                turmaDTO.setDataInicio(turma.getDataInicio());
                turmaDTO.setDataFim(turma.getDataFim());

                listTurmaDTO.add(turmaDTO);
            }
            instrutorDTO.setTurmaDTOList(listTurmaDTO);
        }
        return instrutorDTO;
    }

    private Instrutor DTOToEntity(InstrutorDTO instrutorDTO) {
        Instrutor instrutor = new Instrutor();
        instrutor.setIdInstrutor(instrutorDTO.getIdInstrutor());
        instrutor.setRg(instrutorDTO.getRg());
        instrutor.setNomeInstrutor(instrutorDTO.getNomeInstrutor());
        instrutor.setDataNascimento(instrutorDTO.getDataNascimento());
        instrutor.setTitulacaoInstrutor(instrutorDTO.getTitulacaoInstrutor());

        return instrutor;
    }
}
