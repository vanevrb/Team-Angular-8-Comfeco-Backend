package com.comfeco.demo.service.impl;

import com.comfeco.demo.dto.request.ChangePasswordDTO;
import com.comfeco.demo.entity.Usuario;
import com.comfeco.demo.repository.IUsuarioRepository;
import com.comfeco.demo.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Value("${comfeco.default-rol}")
    private Integer DEFAULT_ROL;

    @Transactional
    @Override
    public Usuario registrarTransaccional(Usuario u) {
        Usuario user;
        try {
            user = usuarioRepository.save(u);
            usuarioRepository.registrarRolPorDefecto(user.getUsuId(), DEFAULT_ROL);
        } catch (Exception e){
            throw e;
        }
        return user;
    }

    @Override
    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findUsuarioByUsuCorreo(correo);
    }

    @Override
    public Usuario findByNickname(String nickname) {
        return usuarioRepository.findUsuarioByUsuNickname(nickname);
    }

    @Override
    public Page<Usuario> listar(Pageable page) {
        return usuarioRepository.findAll(page);
    }

    @Transactional
    @Override
    public void actualizarClaveTransaccional(ChangePasswordDTO dto) {
        usuarioRepository.actualizarClave(dto.clave, dto.tokenId);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findUsuarioByUsuCorreo(username);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("El usuario no existe", username));
        }
        List<GrantedAuthority> roles = new ArrayList<>();

        user.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getRolTitulo()));
        });

        UserDetails userDetails = new User(user.getUsuCorreo(), user.getUsuClave(), user.getUsuEstado(), true, true, true, roles);
        
        return userDetails;
    }
}
