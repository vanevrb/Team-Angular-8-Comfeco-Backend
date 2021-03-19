package com.comfeco.demo.service.impl;

import com.comfeco.demo.entity.Perfil;
import com.comfeco.demo.entity.Usuario;
import com.comfeco.demo.repository.IPerfilRepository;
import com.comfeco.demo.repository.IUsuarioRepository;
import com.comfeco.demo.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilServiceImpl implements IPerfilService {

    @Autowired
    private IPerfilRepository perfilRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

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

    @Transactional
    @Override
    public Perfil cambiarAvatar(String url) {
            Usuario u = this.usuarioRepository.findUsuarioByUsuCorreo(SecurityContextHolder.getContext().getAuthentication().getName());
            if(u.getUsuId() != null){
                this.perfilRepository.cambiarAvatar(url, u.getPerfil().getIdPerfil());
                return u.getPerfil();
            } else{
                return new Perfil();
            }
    }
}
