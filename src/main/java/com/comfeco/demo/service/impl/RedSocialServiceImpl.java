package com.comfeco.demo.service.impl;

import com.comfeco.demo.entity.RedSocial;
import com.comfeco.demo.repository.IRedSocialRepository;
import com.comfeco.demo.service.IRedSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RedSocialServiceImpl implements IRedSocialService {

    @Autowired
    private IRedSocialRepository redSocialRepository;

    @Override
    public RedSocial registrar(RedSocial obj) {
        return this.redSocialRepository.save(obj);
    }

    @Override
    public RedSocial modificar(RedSocial obj) {
        return this.redSocialRepository.save(obj);
    }

    @Override
    public List<RedSocial> listar() {
        return this.redSocialRepository.findAll();
    }

    @Override
    public RedSocial listarPorId(Long aLong) {
        Optional<RedSocial> op = this.redSocialRepository.findById(aLong);
        return op.isPresent() ? op.get() : new RedSocial();
    }

    @Override
    public void eliminar(Long aLong) {
        this.redSocialRepository.deleteById(aLong);
    }
}
