package com.comfeco.demo.service;

import com.comfeco.demo.dto.request.ChangePasswordDTO;
import com.comfeco.demo.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUsuarioService {

    Usuario registrarTransaccional(Usuario u);
    Usuario findByCorreo(String correo);
    Page<Usuario> listar(Pageable page);
    void actualizarClaveTransaccional(ChangePasswordDTO dto);


}
