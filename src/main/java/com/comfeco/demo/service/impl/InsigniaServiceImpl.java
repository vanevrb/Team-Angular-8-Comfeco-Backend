package com.comfeco.demo.service.impl;

import com.comfeco.demo.entity.Insignia;
import com.comfeco.demo.repository.IInsigniaRepository;
import com.comfeco.demo.service.IInsigniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsigniaServiceImpl implements IInsigniaService {

    @Autowired
    private IInsigniaRepository insigniaRepository;

    @Override
    public Insignia registrar(Insignia obj) {
        return this.insigniaRepository.save(obj);
    }

    @Override
    public Insignia modificar(Insignia obj) {
        return this.insigniaRepository.save(obj);
    }

    @Override
    public List<Insignia> listar() {
        return this.insigniaRepository.findAll();
    }

    @Override
    public Insignia listarPorId(Long aLong) {
        Optional<Insignia> op = this.insigniaRepository.findById(aLong);
        return op.isPresent() ? op.get() : new Insignia();
    }

    @Override
    public void eliminar(Long aLong) {
        this.insigniaRepository.deleteById(aLong);
    }
}
