package com.comfeco.demo.service.impl;

import com.comfeco.demo.entity.Pais;
import com.comfeco.demo.repository.IPaisRepository;
import com.comfeco.demo.service.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaisServiceImpl implements IPaisService {

    @Autowired
    private IPaisRepository paisRepository;

    @Override
    public Pais registrar(Pais obj) {
        return this.paisRepository.save(obj);
    }

    @Override
    public Pais modificar(Pais obj) {
        return this.paisRepository.save(obj);
    }

    @Override
    public List<Pais> listar() {
        return this.paisRepository.findAll();
    }

    @Override
    public Pais listarPorId(Long aLong) {
        Optional<Pais> op = this.paisRepository.findById(aLong);
        return op.isPresent() ? op.get() : new Pais();
    }

    @Override
    public void eliminar(Long aLong) {
        this.paisRepository.deleteById(aLong);
    }
}
