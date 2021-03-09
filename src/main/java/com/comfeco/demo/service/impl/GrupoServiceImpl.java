package com.comfeco.demo.service.impl;

import com.comfeco.demo.entity.Grupo;
import com.comfeco.demo.repository.IGrupoRepository;
import com.comfeco.demo.service.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoServiceImpl implements IGrupoService {

    @Autowired
    private IGrupoRepository grupoRepository;

    @Override
    public Grupo registrar(Grupo obj) {
        return this.grupoRepository.save(obj);
    }

    @Override
    public Grupo modificar(Grupo obj) {
        return this.grupoRepository.save(obj);
    }

    @Override
    public List<Grupo> listar() {
        return this.grupoRepository.findAll();
    }

    @Override
    public Grupo listarPorId(Long aLong) {
        Optional<Grupo> op = this.grupoRepository.findById(aLong);
        return op.isPresent() ? op.get() : new Grupo();
    }

    @Override
    public void eliminar(Long aLong) {
        this.grupoRepository.deleteById(aLong);
    }
}
