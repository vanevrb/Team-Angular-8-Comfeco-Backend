package com.comfeco.demo.service.impl;

import com.comfeco.demo.entity.Conocimiento;
import com.comfeco.demo.repository.IConocimientoRepository;
import com.comfeco.demo.service.IConocimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConocimientoServiceImpl implements IConocimientoService {

    @Autowired
    private IConocimientoRepository conocimientoRepository;

    @Override
    public Conocimiento registrar(Conocimiento obj) {
        return this.conocimientoRepository.save(obj);
    }

    @Override
    public Conocimiento modificar(Conocimiento obj) {
        return this.conocimientoRepository.save(obj);
    }

    @Override
    public List<Conocimiento> listar() {
        return this.conocimientoRepository.findAll();
    }

    @Override
    public Conocimiento listarPorId(Long aLong) {
        Optional<Conocimiento> op = this.conocimientoRepository.findById(aLong);
        return op.isPresent() ? op.get() : new Conocimiento();
    }

    @Override
    public void eliminar(Long aLong) {
        this.conocimientoRepository.deleteById(aLong);
    }
}
