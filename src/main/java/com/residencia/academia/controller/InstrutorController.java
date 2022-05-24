package com.residencia.academia.controller;

import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {
    @Autowired
    private InstrutorService instrutorService;

    @GetMapping
    public ResponseEntity<List<Instrutor>> findAll() {
        List<Instrutor> instrutorList = instrutorService.findAll();
        return new ResponseEntity<>(instrutorList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrutor> findById(@PathVariable Integer id) {
        Instrutor instrutor = instrutorService.findById(id);
        if (null == instrutor) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(instrutor, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Instrutor> save(@RequestBody Instrutor instrutor) {
        return new ResponseEntity<>(instrutorService.save(instrutor), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Instrutor> update(@RequestBody Instrutor instrutor) {
        return new ResponseEntity<>(instrutorService.update(instrutor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        instrutorService.delete(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
