package com.comfeco.demo.service.impl;

import com.comfeco.demo.entity.Perfil;
import com.comfeco.demo.repository.IPerfilRepository;
import com.comfeco.demo.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilServiceImpl implements IPerfilService {

    @Autowired
    private IPerfilRepository perfilRepository;

    @Override
    public Perfil registrar(Perfil obj) {
        return this.perfilRepository.save(obj);
    }

    @Override
    public Perfil modificar(Perfil obj) {
        return this.perfilRepository.save(obj);
    }

    @Override
    public List<Perfil> listar() {
        return this.perfilRepository.findAll();
    }

    @Override
    public Perfil listarPorId(Long aLong) {
        Optional<Perfil> op = this.perfilRepository.findById(aLong);
        return op.isPresent() ? op.get() : new Perfil();
    }

    @Override
    public void eliminar(Long aLong) {
        this.perfilRepository.deleteById(aLong);
    }
}
