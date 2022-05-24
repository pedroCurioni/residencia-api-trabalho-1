package com.residencia.academia.dto;

import com.residencia.academia.entity.Turma;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class AtividadeDTO {
    private Integer idAtividade;
    private String nome;
//    private List<Turma> turmas;

    public Integer getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Integer idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
