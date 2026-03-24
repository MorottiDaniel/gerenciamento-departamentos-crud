package com.morotti.departamentos.controller;

import com.morotti.departamentos.entity.DepartamentosEntity;
import com.morotti.departamentos.service.DepartamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/departamentos")
public class DepartamentosController {
    @Autowired
    private DepartamentosService departamentosService;

    @PostMapping
    public ResponseEntity<DepartamentosEntity> criarDepartamento(@RequestBody DepartamentosEntity entity) {
        DepartamentosEntity departamento = departamentosService.criarDepartamento(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(departamento.getId()).toUri();
        return ResponseEntity.created(uri).body(departamento);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentosEntity>> findAll(){
        List<DepartamentosEntity> entities = departamentosService.findAll();
        return ResponseEntity.ok().body(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentosEntity> buscaPorId(@PathVariable Long id){
        try {
            DepartamentosEntity entity = departamentosService.buscarPorId(id);
            return ResponseEntity.ok().body(entity);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        departamentosService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
