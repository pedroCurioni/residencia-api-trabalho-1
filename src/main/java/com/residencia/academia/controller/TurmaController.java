package com.residencia.academia.controller;


import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll() {
        return new ResponseEntity<>(turmaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Integer id) {
        Turma turma = turmaService.findById(id);
        if (null == turma) {
            throw  new NoSuchElementFoundException("Não foi encontrada Turma com o id " + id);
        } else {
            return new ResponseEntity<>(turma, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Turma> save(@RequestBody Turma turma) {
        return new ResponseEntity<>(turmaService.save(turma), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Turma> update(@RequestBody Turma turma) {
        return new ResponseEntity<>(turmaService.update(turma), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (null == turmaService.findById(id)) {
            throw new NoSuchElementFoundException("Não foi encontrada Turma com o id " + id);
        } else {
            turmaService.delete(id);
            return new ResponseEntity<>("Turma " + id + " deletada com exito", HttpStatus.OK);
        }


    }
}
