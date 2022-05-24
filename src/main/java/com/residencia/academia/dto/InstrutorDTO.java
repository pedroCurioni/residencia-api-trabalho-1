package com.residencia.academia.dto;

import com.residencia.academia.entity.Turma;


import java.util.Date;
import java.util.List;

public class InstrutorDTO {
    private Integer idInstrutor;
    private Integer rg;
    private String nomeInstrutor;
    private Date dataNascimento;
    private Integer titulacaoInstrutor;
//    private List<Turma> turmas;

    public Integer getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(Integer idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getNomeInstrutor() {
        return nomeInstrutor;
    }

    public void setNomeInstrutor(String nomeInstrutor) {
        this.nomeInstrutor = nomeInstrutor;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getTitulacaoInstrutor() {
        return titulacaoInstrutor;
    }

    public void setTitulacaoInstrutor(Integer titulacaoInstrutor) {
        this.titulacaoInstrutor = titulacaoInstrutor;
    }
}
