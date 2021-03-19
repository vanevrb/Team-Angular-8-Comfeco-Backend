package com.comfeco.demo.service;

import com.comfeco.demo.entity.Perfil;

public interface IPerfilService extends ICRUD<Perfil, Long> {

    Perfil cambiarAvatar(String url);
}
