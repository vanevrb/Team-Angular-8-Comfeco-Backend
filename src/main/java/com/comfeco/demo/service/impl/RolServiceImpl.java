package com.comfeco.demo.service.impl;

import com.comfeco.demo.entity.Rol;
import com.comfeco.demo.repository.IRolRepository;
import com.comfeco.demo.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolRepository rolRepository;

    @Override
    public Rol registrar(Rol obj) {
        return rolRepository.save(obj);
    }

    @Override
    public Rol modificar(Rol obj) {
        return rolRepository.save(obj);
    }

    @Override
    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    @Override
    public Rol listarPorId(Integer integer) {
        Optional<Rol> op = rolRepository.findById(integer);
        return op.isPresent() ? op.get() : new Rol();
    }

    @Override
    public void eliminar(Integer integer) {
        rolRepository.deleteById(integer);
    }
}
