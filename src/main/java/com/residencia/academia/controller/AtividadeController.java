package com.residencia.academia.controller;

import com.residencia.academia.entity.Atividade;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {
    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public ResponseEntity<List<Atividade>> findAll() {
        return new ResponseEntity<>(atividadeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atividade> findById(@PathVariable Integer id) {
        Atividade atividade = atividadeService.findById(id);
        if (null == atividade) {
            throw  new NoSuchElementFoundException("Não foi encontrada a Atividade com o id " + id);
        } else {
            return new ResponseEntity<>(atividade, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Atividade> save(@RequestBody Atividade atividade) {
        return new ResponseEntity<>(atividadeService.update(atividade), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Atividade> update(@RequestBody Atividade atividade) {
        return new ResponseEntity<>(atividadeService.update(atividade), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (null == atividadeService.findById(id)) {
            throw new NoSuchElementFoundException("Não foi encontrada a Atividade com o id " + id);
        } else {
            atividadeService.delete(id);
            return new ResponseEntity<>("Atividade " + id + " deletada com exito", HttpStatus.OK);
        }
    }
}
