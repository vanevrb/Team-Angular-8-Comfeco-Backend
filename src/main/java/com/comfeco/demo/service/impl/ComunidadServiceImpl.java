package com.comfeco.demo.service.impl;

import com.comfeco.demo.entity.Comunidad;
import com.comfeco.demo.repository.IComunidadRepository;
import com.comfeco.demo.service.IComunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComunidadServiceImpl implements IComunidadService {

    @Autowired
    private IComunidadRepository comunidadRepository;

    @Override
    public Comunidad registrar(Comunidad obj) {
        return this.comunidadRepository.save(obj);
    }

    @Override
    public Comunidad modificar(Comunidad obj) {
        return this.comunidadRepository.save(obj);
    }

    @Override
    public List<Comunidad> listar() {
        return this.comunidadRepository.findAll();
    }

    @Override
    public Comunidad listarPorId(Long aLong) {
        Optional<Comunidad> op = this.comunidadRepository.findById(aLong);
        return op.isPresent() ? op.get() : new Comunidad();
    }

    @Override
    public void eliminar(Long aLong) {
        this.comunidadRepository.deleteById(aLong);
    }
}
