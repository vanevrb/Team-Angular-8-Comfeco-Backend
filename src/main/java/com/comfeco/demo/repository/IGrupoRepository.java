package com.comfeco.demo.repository;

import com.comfeco.demo.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGrupoRepository extends JpaRepository<Grupo, Long> {

    @Query("SELECT g FROM Perfil p JOIN p.grupos g where g.perfiles in(?1)")
    List<Grupo> buscarGruposUsuario(Long id);
}
