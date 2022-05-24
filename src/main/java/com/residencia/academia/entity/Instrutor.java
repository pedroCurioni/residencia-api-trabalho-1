package com.residencia.academia.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "instrutor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idInstrutor")
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instrutor")
    private Integer idInstrutor;

    @Column(name = "rg")
    private Integer rg;

    @Column(name = "nome")
    private String nomeInstrutor;

    @Column(name = "nascimento")
    private Date dataNascimento;

    @Column(name = "titulacao")
    private Integer titulacaoInstrutor;

    @OneToMany(mappedBy = "instrutor")
    private List<Turma> turmas;

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

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
