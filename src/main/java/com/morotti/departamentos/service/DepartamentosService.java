package com.morotti.departamentos.service;

import com.morotti.departamentos.entity.DepartamentosEntity;
import com.morotti.departamentos.repository.DepartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentosService {
    @Autowired
    private DepartamentosRepository departamentosRepository;

    public DepartamentosEntity criarDepartamento(DepartamentosEntity entity){
        return departamentosRepository.save(entity);
    }

    public List<DepartamentosEntity> findAll(){
        return departamentosRepository.findAll();
    }

    public DepartamentosEntity buscarPorId(Long id){
        return departamentosRepository.findById(id).get();
    }

    public void deletar(Long id){
        departamentosRepository.deleteById(id);
    }
}
