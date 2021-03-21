package com.comfeco.demo.service;

import com.comfeco.demo.entity.Grupo;

import java.util.List;

public interface IGrupoService extends ICRUD<Grupo, Long> {

    List<Grupo> buscarGruposUsuario();
}
